package com.social.socialweb.service;

import com.social.socialweb.models.Comment;

public interface CommentService {

    public Comment createComment(Comment comment, Integer postId, Integer userId) throws Exception;

    public Comment findCommentsById(Integer commentId);

    public Comment likeComment(Integer commentId, Integer userId);
}
