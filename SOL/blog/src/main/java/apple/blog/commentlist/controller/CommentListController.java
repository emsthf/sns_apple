package apple.blog.commentlist.controller;

import apple.blog.commentlist.dto.CommentListDto;
import apple.blog.commentlist.model.CommentList;
import apple.blog.commentlist.service.CommentListService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/commlist")
public class CommentListController {

    private final CommentListService commentListService;

    @PostMapping("/add")
    public CommentList add(@RequestBody CommentListDto commentListDto) {
        return commentListService.addCommList(commentListDto);
    }

    @GetMapping("/getAll")
    public List<CommentList> getAll() {
        return commentListService.getAll();
    }

    @GetMapping("/getAllByPostId/{id}")
    public List<CommentList> getAllByPostId(@PathVariable Long id) {
        return commentListService.getAllByPostId(id);
    }

    @DeleteMapping("/del/{id}")
    public void delCommList(@PathVariable Long id) {
        commentListService.delCommList(id);
    }

    @DeleteMapping("/delAllByPostId/{postId}")
    public void delAllCommListByPostId(@PathVariable Long postId) {
        commentListService.delCommListAll(postId);
    }
}
