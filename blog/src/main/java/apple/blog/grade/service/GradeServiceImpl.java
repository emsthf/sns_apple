package apple.blog.grade.service;

import apple.blog.grade.medel.Grade;
import apple.blog.grade.repository.GradeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Slf4j
@Service
public class GradeServiceImpl implements GradeService {

    private final GradeRepository gradeRepository;

    @Override
    public Grade addGrade(Grade grade) {
        log.info("save Grade.");
        return gradeRepository.save(grade);
    }

    @Override
    public List<Grade> getAllGrade() {
        log.info("get all Grade.");
        return gradeRepository.findAll();
    }

    @Override
    public Optional<Grade> getGradeById(Long id) {
        log.info("get Grade by id {}", id);
        return Optional.ofNullable(gradeRepository.findById(id)).get();
    }

    @Override
    public void delGrade(Long id) {
        log.info("delete grade.");
        gradeRepository.deleteById(id);
    }
}
