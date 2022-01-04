package apple.blog.smallCategory.service;

import apple.blog.smallCategory.dto.CategoryDto;
import apple.blog.smallCategory.model.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    Category addCategory(CategoryDto categoryDto);
    List<Category> getAllCategory();
    Optional<Category> getCategoryById(Long id);
    void delCategory(Long id);
}
