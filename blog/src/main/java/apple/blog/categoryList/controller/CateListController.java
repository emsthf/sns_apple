package apple.blog.categoryList.controller;

import apple.blog.category.service.CategoryService;
import apple.blog.categoryList.dto.ICateList;
import apple.blog.categoryList.model.CateList;
import apple.blog.categoryList.service.CateListService;
import apple.blog.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/cateList")
public class CateListController {

    private final CateListService cateListService;
    private final PostService postService;
    private final CategoryService categoryService;

    @GetMapping("/getAll")
    public List<CateList> getAll() {
        return cateListService.getAllCateList();
    }

    @GetMapping("/get/{id}")
    public CateList get(@PathVariable("id") Long id) {
        return cateListService.getCateListById(id).get();
    }

    @PostMapping("/add")
    public CateList addCateList(@RequestBody ICateList iCateList) {
        return cateListService.addCateList(
                new CateList(
                        categoryService.getCategoryById(iCateList.getCategoryId()).get(),
                        postService.getPostById(iCateList.getPostId()).get()
                )
        );
    }
}
