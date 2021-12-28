package apple.blog.sns.service;

import apple.blog.sns.model.Sns;
import apple.blog.sns.repository.SnsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Service
public class SnsServiceImpl implements SnsService {
    @Autowired
    private SnsRepository snsRepository;

    @Override
    public Sns addSns(Sns sns) {
        return snsRepository.save(sns);
    }

    @Override
    public List<Sns> getAllSns() {
        return snsRepository.findAll();
    }

    @Override
    public Optional<Sns> getSns(Long id) {
        return Optional.ofNullable(snsRepository.findById(id).get());
    }

    @Override
    public void delSns(Long id) {
        snsRepository.deleteById(id);
    }
}
