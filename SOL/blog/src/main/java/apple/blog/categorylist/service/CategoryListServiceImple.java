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

import java.util.ArrayList;
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
        CategoryList categoryList = new CategoryList();
        try {
            categoryList = categoryListRepository.save(
                    CategoryList.builder()
                            .category(categoryService.getCategoryById(categorListDto.getCategoryId()).get())
                            .id(null)
                            .largeCategory(largeCategoryService.getLargeCateById(categorListDto.getLargeCategoryId()).get())
                            .post(postRepository.findById(categorListDto.getPostId()).get())
                            .build()
            );
        } catch (Exception e) {
            log.error("error : {}", e.getMessage());
        }
        return categoryList;
    }

    @Override
    public List<CategoryList> getAll() {
        log.info("get all CateList.");
        List<CategoryList> categoryLists = new ArrayList<>();
        try {
            categoryLists = categoryListRepository.findAll();
        } catch (Exception e) {
            log.error("error : {}", e.getMessage());
        }
        return categoryLists;
    }

    @Override
    public List<CategoryList> getAllByCategoryId(Long categoryId) {
        log.info("Get All Category List by Category Id {}.",categoryId);
        List<CategoryList> categoryLists = new ArrayList<>();
        try {
            categoryLists = categoryListRepository.findAllByCategoryId(categoryId);
        } catch (Exception e) {
            log.error("error : {}", e.getMessage());
        }
        return categoryLists;
    }

    @Override
    public List<CategoryList> getAllByLargeCategoryId(Long largeCategoryId) {
        log.info("Get All Category List by large Category Id {}.",largeCategoryId);
        List<CategoryList> categoryLists = new ArrayList<>();
        try {
            categoryLists = categoryListRepository.findAllByLargeCategoryId(largeCategoryId);
        } catch (Exception e) {
            log.error("error : {}" ,e.getMessage());
        }
        return categoryLists;
    }

    @Override
    public void delCateList(Long id) {
        log.info("Delete Category List by Id{}.", id);
        try {
            categoryListRepository.deleteById(id);
        } catch (Exception e) {
            log.error("error : {}", e.getMessage());
        }
    }
}
