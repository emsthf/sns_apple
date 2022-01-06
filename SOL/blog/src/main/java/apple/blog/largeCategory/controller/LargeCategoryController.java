package apple.blog.largeCategory.controller;

import apple.blog.largeCategory.model.LargeCategory;
import apple.blog.largeCategory.service.LargeCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/largeCate")
@RestController
@RequiredArgsConstructor
public class LargeCategoryController {

    private final LargeCategoryService largeCategoryService;

    @PostMapping("/add")
    public void addLargeCate(@RequestBody LargeCategory largeCategory) {
        largeCategoryService.addLargeCate(largeCategory);
    }

    @GetMapping("/getAll")
    public List<LargeCategory> getAll() {
        return largeCategoryService.getAllLargeCate();
    }

    @GetMapping("/get/{id}")
    public Optional<LargeCategory> getLargeCateById(@PathVariable Long id) {
        return largeCategoryService.getLargeCateById(id);
    }
}
