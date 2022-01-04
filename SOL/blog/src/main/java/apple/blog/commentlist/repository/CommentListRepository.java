package apple.blog.commentlist.repository;

import apple.blog.commentlist.model.CommentList;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentListRepository extends JpaRepository<CommentList, Long> {
    List<CommentList> findAllByPostId(Long postId);
}
