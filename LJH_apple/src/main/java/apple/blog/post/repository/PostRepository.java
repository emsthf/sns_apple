package apple.blog.post.repository;

import apple.blog.post.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.Id;

public interface PostRepository extends JpaRepository<Post, Long> {
}