package com.social.socialweb.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.social.socialweb.models.User;
import com.social.socialweb.repository.UserRepository;

@Service
public class UserServiceImplementation implements UserService {
    
    @Autowired
    UserRepository userRepository;

    @Override
    public User registerUser(User user){
        User newUser = new User();
        newUser.setEmail(user.getEmail());
        newUser.setFirstName(user.getFirstName());
        newUser.setLastName(user.getLastName());
        newUser.setPassword(user.getPassword());
        newUser.setId(user.getId());

        User savedUser = userRepository.save(newUser);

        return savedUser;
    }

    @Override
    public User findUserById(Integer userId)throws Exception{
         Optional<User> user = userRepository.findById(userId);

        if (user.isPresent()) {
            return user.get();
        }
        
        throw new Exception("User not exist with User ID : ");
    }

    @Override
    public User findUserByEmail(String email){
        User user = userRepository.findByEmail(email);
        return user;
    }

    @Override
    public User followUser(Integer userId1, Integer userId2){
        return null;
    }

    @Override
    public User updateUser(User user){
        return null;
    }

    @Override
    public List<User> searchUser(String query){
        return null;
    }
}
