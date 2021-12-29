package apple.blog.post.service;

import apple.blog.post.dto.IPostDto;
import apple.blog.post.model.Post;
import apple.blog.post.repository.PostRepository;
import apple.blog.user.service.UserService;
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
    private final UserService userService;

    @Override
    public Post addPost(IPostDto iPostDto) {
        log.info("add Post.");

        return postRepository.save(Post.builder()
                .content(iPostDto.getContent())
                .title(iPostDto.getTitle())
                .titleImg(iPostDto.getTitleImg())
                .user(userService.getUserById(iPostDto.getUserId()).get())
                .view(0)
                .build()
        );
    }

    @Override
    public List<Post> getAllPost() {
        log.info("get all Posts.");
        return postRepository.findAll();
    }

    @Override
    public Optional<Post> getPostById(Long id) {
        log.info("get Post by Id {}.", id);
        return Optional.ofNullable(postRepository.findById(id)).get();
    }

    @Override
    public List<Post> getPostByAuthId(Long id) {
        return postRepository.findAllByUserId(id);
    }

    @Override
    public void delPost(Long id) {
        log.info("delete Post by Id {}.", id);
        postRepository.deleteById(id);
    }
}
