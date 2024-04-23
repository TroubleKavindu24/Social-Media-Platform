package com.social.socialweb.service;

import java.util.List;

import com.social.socialweb.models.Reels;
import com.social.socialweb.models.User;

public interface ReelsService {
    
    public Reels createReel(Reels reel, User user);
    public List<Reels> findAllReels();
    public List<Reels> findUsersReel(Integer userId) throws Exception;

}
