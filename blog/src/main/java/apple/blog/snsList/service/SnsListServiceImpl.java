package apple.blog.snsList.service;

import apple.blog.sns.model.Sns;
import apple.blog.sns.service.SnsService;
import apple.blog.snsList.model.SnsList;
import apple.blog.snsList.repository.SnsListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SnsListServiceImpl implements SnsListService {
    @Autowired
    private SnsListRepository snsListRepository;

    @Override
    public List<SnsList> getAllSnsList() {
        return snsListRepository.findAll();
    }

    @Override
    public Optional<SnsList> getSnsList(Long id) {
        return Optional.ofNullable(snsListRepository.findById(id)).get();
    }
}
