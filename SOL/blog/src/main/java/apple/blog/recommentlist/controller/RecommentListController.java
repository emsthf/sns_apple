package apple.blog.recommentlist.controller;

import apple.blog.recommentlist.dto.RecommentListDto;
import apple.blog.recommentlist.model.RecommentList;
import apple.blog.recommentlist.service.RecommentListService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/recommentlist")
public class RecommentListController {

    private final RecommentListService recommentListService;

    @PostMapping("/add")
    public RecommentList addRecommentList(@RequestBody RecommentListDto recommentListDto) {
        return recommentListService.addRecommentList(recommentListDto);
    }

    @GetMapping("/getAll")
    public List<RecommentList> getAll() {
        return recommentListService.getAll();
    }

    @GetMapping("/getAllByCommentId/{id}")
    public List<RecommentList> getAllByCommentid(@PathVariable Long id) {
        return recommentListService.getAllByCommentId(id);
    }
}
