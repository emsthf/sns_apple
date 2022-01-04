package apple.blog.categorylist.service;

import apple.blog.categorylist.dto.CategorListDto;
import apple.blog.categorylist.model.CategoryList;

import java.util.List;

public interface CategoryListService {

    CategoryList addCategoryList(CategorListDto categorListDto);
    List<CategoryList> getAll();


}
