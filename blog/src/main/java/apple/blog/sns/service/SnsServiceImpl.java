package apple.blog.sns.service;

import apple.blog.sns.model.Sns;
import apple.blog.sns.repository.SnsRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Service
public class SnsServiceImpl implements SnsService {

    private final SnsRepository snsRepository;

    @Override
    public Sns addSns(Sns sns) {
        log.info("save Sns.");
        return snsRepository.save(sns);
    }

    @Override
    public List<Sns> getAllSns() {
        log.info("get all Sns.");
        return snsRepository.findAll();
    }

    @Override
    public Optional<Sns> getSnsById(Long id) {
        log.info("get Sns by id {}.", id);
        return Optional.ofNullable(snsRepository.findById(id).get());
    }

    @Override
    public void delSns(Long id) {
        log.info("delete Sns by id {}.", id);
        snsRepository.deleteById(id);
    }
}
