package apple.blog.tagList.controller;

import apple.blog.post.model.Post;
import apple.blog.post.service.PostService;
import apple.blog.tag.model.Tag;
import apple.blog.tag.service.TagService;
import apple.blog.tagList.dto.ITagList;
import apple.blog.tagList.model.TagList;
import apple.blog.tagList.service.TagListService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/tagList")
public class TagListController {

    private final TagListService tagListService;
    private final TagService tagService;
    private final PostService postService;

    @PostMapping("/add")
    public TagList add(@RequestBody ITagList iTagList){
        Long inputTId = iTagList.getTagId();
        Tag inputTag = tagService.getTagById(inputTId).get();
        Long inputPId = iTagList.getPostId();
        Post inputPost = postService.getPostById(inputPId).get();

        TagList inputTagList = new TagList(
                inputTag,
                inputPost
        );
        return tagListService.addTagList(inputTagList);
    }
    @GetMapping("/getAll")
    public List<TagList> getAll(){
        return tagListService.getAllTagList();
    }

    @GetMapping("/get/{id}")
    public Optional<TagList> get(@PathVariable("id") Long id){
        return tagListService.getTagListById(id);
    }
}
