package apple.blog.categorylist.service;

import apple.blog.categorylist.dto.CategorListDto;
import apple.blog.categorylist.model.CategoryList;

import java.util.List;

public interface CategoryListService {
    CategoryList addCategoryList(CategorListDto categorListDto);
    List<CategoryList> getAll();
    List<CategoryList> getAllByCategoryId(Long categoryId);
    List<CategoryList> getAllByLargeCategoryId(Long largeCategoryId);
    void delCateList(Long id);
}
