package apple.blog.comment.controller;

import apple.blog.comment.dto.ICommentDto;
import apple.blog.comment.model.Comment;
import apple.blog.comment.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/comment")
public class CommentController {

    private final CommentService commentService;

    @PostMapping("/add")
    public void add(@RequestBody ICommentDto iCommentDto) {
        commentService.addComment(iCommentDto);
    }

    @PutMapping("/edit")
    public void edit(@RequestBody ICommentDto iCommentDto) {
        commentService.editComment(iCommentDto);
    }

    @GetMapping("/getAll")
    public List<Comment> getAll() {
        return commentService.getAllComment();
    }

    @GetMapping("/get/{id}")
    public Comment get(@PathVariable("id") Long id) {
        return commentService.getCommentById(id).get();
    }

    @GetMapping("/getUserId/{id}")
    public List<Comment> getCommentByUserId(@PathVariable("id") Long id) {
        return commentService.getAllByUserId(id);
    }

    @DeleteMapping("/del/{id}")
    public void del(@PathVariable("id") Long id) {
        commentService.delComment(id);
    }

}
