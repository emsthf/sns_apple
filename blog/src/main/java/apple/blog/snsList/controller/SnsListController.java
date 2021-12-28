package apple.blog.snsList.controller;

import apple.blog.sns.service.SnsService;
import apple.blog.snsList.dto.ISnsList;
import apple.blog.snsList.model.SnsList;
import apple.blog.snsList.service.SnsListService;
import apple.blog.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/snsList")
public class SnsListController {

    private final SnsListService snsListService;
    private final SnsService snsService;
    private final UserService userService;

    @GetMapping("/getAll")
    public List<SnsList> getAll() {
        return snsListService.getAllSnsList();
    }

    @GetMapping("/get/{id}")
    public Optional<SnsList> get(@PathVariable("id") Long id) {
        return snsListService.getSnsListById(id);
    }

    @PostMapping("/add")
    public SnsList add(@RequestBody ISnsList iSnsList) {
        return snsListService.addSnsList(
                new SnsList(
                        snsService.getSnsById(iSnsList.getSnsId()).get(),
                        userService.getUserById(iSnsList.getUserId()).get()
                )
        );
    }

    @DeleteMapping("/del/{id}")
    public void del(@PathVariable("id") Long id) {
        snsListService.delSnsList(id);
    }

}
