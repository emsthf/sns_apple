package apple.blog.commentList.controller;

import apple.blog.comment.service.CommentService;
import apple.blog.commentList.dto.ICommentList;
import apple.blog.commentList.model.CommentList;
import apple.blog.commentList.service.CommentListService;
import apple.blog.post.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/commentList")
public class CommentListController {
    @Autowired
    private CommentListService commentListService;

    @Autowired
    private PostService postService;

    @Autowired
    private CommentService commentService;

    @PostMapping("/add")
    public CommentList add(@RequestBody ICommentList iCommentList) {
        return commentListService.addCommentList(
                new CommentList(
                        postService.getPost(iCommentList.getPostId()).get(),
                        commentService.getComment(iCommentList.getCommentId()).get()
                )
        );
    }

    @GetMapping("/getAll")
    public List<CommentList> getAll() {
        return commentListService.getAllCommentList();
    }

    @GetMapping("/get/{id}")
    public CommentList get(@PathVariable("id") Long id) {
        return commentListService.getCommentList(id).get();
    }

    @DeleteMapping("/del/{id}")
    public void del(@PathVariable("id") Long id) {
        commentListService.delCommentList(id);
    }
}
