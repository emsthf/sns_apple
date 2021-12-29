package apple.blog.comment.service;

import apple.blog.comment.model.Comment;
import apple.blog.comment.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Service
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;

    @Override
    public Comment addComment(Comment comment) {
        log.info("add Comment.");
        return commentRepository.save(comment);
    }

    @Override
    public List<Comment> getAllComment() {
        log.info("get all Comments.");
        return commentRepository.findAll();
    }

    @Override
    public Optional<Comment> getCommentById(Long id) {
        log.info("get Comment by id {}.", id);
        return Optional.ofNullable(commentRepository.findById(id).get());
    }

    @Override
    public void delComment(Long id) {
        log.info("delete Comment by Id {}.", id);
        commentRepository.deleteById(id);
    }
}
