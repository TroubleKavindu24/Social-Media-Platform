package com.social.socialweb.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.social.socialweb.config.JwtProvider;
import com.social.socialweb.models.User;
import com.social.socialweb.repository.UserRepository;
import com.social.socialweb.request.LoginRequest;
import com.social.socialweb.response.AuthResponse;
//import com.social.socialweb.service.UserService;
import com.social.socialweb.service.CustomerUserDetailsService;



@RestController
@RequestMapping("/auth")
public class AuthController {

    // @Autowired
    // private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private CustomerUserDetailsService customerUserDetails;

    @PostMapping("/signup")
    public AuthResponse createUser(@RequestBody User user) throws Exception{

        User isExist = userRepository.findByEmail(user.getEmail());

        if (isExist!=null) {
            throw new Exception("Email already used with another account");
        }
        User newUser = new User();
        
        newUser.setEmail(user.getEmail());
        newUser.setFirstName(user.getFirstName());
        newUser.setLastName(user.getLastName());
        newUser.setPassword(passwordEncoder.encode(user.getPassword()));

        User savedUser = userRepository.save(newUser);
        Authentication authentication = new UsernamePasswordAuthenticationToken(savedUser.getEmail(), savedUser.getPassword());
        
        String token = JwtProvider.generateToken(authentication);
    
        AuthResponse res = new AuthResponse(token, "Register Success");

        return res;
    }

    //auth/signin
    @PostMapping("/signin")
    public AuthResponse signin(@RequestBody LoginRequest loginRequest){
        Authentication authentication = authentication(loginRequest.getEmail(), loginRequest.getPassword());
        
        String token = JwtProvider.generateToken(authentication);
    
        AuthResponse res = new AuthResponse(token, "Login Success");

        return res;
    }
    private Authentication authentication(String email, String password) {
        UserDetails userDetails = customerUserDetails.loadUserByUsername(email);

        if (userDetails==null) {
            throw new BadCredentialsException("Invalid Username");
        }

        if (!passwordEncoder.matches(password, userDetails.getPassword())) {
            throw new BadCredentialsException("Password not matched");
        }
        return new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
    }
    
}



