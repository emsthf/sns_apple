package apple.blog.tag.controller;

import apple.blog.tag.dto.TagDto;
import apple.blog.tag.model.Tag;
import apple.blog.tag.service.TagService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/tag")
public class TagController {

    private final TagService tagService;

    @PostMapping("/add")
    public Tag add(@RequestBody TagDto tagDto){
        return tagService.addTag(tagDto);
    }

    @GetMapping("/getAll")
    public List<Tag> getAll(){
        return tagService.getAllTag();
    }

    @GetMapping("/getAllByPostId/{postId}")
    public List<Tag> getAllByPostId(@PathVariable Long postId) {
        return tagService.getAllTagByPostId(postId);
    }

    @GetMapping("/get/{id}")
    public Optional<Tag> get(@PathVariable("id") Long id){
        return tagService.getTagById(id);
    }

    @DeleteMapping("/del/{id}")
    public void del(@PathVariable("id") Long id){
        tagService.delTag(id);
    }
}
