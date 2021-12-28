package apple.blog.comment.controller;

import apple.blog.comment.dto.IComment;
import apple.blog.comment.model.Comment;
import apple.blog.comment.service.CommentService;
import apple.blog.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/comment")
public class CommentController {

    private final CommentService commentService;

    private final UserService userService;

    @PostMapping("/add")
    public Comment add(@RequestBody IComment iComment) {
        return commentService.addComment(
                new Comment(
                        iComment.getComment(),
                        userService.getUserById(iComment.getUserId()).get()
                )
        );
    }

    @GetMapping("/getAll")
    public List<Comment> getAll() {
        return commentService.getAllComment();
    }

    @GetMapping("/get/{id}")
    public Comment get(@PathVariable("id") Long id) {
        return commentService.getCommentById(id).get();
    }

    @GetMapping("/getCommentByUserId/{}")
    public List<Comment> getCommentById(@PathVariable("id") Long id) {
        return commentService.getCommentByUserId(id);
    }

    @DeleteMapping("/del/{id}")
    public void del(@PathVariable("id") Long id) {
        commentService.delComment(id);
    }

}
