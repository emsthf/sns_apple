package apple.blog.snslist.repository;

import apple.blog.snslist.model.SnsList;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SnsListRepository extends JpaRepository<SnsList, Long> {
    List<SnsList> findAllByUserId(Long userId);
}
