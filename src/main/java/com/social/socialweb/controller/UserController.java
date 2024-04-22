package com.social.socialweb.controller;

import java.util.List;
// import java.util.Optional;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.social.socialweb.models.User;
import com.social.socialweb.repository.UserRepository;
import com.social.socialweb.service.UserService;

@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserService userService;

    //done
    // @PostMapping("/users")
    // public User createUser(@RequestBody User user){

    //     User savedUser = userService.registerUser(user);

    //     return savedUser;
    // }

    //done
    @GetMapping("/api/users")
    public List<User> getUsers(){
        List<User> users = userRepository.findAll();

        return users;
    }

    //done
    @GetMapping("/api/users/{userId}")
    public User getUsersById(@PathVariable("userId") Integer id) throws Exception{
        
        User user = userService.findUserById(id);

        return user;
       
    }

    //done
    @PutMapping("/api/users")
    public User updateUser(@RequestHeader("Authorization")String jwt,@RequestBody User user)throws Exception{

        User reqUser = userService.findUserByJwt(jwt);

        //User reqUser = userService.findUserByJwt(jwt);
        User updateUser = userService.updateUser(user, reqUser.getId());

        return updateUser;
    }

    @DeleteMapping("/api/users/{userId}")
    public String deleteUser(@PathVariable("userId") Integer userId)throws Exception{
        
        Optional<User> user = userRepository.findById(userId);

        if(user.isEmpty()){
            throw new Exception("User not exist with id "+userId);
        }

        userRepository.delete(user.get());

        return "User deleted ! "+userId;
    }

    @PutMapping("/api/users/follow/{userId2}")
    public User followUserHandler(@RequestHeader("Authorization") String jwt,@PathVariable Integer userId2)throws Exception{

        User regUser = userService.findUserByJwt(jwt);
        User user = userService.followUser(regUser.getId(), userId2);

        return user;
    }

    @GetMapping("/api/users/search")
    public List<User>searchUser(@RequestParam("query")String query){
        List<User> users = userService.searchUser(query);
        
        return users;
    }

    @GetMapping("/api/users/profile")
    public User getUserFromToken(@RequestHeader("Authorization") String jwt){

        // String email = 
        // System.out.println("JWT--------"+jwt);
        User user = userService.findUserByJwt(jwt);
        user.setPassword(null);

        return user;
    }
}
