package apple.blog.taglist.controller;

import apple.blog.tag.model.Tag;
import apple.blog.taglist.dto.TagListDto;
import apple.blog.taglist.model.TagList;
import apple.blog.taglist.service.TagListService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/taglist")
public class TagListController {

    private final TagListService tagListService;

    @PostMapping("/add")
    public TagList addTagList(@RequestBody TagListDto tagListDto) {
        return tagListService.addTagList(tagListDto);
    }

    @GetMapping("/getAll")
    public List<TagList> getAll() {
        return tagListService.getAll();
    }

    @GetMapping("/getTagByPostId/{id}")
    public List<TagList> getAllTagByPostId(@PathVariable Long id) {
        return tagListService.getAllTagByPostId(id);
    }

    @DeleteMapping("/del/{id}")
    public void del(@PathVariable Long id) {
        tagListService.delTagList(id);
    }

    @DeleteMapping("/delAllByPostId/{postId}")
    public void delAllByPostId(@PathVariable Long postId) {
        tagListService.delAllByPostId(postId);
    }
}
