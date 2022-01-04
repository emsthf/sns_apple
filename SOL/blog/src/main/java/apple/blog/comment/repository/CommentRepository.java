package apple.blog.comment.repository;

import apple.blog.comment.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findAllByUserId(Long userId);
    List<Comment> findAllByPostId(Long postId);   // 포스트 아이디로 해당 포스트에 달린 모든 댓글을 리스트로 검색
}
