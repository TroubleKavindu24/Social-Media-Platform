package com.social.socialweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.social.socialweb.models.User;

public interface UserRepository extends JpaRepository<User, Integer>{

    
}