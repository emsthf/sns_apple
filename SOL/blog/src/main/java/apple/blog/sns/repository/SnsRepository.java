package apple.blog.sns.repository;

import apple.blog.sns.model.Sns;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SnsRepository extends JpaRepository<Sns, Long> {
}
