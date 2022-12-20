package africa.semicolon.blog.controllers;

import africa.semicolon.blog.data.models.Post;
import africa.semicolon.blog.dtos.requests.CreatePostRequest;
import africa.semicolon.blog.services.PostServiceImpl;
import africa.semicolon.blog.services.PostService;
import org.springframework.web.bind.annotation.*;

@RestController
public class PostController {
    private final PostService postService = new PostServiceImpl();

    @PostMapping("/post")
    public String createPost(@RequestBody CreatePostRequest createPostRequest){
        postService.createPost(createPostRequest);
        return "Successful";
    }

    @GetMapping("/post/{postId}")
    public Post viewPost(@PathVariable int postId){
        return postService.viewPost(postId);
    }
}
