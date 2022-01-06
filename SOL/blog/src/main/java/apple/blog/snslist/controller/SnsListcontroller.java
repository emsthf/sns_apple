package apple.blog.snslist.controller;

import apple.blog.snslist.dto.SnsListDto;
import apple.blog.snslist.model.SnsList;
import apple.blog.snslist.service.SnsListService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/snslist")
public class SnsListcontroller {

    private final SnsListService snsListService;

    @PostMapping("/add")
    public SnsList add(@RequestBody SnsListDto snsListDto) {
        return snsListService.addSnsList(snsListDto);
    }

    @PutMapping("/edit")
    public SnsList edit(@RequestBody SnsListDto snsListDto) {
        return snsListService.editSnsList(snsListDto);
    }

    @GetMapping("/getAll")
    public List<SnsList> getAll() {
        return snsListService.getAll();
    }

    @DeleteMapping("/del/{id}")
    public void delSnsList(@PathVariable Long id) {
        snsListService.delSnsList(id);
    }
}
