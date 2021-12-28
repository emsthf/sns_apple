package apple.blog.recomment.controller;

import apple.blog.base.UtilTimeSetter;
import apple.blog.comment.service.CommentService;
import apple.blog.recomment.dto.IRecomment;
import apple.blog.recomment.model.Recomment;
import apple.blog.recomment.service.RecommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/recomment")
public class RecommentController {
    @Autowired
    private RecommentService recommentService;

    @Autowired
    private CommentService commentService;

    @PostMapping("/add")
    public Recomment add(@RequestBody IRecomment iRecomment) {
        return recommentService.addRecomment(
                new Recomment(
                        commentService.getComment(iRecomment.getCommentId()).get()
                )
        );
    }

    @GetMapping("/getAll")
    public List<Recomment> getAll() {
        return recommentService.getAllRecomment();
    }

    @GetMapping("/get/{id}")
    public Recomment get(@PathVariable("id") Long id) {
        return recommentService.getRecomment(id).get();
    }

    @DeleteMapping("/del/{id}")
    public void del(@PathVariable("id") Long id) {
        recommentService.delRecomment(id);
    }
}
