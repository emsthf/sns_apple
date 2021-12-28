package apple.blog.categoryList.controller;

import apple.blog.categoryList.dto.ICateList;
import apple.blog.categoryList.model.CateList;
import apple.blog.categoryList.service.CateListService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
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
        return cateListService.getCateList(id).get();
    }

    @PostMapping("/add")
    public CateList addCateList(@RequestBody ICateList iCateList) {
        return cateListService.addCateList(iCateList);
    }
}
