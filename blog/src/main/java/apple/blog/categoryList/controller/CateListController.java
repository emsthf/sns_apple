package apple.blog.categoryList.controller;

import apple.blog.categoryList.model.CateList;
import apple.blog.categoryList.service.CateListService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/cateList")
public class CateListController {

    private final CateListService cateListService;

    @GetMapping("/getAll")
    public List<CateList> getAll() {
        return cateListService.getAllCateList();
    }

    @GetMapping("/get/{id}")
    public CateList get(@PathVariable("id") Long id) {
        return cateListService.getCateListById(id).get();
    }

    @PostMapping("/add")
    public CateList addCateList(@RequestBody CateList cateList) {
        return cateListService.addCateList(cateList);
    }
}
