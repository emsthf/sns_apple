package apple.blog.post.service;

import apple.blog.post.dto.IPostDto;
import apple.blog.post.dto.OPostDto;
import apple.blog.post.model.Post;

import java.util.List;
import java.util.Optional;

public interface PostService {
    int addPost(IPostDto iPostDtopost);
    int editPost(IPostDto iPostDto);
    List<Post> getAllPost();
    List<Post> getAllOrderByCreatedDesc();
    OPostDto getPostById(Long id);
    List<Post> getPostByAuthId(Long id);
    void delPost(Long id);
}
