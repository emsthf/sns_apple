package apple.blog.post.service;

import apple.blog.post.model.Post;
import apple.blog.post.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImpl implements PostService{
    @Autowired
    private PostRepository postRepository;

    @Override
    public Post addPost(Post post) {
        return postRepository.save(post);
    }

    @Override
    public List<Post> getAllPost() {
        return postRepository.findAll();
    }

    @Override
    public Optional<Post> getPost(Long id) {
        return Optional.ofNullable(postRepository.findById(id)).get();
    }

    @Override
    public void delPost(Long id) {
        postRepository.deleteById(id);
    }
}
