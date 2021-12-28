package apple.blog.snsList.service;

import apple.blog.snsList.model.SnsList;
import apple.blog.snsList.repository.SnsListRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Service
public class SnsListServiceImpl implements SnsListService {

    private final SnsListRepository snsListRepository;

    @Override
    public List<SnsList> getAllSnsList() {
        log.info("get all Sns List.");
        return snsListRepository.findAll();
    }

    @Override
    public Optional<SnsList> getSnsListById(Long id) {
        log.info("get Sns List by id {}.", id);
        return Optional.ofNullable(snsListRepository.findById(id)).get();
    }

    @Override
    public SnsList addSnsList(SnsList snsList) {
        log.info("save Sns List.");
        return snsListRepository.save(snsList);
    }

    @Override
    public void delSnsList(Long id) {
        log.info("delete Sns List.");
        snsListRepository.deleteById(id);
    }
}
