package apple.blog.recomment.service;

import apple.blog.recomment.dto.IRecomment;
import apple.blog.recomment.model.Recomment;

import java.util.List;
import java.util.Optional;

public interface RecommentService {
    Recomment addRecomment(IRecomment iRecomment);
    List<Recomment> getAllRecomment();
    Optional<Recomment> getRecomment(Long id);
    void delRecomment(Long id);
}
