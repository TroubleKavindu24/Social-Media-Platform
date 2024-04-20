package com.social.socialweb.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;

import com.social.socialweb.models.Comment;
import com.social.socialweb.models.Post;
import com.social.socialweb.models.User;
import com.social.socialweb.repository.CommentRepository;
import com.social.socialweb.repository.PostRepository;

public class CommentServiceImplementation implements CommentService{

    @Autowired
    private PostService postService;

    @Autowired
    private UserService userService;

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public Comment createComment(Comment comment, Integer postId, Integer userId) throws Exception {

        User user = userService.findUserById(userId);
        Post post = postService.findPostById(postId);
        comment.setUser(user);
        comment.setContent(comment.getContent());
        comment.setCreatedAt(LocalDateTime.now());

        Comment savedComment = commentRepository.save(comment);
        post.getComments().add(savedComment);
        postRepository.save(post);

        return savedComment;
    }

    @Override
    public Comment findCommentsById(Integer commentId) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Comment likeComment(Integer commentId, Integer userId) {
        // TODO Auto-generated method stub
        return null;
    }
    
}
