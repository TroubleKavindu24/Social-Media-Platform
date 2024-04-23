package com.social.socialweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.social.socialweb.models.Reels;
import com.social.socialweb.models.User;
import com.social.socialweb.service.ReelsService;
import com.social.socialweb.service.UserService;

@RestController
public class ReelsController {

    @Autowired
    private ReelsService reelsService;

    @Autowired
    private UserService userService;

    @PostMapping("/api/reels")
    public Reels createReel(@RequestBody Reels reel,@RequestHeader ("Authorization") String jwt){

        User reqUser = userService.findUserByJwt(jwt);
    Reels createdReels = reelsService.createReel(reel, reqUser);

        return createdReels;
    }
}
