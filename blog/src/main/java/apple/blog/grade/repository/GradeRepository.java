package apple.blog.grade.repository;

import apple.blog.grade.medel.Grade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GradeRepository extends JpaRepository<Grade, Long> {
}
