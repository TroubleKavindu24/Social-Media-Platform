package com.social.socialweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.social.socialweb.models.Comment;

public interface CommentRepository extends JpaRepository<Comment,Integer>{
    
}
