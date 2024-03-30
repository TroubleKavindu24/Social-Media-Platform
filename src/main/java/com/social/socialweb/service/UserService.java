package com.social.socialweb.service;

import java.util.List;

import com.social.socialweb.models.User;

public interface UserService {
    public User registerUser(User user);

    public User findUserById(Integer userId);

    public User findUserByEmail(String email);

    public User followUser(Integer userId1, Integer userId2);

    public User updateUser(User user);

    public List<User> searchUser(String query);
    
}
