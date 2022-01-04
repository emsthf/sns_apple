package apple.blog.categorylist.repository;

import apple.blog.categorylist.model.CategoryList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryListRepository extends JpaRepository<CategoryList, Long> {
}
