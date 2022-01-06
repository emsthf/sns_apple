package apple.blog.categorylist.service;

import apple.blog.categorylist.dto.CategorListDto;
import apple.blog.categorylist.model.CategoryList;
import apple.blog.categorylist.repository.CategoryListRepository;
import apple.blog.largeCategory.service.LargeCategoryService;
import apple.blog.post.repository.PostRepository;
import apple.blog.post.service.PostService;
import apple.blog.smallCategory.service.CategoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class CategoryListServiceImple implements CategoryListService{

    private final CategoryListRepository categoryListRepository;
    private final CategoryService categoryService;
    private final LargeCategoryService largeCategoryService;
    private final PostRepository postRepository;

    @Override
    public CategoryList addCategoryList(CategorListDto categorListDto) {
        log.info("add CateList.");
        return categoryListRepository.save(
                CategoryList.builder()
                        .category(categoryService.getCategoryById(categorListDto.getCategoryId()).get())
                        .id(null)
                        .largeCategory(largeCategoryService.getLargeCateById(categorListDto.getLargeCategoryId()).get())
                        .post(postRepository.findById(categorListDto.getPostId()).get())
                        .build()
        );
    }

    @Override
    public List<CategoryList> getAll() {
        log.info("get all CateList.");
        return categoryListRepository.findAll();
    }

    @Override
    public List<CategoryList> getAllByCategoryId(Long categoryId) {
        return categoryListRepository.findAllByCategoryId(categoryId);
    }

    @Override
    public List<CategoryList> getAllByLargeCategoryId(Long largeCategoryId) {
        return categoryListRepository.findAllByLargeCategoryId(largeCategoryId);
    }

    @Override
    public void delCateList(Long id) {
        categoryListRepository.deleteById(id);
    }
}
