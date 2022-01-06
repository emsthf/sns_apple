package apple.blog.sns.service;

import apple.blog.sns.model.Sns;
import apple.blog.sns.repository.SnsRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Service
public class SnsServiceImpl implements SnsService {

    private final SnsRepository snsRepository;

    @Override
    public Sns addSns(Sns sns) {
        log.info("add Sns.");
        Sns addsns = new Sns();
        try {
            addsns = snsRepository.save(sns);
        } catch (Exception e) {
            log.error("error : {}", e.getMessage());
        }
        return addsns;
    }

    @Override
    public List<Sns> getAllSns() {
        log.info("get all Sns.");
        List<Sns> snsList = new ArrayList<>();
        try {
            snsList = snsRepository.findAll();
        } catch (Exception e) {
            log.error("error : {}", e.getMessage());
        }
        return snsList;
    }

    @Override
    public Optional<Sns> getSnsById(Long id) {
        log.info("get Sns by Id {}.", id);
        Optional<Sns> sns = Optional.empty();
        try {
            sns = Optional.ofNullable(snsRepository.findById(id).get());
        } catch (Exception e) {
            log.error("error : {}", e.getMessage());
        }
        return sns;
    }

    @Override
    public void delSns(Long id) {
        log.info("delete Sns by Id {}.", id);
        try {
            snsRepository.deleteById(id);
        } catch (Exception e) {
            log.error("error : {}", e.getMessage());
        }

    }
}
