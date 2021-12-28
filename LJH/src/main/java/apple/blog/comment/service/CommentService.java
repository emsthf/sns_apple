package apple.blog.comment.service;

import apple.blog.comment.model.Comment;

import java.util.List;
import java.util.Optional;

public interface CommentService {
    Comment addComment(Comment comment);
    List<Comment> getAllComment();
    Optional<Comment> getComment(Long id);
    void delComment(Long id);
}
