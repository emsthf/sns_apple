package apple.blog.grade.service;

import apple.blog.grade.medel.Grade;
import apple.blog.grade.repository.GradeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Service
public class GradeServiceImpl implements GradeService {

    private final GradeRepository gradeRepository;

    @Override
    public Grade addGrade(Grade grade) {
        log.info("save Grade.");
        return gradeRepository.save(grade);
    }

    @Override
    public Grade editGrade(Grade grade) {
        log.info("edit Grade {}.", gradeRepository.findById(grade.getId()).get());
        Grade editGrade = Grade.builder()
                .id(grade.getId())
                .name(grade.getName())
                .build();
        gradeRepository.save(editGrade);
        return editGrade;
    }

    @Override
    public List<Grade> getAllGrade() {
        log.info("get all Grade.");
        return gradeRepository.findAll();
    }

    @Override
    public Optional<Grade> getGrade(Long id) {
        log.info("get Grade by Id {}.", id);
        return Optional.ofNullable(gradeRepository.findById(id)).get();
    }

    @Override
    public void delGrade(Long id) {
        log.info("delete Grade by Id {}.", id);
        gradeRepository.deleteById(id);
    }
}
