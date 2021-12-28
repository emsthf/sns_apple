package apple.blog.post.controller;

import apple.blog.post.dto.IPost;
import apple.blog.post.model.Post;
import apple.blog.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class PostController {

    private final PostService postService;

    @PostMapping("/post/add")
    public Post addPost(@RequestBody IPost iPost) {
        return postService.addPost(iPost);
    }

    @GetMapping("/post/getAll")
    public List<Post> getAllPost() {
        return postService.getAllPost();
    }

    @GetMapping("/post/getPost/{id}")
    public Optional<Post> getPost(@PathVariable Long id) {
        return postService.getPostById(id);
    }

    @DeleteMapping("/post/del/{id}")
    public void del(@PathVariable("id") Long id) {
        postService.delPost(id);
    }
}
