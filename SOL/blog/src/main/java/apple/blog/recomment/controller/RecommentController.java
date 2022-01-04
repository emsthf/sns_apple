package apple.blog.recomment.controller;

import apple.blog.comment.service.CommentService;
import apple.blog.recomment.dto.IRecomment;
import apple.blog.recomment.model.Recomment;
import apple.blog.recomment.service.RecommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/recomment")
public class RecommentController {

    private final RecommentService recommentService;
    private final CommentService commentService;

    @PostMapping("/add")
    public Recomment add(@RequestBody IRecomment iRecomment) {
        return recommentService.addRecomment(
                new Recomment(
                        commentService.getCommentById(iRecomment.getCommentId()).get()
                )
        );
    }

    @GetMapping("/getAll")
    public List<Recomment> getAll() {
        return recommentService.getAllRecomment();
    }

    @GetMapping("/get/{id}")
    public Recomment get(@PathVariable("id") Long id) {
        return recommentService.getRecommentById(id).get();
    }

    @DeleteMapping("/del/{id}")
    public void del(@PathVariable("id") Long id) {
        recommentService.delRecomment(id);
    }
}
