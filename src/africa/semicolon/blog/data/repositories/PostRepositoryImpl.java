package africa.semicolon.blog.data.repositories;

import africa.semicolon.blog.data.models.Post;

import java.util.ArrayList;
import java.util.List;

public class PostRepositoryImpl implements PostRepository{
    private List<Post> postDb = new ArrayList<>();
    int count;
    @Override
    public Post save(Post post) {
        if (post.getId()!=0) update(post);
        else {
            post.setId(count++);
            postDb.add(post);
        }
        return post;
    }

    private void update(Post post){
        //find the original
        Post savedPost = findById(post.getId());
        savedPost.setTitle(post.getTitle());
        savedPost.setBody(post.getBody());

    }

    @Override
    public long count() {
        return postDb.size();
    }

    @Override
    public Post findById(int id) {
        for (Post post: postDb) if (post.getId()==id) return post;
        return null;
    }

    @Override
    public List<Post> findAll() {
        return postDb;
    }

    @Override
    public void delete(Post post) {
        postDb.remove(post);
    }

    @Override
    public void delete(int id) {
        for (int i = 0; i < postDb.size(); i++){
            Post item = postDb.get(i);
            if (item.getId() == id){
                postDb.remove(item);
                break;
            }
        }
    }
}
