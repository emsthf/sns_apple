package apple.blog.largeCategory.service;

import apple.blog.largeCategory.model.LargeCategory;

import java.util.List;
import java.util.Optional;

public interface LargeCategoryService {
    LargeCategory addLargeCate(LargeCategory largeCategory);
    List<LargeCategory> getAllLargeCate();
    Optional<LargeCategory> getLargeCateById(Long id);
}
