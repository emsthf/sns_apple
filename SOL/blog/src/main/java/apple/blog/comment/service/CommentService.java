package apple.blog.comment.service;

import apple.blog.comment.dto.ICommentDto;
import apple.blog.comment.model.Comment;

import java.util.List;
import java.util.Optional;

public interface CommentService {
    Comment addComment(ICommentDto iCommentDto);
    Comment editComment(ICommentDto iCommentDto);
    List<Comment> getAllComment();
    Optional<Comment> getCommentById(Long id);
    List<Comment> getAllByUserId(Long UserId);
    void delComment(Long id);
}
