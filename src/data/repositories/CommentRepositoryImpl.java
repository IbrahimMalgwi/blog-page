package data.repositories;

import data.models.Comment;

import java.util.ArrayList;
import java.util.List;

public class CommentRepositoryImpl implements CommentRepository{
    private List<Comment> commentDb = new ArrayList<>();
    int count;
    @Override
    public Comment save(Comment comment) {
        if (comment.getId() != 0) updateComment(comment);
        else {
            comment.setId(++count);
            commentDb.add(comment);
        }
        return comment;
    }

    private void updateComment(Comment comment){
        Comment lastComment = findById(comment.getId());
        lastComment.setComment(comment.getComment());
        lastComment.setCommenterName(comment.getCommenterName());
    }

    @Override
    public Comment findById(int id) {
        for (Comment comment : commentDb) if (comment.getId() == id) return comment;
        return null;
    }

    @Override
    public List<Comment> findAll() {
        return commentDb;
    }

    @Override
    public long count() {
        return commentDb.size();
    }

    @Override
    public void delete(Comment comment) {

    }

    @Override
    public void delete(int id) {

    }
}
