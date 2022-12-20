package africa.semicolon.blog.services;

import africa.semicolon.blog.data.models.Post;
import africa.semicolon.blog.data.repositories.PostRepository;
import africa.semicolon.blog.data.repositories.PostRepositoryImpl;
import africa.semicolon.blog.dtos.requests.CreatePostRequest;

import java.util.List;

public class PostServiceImpl implements PostService {
    private final PostRepository postRepository = new PostRepositoryImpl();
    @Override
    public void createPost(CreatePostRequest createPostRequest) {
        Post post = new Post();
        post.setBody(createPostRequest.getBody());
        post.setTitle(createPostRequest.getTitle());
        postRepository.save(post);
    }

    @Override
    public void updatePost(int id, String title, String body) {

    }

    @Override
    public void deletePost(int id) {

    }

    @Override
    public Post viewPost(int id) {
        return postRepository.findById(id);
    }

    @Override
    public List<Post> viewAllPost() {
        return postRepository.findAll();
    }
}
