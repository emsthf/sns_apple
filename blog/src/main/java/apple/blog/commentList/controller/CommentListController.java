package apple.blog.commentList.controller;

import apple.blog.comment.service.CommentService;
import apple.blog.commentList.dto.ICommentList;
import apple.blog.commentList.model.CommentList;
import apple.blog.commentList.service.CommentListService;
import apple.blog.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/commentList")
public class CommentListController {

    private final CommentListService commentListService;
    private final PostService postService;
    private final CommentService commentService;

    @PostMapping("/add")
    public CommentList add(@RequestBody ICommentList iCommentList) {
        return commentListService.addCommentList(
                new CommentList(
                        postService.getPostById(iCommentList.getPostId()).get(),
                        commentService.getCommentById(iCommentList.getCommentId()).get()
                )
        );
    }

    @GetMapping("/getAll")
    public List<CommentList> getAll() {
        return commentListService.getAllCommentList();
    }

    @GetMapping("/get/{id}")
    public CommentList get(@PathVariable("id") Long id) {
        return commentListService.getCommentListById(id).get();
    }

    @DeleteMapping("/del/{id}")
    public void del(@PathVariable("id") Long id) {
        commentListService.delCommentList(id);
    }
}
