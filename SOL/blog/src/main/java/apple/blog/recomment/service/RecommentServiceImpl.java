package apple.blog.recomment.service;

import apple.blog.recomment.model.Recomment;
import apple.blog.recomment.repository.RecommentRepository;
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

    @Override
    public Recomment addRecomment(Recomment recomment) {
        log.info("add Recomment.");
        return recommentRepository.save(recomment);
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
