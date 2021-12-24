package apple.blog.categoryList.repository;

import apple.blog.categoryList.model.CateList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CateListRepository extends JpaRepository<CateList, Long> {
}
