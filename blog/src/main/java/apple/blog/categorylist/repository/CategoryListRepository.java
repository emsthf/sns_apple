package apple.blog.categorylist.repository;

import apple.blog.categorylist.model.CategoryList;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryListRepository extends JpaRepository<CategoryList, Long> {
    List<CategoryList> findAllByCategoryId(Long categoryId);
    List<CategoryList> findAllByLargeCategoryId(Long largeCategoryId);
    List<CategoryList> findAllByPostId(Long postId);
}
