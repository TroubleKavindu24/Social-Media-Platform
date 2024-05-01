package com.social.socialweb.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.social.socialweb.config.JwtProvider;
import com.social.socialweb.exceptions.UserException;
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
    public User findUserById(Integer userId)throws UserException{
         Optional<User> user = userRepository.findById(userId);

        if (user.isPresent()) {
            return user.get();
        }
        
        throw new UserException("User not exist with User ID : ");
    }

    @Override
    public User findUserByEmail(String email){
        User user = userRepository.findByEmail(email);
        return user;
    }

    @Override
    public User followUser(Integer regUserId, Integer userId2)throws UserException{

        User regUser = findUserById(regUserId);

        User user2 = findUserById(userId2);

        user2.getFollowers().add(regUser.getId());
        regUser.getFollowings().add(user2.getId());

        userRepository.save(regUser);
        userRepository.save(user2);

        return regUser;
    }

    @Override
    public User updateUser(User user, Integer userId)throws UserException{

        Optional<User> user1 = userRepository.findById(userId);

        if(user1.isEmpty()){
            throw new UserException("User not exist with id "+userId);
        }

        User oldUser = user1.get(); 

        if(user.getFirstName()!=null){
            oldUser.setFirstName((user.getFirstName()));
        }

        if(user.getLastName()!=null){
            oldUser.setLastName(user.getLastName());
        }

        if(user.getEmail()!=null){
            oldUser.setEmail(user.getEmail());
        }

        if (user.getGender()!=null) {
            oldUser.setGender(user.getGender());
        }

        User updatUser = userRepository.save(oldUser);

        return updatUser;
    }

    @Override
    public List<User> searchUser(String query){

        return userRepository.searchUser(query);
    }

    @Override
    public User findUserByJwt(String jwt) {

        String email = JwtProvider.getEmailFromJwtToken(jwt);

        User user = userRepository.findByEmail(email);

        return user;
    }
}
