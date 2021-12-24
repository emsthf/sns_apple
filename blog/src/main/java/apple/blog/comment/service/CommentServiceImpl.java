package apple.blog.comment.service;

import apple.blog.comment.model.Comment;
import apple.blog.comment.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentRepository commentRepository;

    @Override
    public Comment addComment(Comment comment) {
        return commentRepository.save(comment);
    }

    @Override
    public List<Comment> getAllComment() {
        return commentRepository.findAll();
    }

    @Override
    public Optional<Comment> getComment(Long id) {
        return Optional.ofNullable(commentRepository.findById(id)).get();
    }

    @Override
    public void delComment(Long id) {
        commentRepository.deleteById(id);
    }
}
