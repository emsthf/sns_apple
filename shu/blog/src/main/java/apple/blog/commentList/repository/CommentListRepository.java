package apple.blog.commentList.repository;

import apple.blog.commentList.model.CommentList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentListRepository extends JpaRepository<CommentList, Long> {
}
