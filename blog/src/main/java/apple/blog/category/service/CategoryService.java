package apple.blog.category.service;

import apple.blog.category.model.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    Category addCategory(Category category);
    List<Category> getAllCategory();
    Optional<Category> getCategoryById(Long id);

}
