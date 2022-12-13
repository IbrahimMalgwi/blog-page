package controllers;

import data.models.Post;
import dtos.requests.CreatePostRequest;
import services.PostServiceImpl;
import services.PostService;

public class PostController {
    private final PostService postService = new PostServiceImpl();

    public String createPost(CreatePostRequest createPostRequest){
        postService.createPost(createPostRequest);
        return "Successful";
    }

    public Post viewPost(int postId){
        return postService.viewPost(postId);
    }
}
