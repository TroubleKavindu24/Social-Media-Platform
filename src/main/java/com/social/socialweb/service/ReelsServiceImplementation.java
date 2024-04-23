package com.social.socialweb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.social.socialweb.models.Reels;
import com.social.socialweb.models.User;
import com.social.socialweb.repository.ReelsRepository;

public class ReelsServiceImplementation implements ReelsService{

    @Autowired
    private ReelsRepository reelsRepository;

    @Autowired
    private UserService userService;


    @Override
    public Reels createReel(Reels reel, User user) {
        
        Reels createReel = new Reels();

        createReel.setTitle(reel.getTitle());
        createReel.setUser(user);
        createReel.setVideo(reel.getVideo());

        return reelsRepository.save(createReel);
    }

    @Override
    public List<Reels> findAllReels() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAllReels'");
    }

    @Override
    public List<Reels> findUsersReel(Integer userId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findUsersReel'");
    }
    
}
