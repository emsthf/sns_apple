package apple.blog.smallCategory.service;

import apple.blog.largeCategory.service.LargeCategoryService;
import apple.blog.smallCategory.dto.CategoryDto;
import apple.blog.smallCategory.model.Category;
import apple.blog.smallCategory.repository.CategoryRepository;
import apple.blog.post.service.PostService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Service
public class CategoryServiceImpl implements CategoryService{

    private final CategoryRepository categoryRepository;
    private final LargeCategoryService largeCategoryService;

    @Override
    public Category addCategory(CategoryDto categoryDto) {
        log.info("add Category.");
        Category category = new Category();
        try {
            category = categoryRepository.save(
                    Category.builder()
                            .largeCategory(largeCategoryService.getLargeCateById(categoryDto.getLargeCategoryId()).get())
                            .name(categoryDto.getName())
                            .build()
            );
        } catch (Exception e) {
            log.error("error : {}", e.getMessage());
        }

        return category;
    }

    @Override
    public List<Category> getAllCategory() {
        log.info("get all Category.");
        List<Category> categories = new ArrayList<>();
        try {
            categories = categoryRepository.findAll();
        } catch (Exception e) {
            log.error("error : {}", e.getMessage());
        }
        return categories;
    }

    @Override
    public Optional<Category> getCategoryById(Long id) {
        log.info("get Category by Id {}.", id);
        Optional<Category> category = Optional.empty();
        try {
            category = Optional.ofNullable(categoryRepository.findById(id).get());
        } catch (Exception e) {
            log.error("error : {}", e.getMessage());
        }
        return category;
    }

    @Override
    public void delCategory(Long id) {
        log.info("delete Category by id {}.", id);
        try {
            categoryRepository.deleteById(id);
        } catch (Exception e) {
            log.error("error : {}", e.getMessage());
        }
    }
}
