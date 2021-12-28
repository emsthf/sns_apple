package apple.blog.recomment.service;

import apple.blog.comment.service.CommentService;
import apple.blog.recomment.dto.IRecomment;
import apple.blog.recomment.model.Recomment;
import apple.blog.recomment.repository.RecommentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class RecommentServiceImpl implements RecommentService {

    private final RecommentRepository recommentRepository;
    private final CommentService commentService;

    @Override
    public Recomment addRecomment(IRecomment iRecomment) {
        log.info("save recomment.");
        return recommentRepository.save(
                Recomment.builder()
                        .comment(commentService.getComment(iRecomment.getCommentId()).get())
                        .build()
        );
    }

    @Override
    public List<Recomment> getAllRecomment() {
        log.info("Fetching all recomment.");
        return recommentRepository.findAll();
    }

    @Override
    public Optional<Recomment> getRecomment(Long id) {
        log.info("Fetching recomment.");
        return Optional.ofNullable(recommentRepository.findById(id)).get();
    }

    @Override
    public void delRecomment(Long id) {
        log.info("Del recomment.");
        recommentRepository.deleteById(id);
    }
}
