package apple.blog.recomment.controller;

import apple.blog.comment.service.CommentService;
import apple.blog.recomment.dto.RecommentDto;
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

    @PostMapping("/add")
    public Recomment add(@RequestBody RecommentDto recommentDto) {
        return recommentService.addRecomment(recommentDto);
    }

    @PutMapping("/edit")
    public Recomment edit(@RequestBody RecommentDto recommentDto) {
        return recommentService.editRecomment(recommentDto);
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
