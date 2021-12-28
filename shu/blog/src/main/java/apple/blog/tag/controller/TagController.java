package apple.blog.tag.controller;


import apple.blog.tag.model.Tag;
import apple.blog.tag.service.TagService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/tag")
public class TagController {

    private final TagService tagService;

    @PostMapping("/tag/add")
    public Tag addTag(@RequestBody Tag tag){
        return tagService.addTag(tag);
    }

    @GetMapping("/tag/getAll")
    public List<Tag> getAll(){
        return tagService.getAllTag();
    }

    @GetMapping("/tag/get/{id}")
    public Optional<Tag> get(@PathVariable("id") Long id){
        return tagService.getTag(id);
    }

    @DeleteMapping("/tag/del/{id}")
    public void del(@PathVariable Long id){
        tagService.delTag(id);
    }
}
