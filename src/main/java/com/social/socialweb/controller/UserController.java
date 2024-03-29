package com.social.socialweb.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.social.socialweb.models.User;

@RestController
public class UserController {

    @GetMapping("/users")
    public List<User> getUsers(){
        List<User> users = new ArrayList<>();

        User user1 = new User("kkkkk","rrrrrr","kkrr@gmail.com","kk1122");
        User user2 = new User("kkeek","rreerr","kkrreee@gmail.com","kkee1122");

        users.add(user1);
        users.add(user2);
        
        return users;
    }
    
}
