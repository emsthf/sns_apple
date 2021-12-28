package apple.blog.post.service;


import apple.blog.post.dto.IPost;
import apple.blog.post.model.Post;

import java.util.List;
import java.util.Optional;

public interface PostService {

    Post addPost(IPost iPost);
    List<Post> getAllPost();
    Optional<Post> getPostById(Long id);
    void delPost(Long id);
}
