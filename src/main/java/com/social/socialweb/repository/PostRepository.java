package com.social.socialweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.social.socialweb.models.Post;

public interface PostRepository extends JpaRepository<Post, Integer >{
    
}
