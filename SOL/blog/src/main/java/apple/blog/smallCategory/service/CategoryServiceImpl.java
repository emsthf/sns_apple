package apple.blog.smallCategory.service;

import apple.blog.largeCategory.service.LargeCategoryService;
import apple.blog.smallCategory.dto.CategoryDto;
import apple.blog.smallCategory.model.Category;
import apple.blog.smallCategory.repository.CategoryRepository;
import apple.blog.post.service.PostService;
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
    private final PostService postService;
    private final LargeCategoryService largeCategoryService;

    @Override
    public Category addCategory(CategoryDto categoryDto) {
        log.info("add Category.");
        return categoryRepository.save(
                Category.builder()
                        .name(categoryDto.getName())
                        .type(categoryDto.getType())
                        .largeCategory(largeCategoryService.getLargeCateById(categoryDto.getLargeCategoryId()).get())
                        .build()
        );
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
