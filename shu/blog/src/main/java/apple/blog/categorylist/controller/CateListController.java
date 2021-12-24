package apple.blog.categorylist.controller;

import apple.blog.category.model.Category;
import apple.blog.categorylist.model.CateList;
import apple.blog.categorylist.service.CateListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestBody("/cateList")
public class CateListController {
    @Autowired
    private CateListService cateListService;

    @GetMapping("/getAll")
    public List<CateList> getAll(){
        return cateListService.getAllCateList();
    }

    @GetMapping("/get/{id}")
    public Optional<Category> get(@PathVariable)("id")Long id) {
        return cateListService.getCateList(id).get();
    }
}
