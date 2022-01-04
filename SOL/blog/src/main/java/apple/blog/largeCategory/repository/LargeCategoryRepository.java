package apple.blog.largeCategory.repository;

import apple.blog.largeCategory.model.LargeCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LargeCategoryRepository extends JpaRepository<LargeCategory, Long> {
}
