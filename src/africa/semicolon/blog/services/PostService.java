package africa.semicolon.blog.services;

import africa.semicolon.blog.data.models.Post;
import africa.semicolon.blog.dtos.requests.CreatePostRequest;

import java.util.List;

public interface PostService {
    void createPost(CreatePostRequest createPostRequest);
    void updatePost(int id, String title, String body);
    void deletePost(int id);
    Post viewPost(int id);

    List<Post> viewAllPost();
}
