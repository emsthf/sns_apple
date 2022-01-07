package apple.blog.smallCategory.repository;

import apple.blog.smallCategory.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    List<Category> findAllByLargeCategoryId(Long id);
}
