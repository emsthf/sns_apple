package apple.blog.categorylist.controller;

import apple.blog.categorylist.dto.CategorListDto;
import apple.blog.categorylist.model.CategoryList;
import apple.blog.categorylist.service.CategoryListService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/catelist")
@RequiredArgsConstructor
public class CategoryListController {

    private final CategoryListService categoryListService;

    @PostMapping("/add")
    public CategoryList addCateList(@RequestBody CategorListDto categorListDto){
        return categoryListService.addCategoryList(categorListDto);
    }

    @GetMapping("/getAll")
    public List<CategoryList> getAll(){
        return categoryListService.getAll();
    }

    @GetMapping("/getAllByCategoryId/{id}")
    public List<CategoryList> getAllCategoryId(@PathVariable Long id) {
        return categoryListService.getAllByCategoryId(id);
    }

    @GetMapping("/getAllByLargeCategoryId/{id}")
    public List<CategoryList> getAllLargeCategoryId(@PathVariable Long id) {
        return categoryListService.getAllByLargeCategoryId(id);
    }
}
