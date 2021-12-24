package apple.blog.post.controller;

import apple.blog.post.model.Post;
import apple.blog.post.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/post")
public class PostController {
    @Autowired
    private PostService postService;

    @PostMapping("/add")
    public Post add(@RequestBody Post post) {
        return postService.addPost(post);
    }

    @GetMapping("/getAll")
    public List<Post> getAll() {
        return postService.getAllPost();
    }

    @GetMapping("/get/{id}")
    public Optional<Post> get(@PathVariable("id") Long id) {
        return postService.getPost(id);
    }

    @DeleteMapping("/del/{id}")
    public void del(@PathVariable("id") Long id) {
        postService.delPost(id);
    }
}
