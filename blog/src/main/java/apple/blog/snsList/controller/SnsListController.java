package apple.blog.snsList.controller;

import apple.blog.snsList.model.SnsList;
import apple.blog.snsList.service.SnsListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/snsList")
public class SnsListController {
    @Autowired
    private SnsListService snsListService;

    @GetMapping("/getAll")
    public List<SnsList> getAll() {
        return snsListService.getAllSnsList();
    }

    @GetMapping("/get/{id}")
    public Optional<SnsList> get(@PathVariable("id") Long id) {
        return snsListService.getSnsList(id);
    }

}
