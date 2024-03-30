package com.social.socialweb.controller;

import java.util.List;
// import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    @PostMapping("/users")
    public User createUser(@RequestBody User user){

        User savedUser = userService.registerUser(user);

        return savedUser;
    }

    @GetMapping("/users")
    public List<User> getUsers(){
        List<User> users = userRepository.findAll();

        return users;
    }



    // public List<User> getUsers(){
    //     List<User> users = new ArrayList<>();

    //     User user1 = new User(1,"kkkkk","rrrrrr","kkrr@gmail.com","kk1122");
    //     User user2 = new User(2,"kkeek","rreerr","kkrreee@gmail.com","kkee1122");

    //     users.add(user1);
    //     users.add(user2);
        
    //     return users;
    // }

    @GetMapping("/users/{userId}")
    public User getUsersById(@PathVariable("userId") Integer id) throws Exception{
        User user = userService.findUserById(id);

        return user;
       
    }

    @PutMapping("/users/{userId}")
    public User updateUser(@RequestBody User user, @PathVariable Integer userId)throws Exception{

        User updateUser = userService.updateUser(user, userId);

        return updateUser;
    }

    // @DeleteMapping("/users/{userId}")
    // public String deleteUser(@PathVariable("userId") Integer userId)throws Exception{
        
    //     Optional<User> user = userRepository.findById(userId);

    //     if(user.isEmpty()){
    //         throw new Exception("User not exist with id "+userId);
    //     }

    //     userRepository.delete(user.get());

    //     return "User deleted ! "+userId;
    // }

    @PutMapping("/users/{userId1}/{userId2}")
    public User followUserHandler(@PathVariable Integer userId1, @PathVariable Integer userId2)throws Exception{

        User user = userService.followUser(userId1, userId2);
        return user;
    }
}
