package apple.blog.grade.service;

import apple.blog.grade.medel.Grade;
import apple.blog.grade.repository.GradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GradeServiceImpl implements GradeService {
    @Autowired
    private GradeRepository gradeRepository;

    @Override
    public Grade addGrade(Grade grade) {
        return gradeRepository.save(grade);
    }

    @Override
    public List<Grade> getAllGrade() {
        return gradeRepository.findAll();
    }

    @Override
    public Optional<Grade> getGrade(Long id) {
        return Optional.ofNullable(gradeRepository.findById(id)).get();
    }

    @Override
    public void delGrade(Long id) {
        gradeRepository.deleteById(id);
    }
}
