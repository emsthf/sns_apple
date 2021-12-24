package apple.blog.category.controller;

import apple.blog.category.model.Category;
import apple.blog.category.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @PostMapping("/add")
    public Category add(@RequestBody Category category){
        return categoryService.addCategory(category);
    }

    @GetMapping("/getAll")
    public List<Category> getAll(){
        return categoryService.getAllCategory();
    }

    @GetMapping("/get/{id}")
    public Optional<Category> get(@PathVariable("id")Long id) {
        return categoryService.getCategory(id);
    }
}
