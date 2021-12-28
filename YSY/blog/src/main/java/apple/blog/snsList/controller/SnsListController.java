package apple.blog.snsList.controller;

import apple.blog.sns.service.SnsService;
import apple.blog.snsList.dto.ISnsList;
import apple.blog.snsList.model.SnsList;
import apple.blog.snsList.service.SnsListService;
import apple.blog.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/snsList")
public class SnsListController {
    @Autowired
    private SnsListService snsListService;

    @Autowired
    private SnsService snsService;

    @Autowired
    private UserService userService;

    @GetMapping("/getAll")
    public List<SnsList> getAll() {
        return snsListService.getAllSnsList();
    }

    @GetMapping("/get/{id}")
    public Optional<SnsList> get(@PathVariable("id") Long id) {
        return snsListService.getSnsList(id);
    }

    @PostMapping("/add")
    public SnsList add(@RequestBody ISnsList iSnsList) {
        return snsListService.addSnsList(
                new SnsList(
                        snsService.getSns(iSnsList.getSnsId()).get(),
                        userService.getUser(iSnsList.getUserId()).get()
                )
        );
    }

    @DeleteMapping("/del/{id}")
    public void del(@PathVariable("id") Long id) {
        snsListService.delSnsList(id);
    }

}
