package com.social.socialweb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.social.socialweb.models.Post;

public interface PostRepository extends JpaRepository<Post, Integer >{

    @Query("select p from Post p where p.user.id=:userId")
    List<Post> findPostByUserId(Integer userId);
    
    @Transactional
    Long deleteByUserId(Integer userId);

}
