package apple.blog.categorylist.service;

import apple.blog.category.model.Category;

import java.util.List;
import java.util.Optional;

public interface CateListService {
    List<Category> getAllCateList();
    Optional<Category> getCateList(Long id);

}
