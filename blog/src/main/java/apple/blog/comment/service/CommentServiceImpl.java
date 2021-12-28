package apple.blog.comment.service;

import apple.blog.comment.model.Comment;
import apple.blog.comment.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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
        log.info("save comment.");
        return commentRepository.save(comment);
    }

    @Override
    public List<Comment> getAllComment() {
        log.info("get all comment");
        return commentRepository.findAll();
    }

    @Override
    public Optional<Comment> getComment(Long id) {
        log.info("get comment {}.", id);
        return Optional.ofNullable(commentRepository.findById(id).get());
    }

    @Override
    public void delComment(Long id) {
        log.info("delete comment {}.", id);
        commentRepository.deleteById(id);
    }
}
