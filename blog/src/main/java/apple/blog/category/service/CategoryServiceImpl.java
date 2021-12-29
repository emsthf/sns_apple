package apple.blog.category.service;

import apple.blog.category.model.Category;
import apple.blog.category.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Service
public class CategoryServiceImpl implements CategoryService{

    private final CategoryRepository categoryRepository;

    @Override
    public Category addCategory(Category category) {
        log.info("add Category.");
        return categoryRepository.save(category);
    }

    @Override
    public List<Category> getAllCategory() {
        log.info("get all Category.");
        return categoryRepository.findAll();
    }

    @Override
    public Optional<Category> getCategoryById(Long id) {
        log.info("get Category by Id {}.", id);
        return Optional.ofNullable(categoryRepository.findById(id).get());
    }

    @Override
    public void delCategory(Long id) {
        log.info("delete Category by id {}.", id);
        categoryRepository.deleteById(id);
    }
}
