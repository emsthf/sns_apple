package apple.blog.snsList.repository;

import apple.blog.snsList.model.SnsList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SnsListRepository extends JpaRepository<SnsList, Long> {
}
