package apple.blog.recomment.service;

import apple.blog.comment.service.CommentService;
import apple.blog.recomment.dto.RecommentDto;
import apple.blog.recomment.model.Recomment;
import apple.blog.recomment.repository.RecommentRepository;
import apple.blog.user.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Service
public class RecommentServiceImpl implements RecommentService {

    private final RecommentRepository recommentRepository;
    private final UserService userService;

    @Override
    public Recomment addRecomment(RecommentDto recommentDto) {
        log.info("add Recomment.");
        return recommentRepository.save(
                Recomment.builder()
                        .id(null)
                        .text(recommentDto.getText())
                        .user(userService.getUserById(recommentDto.getUserId()).get())
                        .build()
        );
    }

    @Override
    public Recomment editRecomment(RecommentDto recommentDto) {
        log.info("edit Recomment {}.", recommentRepository.findById(recommentDto.getId()).get());
        Recomment recomment = Recomment.builder()
                .id(recommentDto.getId())
                .text(recommentDto.getText())
                .user(userService.getUserById(recommentDto.getUserId()).get())
                .build();
        recommentRepository.save(recomment);
        return recomment;
    }

    @Override
    public List<Recomment> getAllRecomment() {
        log.info("get all Recomments.");
        return recommentRepository.findAll();
    }

    @Override
    public Optional<Recomment> getRecommentById(Long id) {
        log.info("get Recomment by Id {}.", id);
        return Optional.ofNullable(recommentRepository.findById(id)).get();
    }

    @Override
    public void delRecomment(Long id) {
        log.info("delete Recomment by Id {}.", id);
        recommentRepository.deleteById(id);
    }
}
