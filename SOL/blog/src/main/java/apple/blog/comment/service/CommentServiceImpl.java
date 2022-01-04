package apple.blog.comment.service;

import apple.blog.comment.dto.ICommentDto;
import apple.blog.comment.model.Comment;
import apple.blog.comment.repository.CommentRepository;
import apple.blog.user.service.UserService;
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
    private final UserService userService;

    @Override
    public Comment addComment(ICommentDto iCommentDto) {
        log.info("add Comment.");
        return commentRepository.save(Comment.builder()
                .id(null)
                .text(iCommentDto.getText())
                .user(userService.getUserById(iCommentDto.getUserId()).get())
                .build()
        );
    }

    @Override
    public Comment editComment(ICommentDto iCommentDto) {
        log.info("edit Comment {}.", commentRepository.findById(iCommentDto.getId()).get());
        Comment comment = Comment.builder()
                .id(iCommentDto.getId())
                .text(iCommentDto.getText())
                .user(userService.getUserById(iCommentDto.getUserId()).get())
                .build();
        commentRepository.save(comment);
        return comment;
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
    public List<Comment> getAllByUserId(Long id) {
        return commentRepository.findAllByUserId(id);
    }

    @Override
    public void delComment(Long id) {
        log.info("delete Comment by Id {}.", id);
        commentRepository.deleteById(id);
    }
}