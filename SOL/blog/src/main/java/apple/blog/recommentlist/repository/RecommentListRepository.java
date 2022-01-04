package apple.blog.recommentlist.repository;

import apple.blog.recommentlist.model.RecommentList;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RecommentListRepository extends JpaRepository<RecommentList, Long> {
    List<RecommentList> findAllByCommentId(Long commentId);
}
