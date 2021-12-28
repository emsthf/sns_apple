package apple.blog.categoryList.controller;

import apple.blog.categoryList.model.CateList;
import apple.blog.categoryList.service.CateListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cateList")
public class CateListController {
    @Autowired
    private CateListService cateListService;

    @GetMapping("/getAll")
    public List<CateList> getAll() {
        return cateListService.getAllCateList();
    }

    @GetMapping("/get/{id}")
    public CateList get(@PathVariable("id") Long id) {
        return cateListService.getCateList(id).get();
    }

    @PostMapping("/add")
    public CateList addCateList(@RequestBody CateList cateList) {
        return cateListService.addCateList(cateList);
    }
}
