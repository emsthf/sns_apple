package apple.blog.sns.controller;

import apple.blog.sns.model.Sns;
import apple.blog.sns.service.SnsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/sns")
public class SnsController {

    @Autowired
    private SnsService snsService;

    @PostMapping("/add")
    public Sns add(@RequestBody Sns sns) {
        return snsService.addSns(sns);
    }

    @GetMapping("/getAll")
    public List<Sns> getAll() {
        return snsService.getAllSns();
    }

    @GetMapping("/get/{id}")
    public Optional<Sns> get(@PathVariable("id") Long id) {
        return snsService.getSns(id);
    }

    @DeleteMapping("/del/{id}")
    public void del(@PathVariable("id") Long id) {
        snsService.delSns(id);
    }
}
