package apple.blog.snslist.controller;

import apple.blog.snslist.dto.OSnsListDto;
import apple.blog.snslist.dto.SnsListDto;
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
    public void add(@RequestBody SnsListDto snsListDto) {
        snsListService.addSnsList(snsListDto);
    }

    @PutMapping("/edit")
    public void edit(@RequestBody SnsListDto snsListDto) {
        snsListService.editSnsList(snsListDto);
    }

    @GetMapping("/getAll/{userId}")
    public List<OSnsListDto> getAll(@PathVariable Long userId) {
        return snsListService.getAll(userId);
    }

    @DeleteMapping("/del/{id}")
    public void delSnsList(@PathVariable Long id) {
        snsListService.delSnsList(id);
    }

    @DeleteMapping("/delAllByUserId/{id}")
    public boolean delAllByUserId(@PathVariable Long id){
        return snsListService.delAllByUserId(id);
    }
}
