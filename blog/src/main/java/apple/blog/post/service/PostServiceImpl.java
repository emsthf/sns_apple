package apple.blog.post.service;

import apple.blog.post.model.Post;
import apple.blog.post.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Service
public class PostServiceImpl implements PostService{

    private final PostRepository postRepository;

    @Override
    public Post addPost(Post post) {
        log.info("save Post.");
        return postRepository.save(post);
    }

    @Override
    public List<Post> getAllPost() {
        log.info("get all Post.");
        return postRepository.findAll();
    }

    @Override
    public Optional<Post> getPostById(Long id) {
        log.info("get Post by id {}.", id);
        return Optional.ofNullable(postRepository.findById(id)).get();
    }

    @Override
    public List<Post> getPostByAuthId(Long id) {
        log.info("get Post by User id {}.", id);
        return postRepository.findAllByUserId(id);
    }

    @Override
    public void delPost(Long id) {
        log.info("delete Post by id {}.", id);
        postRepository.deleteById(id);
    }
}
