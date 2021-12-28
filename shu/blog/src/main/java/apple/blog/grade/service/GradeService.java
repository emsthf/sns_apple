package apple.blog.grade.service;

import apple.blog.grade.medel.Grade;

import java.util.List;
import java.util.Optional;

public interface GradeService {
    Grade addGrade(Grade grade);
    List<Grade> getAllGrade();
    Optional<Grade> getGrade(Long id);
    void delGrade(Long id);
}
