package apple.blog.categorylist.service;

import apple.blog.categorylist.dto.CategorListDto;
import apple.blog.categorylist.model.CategoryList;
import apple.blog.categorylist.repository.CategoryListRepository;
import apple.blog.largeCategory.service.LargeCategoryService;
import apple.blog.post.service.PostService;
import apple.blog.smallCategory.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CategoryListServiceImple implements CategoryListService{

    private final CategoryListRepository categoryListRepository;
    private final CategoryService categoryService;
    private final LargeCategoryService largeCategoryService;
    private final PostService postService;

    @Override
    public CategoryList addCategoryList(CategorListDto categorListDto) {

        return categoryListRepository.save(
                CategoryList.builder()
                        .category(categoryService.getCategoryById(categorListDto.getCategoryId()).get())
                        .id(null)
                        .largeCategory(largeCategoryService.getLargeCateById(categorListDto.getLargeCategoryId()).get())
                        .post(postService.getPostById(categorListDto.getPostId()).get())
                        .build()
        );
    }

    @Override
    public List<CategoryList> getAll() {
        return categoryListRepository.findAll();
    }
}
