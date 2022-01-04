package apple.blog.smallCategory.controller;

import apple.blog.smallCategory.dto.CategoryDto;
import apple.blog.smallCategory.model.Category;
import apple.blog.smallCategory.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/category")
public class CategoryController {

    private final CategoryService categoryService;

    @PostMapping("/add")
    public Category add(@RequestBody CategoryDto categoryDto){
        return categoryService.addCategory(categoryDto);
    }

    @GetMapping("/getAll")
    public List<Category> getAll(){
        return categoryService.getAllCategory();
    }

    @GetMapping("/get/{id}")
    public Optional<Category> get(@PathVariable("id") Long id) {
        return categoryService.getCategoryById(id);
    }

    @DeleteMapping("/del/{id}")
    public void delCategory(@PathVariable("id") Long id) {
        categoryService.delCategory(id);
    }
}
