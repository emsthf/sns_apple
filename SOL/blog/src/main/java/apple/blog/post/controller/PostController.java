package apple.blog.post.controller;

import apple.blog.post.dto.IPostDto;
import apple.blog.post.dto.OPostDto;
import apple.blog.post.model.Post;
import apple.blog.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/post")
public class PostController {

    private final PostService postService;

    @PostMapping("/add")
    public void add(@RequestBody IPostDto iPostDto) {
        postService.addPost(iPostDto);
    }

    @PutMapping("/edit")
    public void edit(@RequestBody IPostDto iPostDto) {
        postService.editPost(iPostDto);
    }

    @GetMapping("/getAll")
    public List<Post> getAll() {
        return postService.getAllPost();
    }

    @GetMapping("/getAllOrderByCreated")
    public List<Post> getAllOrderByCreatedDesc() {
        return postService.getAllOrderByCreatedDesc();
    }

    @GetMapping("/get/{id}")
    public OPostDto get(@PathVariable("id") Long id) {
        return postService.getPostById(id);
    }

    @GetMapping("/getAuthId/{id}")
    public List<Post> getPostByAuthId(@PathVariable("id") Long id) {
        return postService.getPostByAuthId(id);
    }

    @DeleteMapping("/del/{id}")
    public void del(@PathVariable("id") Long id) {
        postService.delPost(id);
    }
}
