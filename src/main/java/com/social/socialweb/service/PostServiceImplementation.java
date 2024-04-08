package com.social.socialweb.service;
import java.util.List;
import java.util.Optional;

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
    public String deletePost(Integer postId, Integer userId)throws Exception{
        Post post = findPostById(postId);
        User user = userService.findUserById(userId);

        if(post.getUser().getId()!=user.getId()){
            throw new Exception("You can't delete another user's post");
        }
        postRepository.delete(post);

        return "Post deleted successfully";
    }
    
    @Override
        public List<Post> findPostByUserId(Integer postId){
            
            return null;
    }

    @Override
    public Post findPostById(Integer postId)throws Exception{
        Optional<Post> opt = postRepository.findById(postId);
        if(opt.isEmpty()){
            throw new Exception("Post not found with id "+postId);
        }
        return opt.get();
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
