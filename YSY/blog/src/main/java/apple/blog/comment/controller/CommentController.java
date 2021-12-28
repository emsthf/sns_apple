package apple.blog.comment.controller;

import apple.blog.comment.dto.IComment;
import apple.blog.comment.model.Comment;
import apple.blog.comment.service.CommentService;
import apple.blog.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    private CommentService commentService;

    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public Comment add(@RequestBody IComment iComment) {
        return commentService.addComment(
                new Comment(
                        iComment.getComment(),
                        userService.getUser(iComment.getUserId()).get()
                )
        );
    }

    @GetMapping("/getAll")
    public List<Comment> getAll() {
        return commentService.getAllComment();
    }

    @GetMapping("/get/{id}")
    public Comment get(@PathVariable("id") Long id) {
        return commentService.getComment(id).get();
    }

    @DeleteMapping("/del/{id}")
    public void del(@PathVariable("id") Long id) {
        commentService.delComment(id);
    }

}
