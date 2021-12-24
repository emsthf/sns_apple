package apple.blog.tag.controller;


import apple.blog.tag.model.Tag;
import apple.blog.tag.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tag")
public class TagController {

    @Autowired
    private TagService tagService;

    @PostMapping("/add")
    public Tag add(@RequestBody Tag tag){
        return tagService.addTag(tag);
    }

    @GetMapping("/getAll")
    public List<Tag> getAll(){
        return tagService.getAllTag();
    }

    @GetMapping("/get/{id}")
    public Optional<Tag> get(@PathVariable("id") Long id){
        return tagService.getTag(id);
    }

    @DeleteMapping("/del/{id}")
    public void del(@PathVariable("id") Long id){
        tagService.delTag(id);
    }
}
