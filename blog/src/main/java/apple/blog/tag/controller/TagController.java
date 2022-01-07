package apple.blog.tag.controller;

import apple.blog.tag.model.Tag;
import apple.blog.tag.service.TagService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/tag")
public class TagController {

    private final TagService tagService;

    @PostMapping("/add")
    public void addTag(@RequestBody Tag tag) {
        tagService.addTag(tag);
    }

    @PutMapping("/edit")
    public void edit(@RequestBody Tag tag) {
        tagService.editTag(tag);
    }

    @GetMapping("/getAll")
    public List<Tag> getAll() {
        return tagService.getAll();
    }

    @GetMapping("/getTag/{id}")
    public Optional<Tag> getTagById(@PathVariable Long id) {
        return tagService.getTagById(id);
    }

    @DeleteMapping("/del/{id}")
    public void delTag(@PathVariable Long id) {
        tagService.delTag(id);
    }
}
