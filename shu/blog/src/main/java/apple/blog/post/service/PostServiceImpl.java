package apple.blog.post.service;


import apple.blog.commentList.service.CommentListService;
import apple.blog.post.dto.IPost;
import apple.blog.post.model.Post;
import apple.blog.post.repository.PostRepository;
import apple.blog.user.repository.UserRepository;
import apple.blog.user.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class PostServiceImpl implements PostService{

    private final PostRepository postRepository;

    @Override
    public Post addPost(IPost iPost) {
        log.info("");
        return postRepository.save(
                Post.builder()
                        .title(iPost.getTitle())
                        .view(iPost.getView())
                        .build()
        );
    }

    @Override
    public List<Post> getAllPost() {
        return postRepository.findAll();
    }

    @Override
    public Optional<Post> getPostById(Long id) {
        return Optional.ofNullable(postRepository.findById(id).get());
    }

    @Override
    public void delPost(Long id) {

    }

    @Override
    public List<Post> getPostByAuthId(Long id) {
        return postRepository.findAllByUserId(id);
    }
}
