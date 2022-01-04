package apple.blog.recomment.service;

import apple.blog.recomment.dto.RecommentDto;
import apple.blog.recomment.model.Recomment;

import java.util.List;
import java.util.Optional;

public interface RecommentService {
    Recomment addRecomment(RecommentDto recommentDto);
    Recomment editRecomment(RecommentDto recommentDto);
    List<Recomment> getAllRecomment();
    Optional<Recomment> getRecommentById(Long id);
    void delRecomment(Long id);
}
