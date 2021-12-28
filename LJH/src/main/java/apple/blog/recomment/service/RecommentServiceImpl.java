package apple.blog.recomment.service;

import apple.blog.recomment.model.Recomment;
import apple.blog.recomment.repository.RecommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecommentServiceImpl implements RecommentService {
    @Autowired
    private RecommentRepository recommentRepository;

    @Override
    public Recomment addRecomment(Recomment recomment) {
        return recommentRepository.save(recomment);
    }

    @Override
    public List<Recomment> getAllRecomment() {
        return recommentRepository.findAll();
    }

    @Override
    public Optional<Recomment> getRecomment(Long id) {
        return Optional.ofNullable(recommentRepository.findById(id)).get();
    }

    @Override
    public void delRecomment(Long id) {
        recommentRepository.deleteById(id);
    }
}
