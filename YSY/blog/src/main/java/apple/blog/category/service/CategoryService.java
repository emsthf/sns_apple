package apple.blog.category.service;

import apple.blog.category.model.Category;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    Category addCategory(Category category);
    List<Category> getAllCategory();
    Optional<Category> getCategory(Long id);

}
