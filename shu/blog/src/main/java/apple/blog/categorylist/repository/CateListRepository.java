package apple.blog.categorylist.repository;

import apple.blog.category.model.Category;
import apple.blog.categorylist.model.CateList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CateListRepository extends JpaRepository<Category, Long> {
}
