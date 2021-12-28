package apple.blog.post.service;


import apple.blog.post.model.Post;

import java.util.List;
import java.util.Optional;

public interface PostService {
    Post addPost(Post post);
    List<Post> getAllPost();
    Optional<Post> getPostById(Long id);
    List<Post> getPostByAuthId(Long id);
    void delPost(Long id);
}
