package com.social.socialweb.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.social.socialweb.models.Post;
import com.social.socialweb.models.User;
import com.social.socialweb.repository.PostRepository;

@Service
public class PostServiceImplementation implements PostService {

    @Autowired
    PostRepository postRepository;

    @Autowired
    UserService userService;

    @Override
    public Post createNewPost(Post post, Integer userId) throws Exception{

        User user = userService.findUserById(userId);

        Post newPost = new Post();
        newPost.setCaption(post.getCaption());
        newPost.setImage(post.getImage());
        //newPost.setCreatedAt(new LocalDateTime);
        newPost.setVideo(post.getVideo());
        newPost.setUser(user);
        

        return newPost;
    }

    @Override
    public String deletePost(Integer postId, Integer userId){
        return null;
    }

    @Override
    public List<Post> findPostByUserId(Integer userId){
        return null;
    }

    @Override
    public Post findPostById(Integer postId){
        return null;
    }

    @Override
    public List<Post> findAllPost(){
        return null;
    }

    @Override
    public Post savedPost(Integer postId, Integer userId){
        return null;
    }

    @Override
    public Post likePost(Integer postId, Integer userId){
        return null;
    }

}
