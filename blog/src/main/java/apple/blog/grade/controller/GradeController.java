package apple.blog.grade.controller;

import apple.blog.grade.medel.Grade;
import apple.blog.grade.service.GradeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/grade")
public class GradeController {

    private final GradeService gradeService;

    @PostMapping("/add")
    public Grade add(@RequestBody Grade grade) {
        return gradeService.addGrade(grade);
    }

    @GetMapping("/getAll")
    public List<Grade> getAll() {
        return gradeService.getAllGrade();
    }

    @GetMapping("/get/{id}")
    public Grade get(@PathVariable("id") Long id) {
        return gradeService.getGrade(id).get();
    }

    @DeleteMapping("/del/{id}")
    public void del(@PathVariable("id") Long id) {
        gradeService.delGrade(id);
    }
}

