package apple.blog.recomment.service;


import apple.blog.recomment.dto.RecommentDto;
import apple.blog.recomment.model.Recomment;
import apple.blog.recomment.repository.RecommentRepository;
import apple.blog.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Service
public class RecommentServiceImpl implements RecommentService {

    private final RecommentRepository recommentRepository;
    private final UserRepository userRepository;

    @Override
    public Recomment addRecomment(RecommentDto recommentDto) {
        log.info("add Recomment.");
        Recomment recomment = new Recomment();
        try {
            recomment = recommentRepository.save(
                    Recomment.builder()
                            .id(null)
                            .text(recommentDto.getText())
                            .user(userRepository.findById(recommentDto.getUserId()).get())
                            .build()
            );
        } catch (Exception e) {
            log.error("error : {}", e.getMessage());
        }
        return recomment;
    }

    @Override
    public Recomment editRecomment(RecommentDto recommentDto) {
        log.info("edit Recomment {}.", recommentRepository.findById(recommentDto.getId()).get());
        Recomment recomment = new Recomment();
        try {
            recomment = Recomment.builder()
                    .id(recommentDto.getId())
                    .text(recommentDto.getText())
                    .user(userRepository.findById(recommentDto.getUserId()).get())
                    .build();
            recommentRepository.save(recomment);
        } catch (Exception e) {
            log.error("error : {}", e.getMessage());
        }
        return recomment;
    }

    @Override
    public List<Recomment> getAllRecomment() {
        log.info("get all Recomments.");
        List<Recomment> recomments = new ArrayList<>();
        try {
            recomments = recommentRepository.findAll();
        } catch (Exception e) {
            log.error("error : {}", e.getMessage());
        }
        return recomments;
    }

    @Override
    public Optional<Recomment> getRecommentById(Long id) {
        log.info("get Recomment by Id {}.", id);
        Optional<Recomment> recomment = Optional.empty();
        try {
            recomment = Optional.ofNullable(recommentRepository.findById(id)).get();
        } catch (Exception e) {
            log.error("error : {}", e.getMessage());
        }
        return recomment;
    }

    @Override
    public void delRecomment(Long id) {
        log.info("delete Recomment by Id {}.", id);
        try {
            recommentRepository.deleteById(id);
        } catch (Exception e) {
            log.error("error : {}", e.getMessage());
        }
    }
}
