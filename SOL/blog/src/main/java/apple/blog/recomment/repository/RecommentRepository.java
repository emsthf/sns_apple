package apple.blog.recomment.repository;

import apple.blog.recomment.model.Recomment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecommentRepository extends JpaRepository<Recomment, Long> {
}
