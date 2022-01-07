package apple.blog.recomment.repository;

import apple.blog.recomment.model.Recomment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RecommentRepository extends JpaRepository<Recomment, Long> {
    List<Recomment> findAllByUserId(Long userId);
}
