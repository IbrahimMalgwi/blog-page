package services;

import data.models.Post;
import dtos.requests.CreatePostRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PostServiceImplTest {
    private PostService postService;
    private CreatePostRequest createPostRequest;

    @BeforeEach
    void setUp() {
        postService = new PostServiceImpl();
        createPostRequest = new CreatePostRequest();
    }

    @Test
    public void createPostTest(){
//        CreatePostRequest createPostRequest = new CreatePostRequest();
        createPostRequest.setBody("Vegetable is my best");
        createPostRequest.setTitle("New post");
        postService.createPost(createPostRequest);
        assertEquals(1, postService.viewAllPost().size());
    }

    @Test
    public void viewPostTest(){
        createPostRequest.setBody("Vegetable is my best");
        createPostRequest.setTitle("New post");
        postService.createPost(createPostRequest);
        assertEquals(1, postService.viewAllPost().size());

        Post post = postService.viewPost(1);
        assertEquals("New Post", post.getTitle());
        assertEquals("Vegetable is my best", post.getBody());
        assertNotNull(post.getCreationTime());

    }
}