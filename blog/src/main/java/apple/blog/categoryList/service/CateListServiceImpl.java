package apple.blog.categoryList.service;

import apple.blog.categoryList.model.CateList;
import apple.blog.categoryList.repository.CateListRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Slf4j
@Service
public class CateListServiceImpl implements CateListService {

    private final CateListRepository cateListRepository;

    @Override
    public List<CateList> getAllCateList() {
        log.info("get all Category List.");
        return cateListRepository.findAll();
    }

    @Override
    public Optional<CateList> getCateListById(Long id) {
        log.info("get Category List by id {}.", id);
        return Optional.ofNullable(cateListRepository.findById(id)).get();
    }

    @Override
    public CateList addCateList(CateList cateList) {
        log.info("save Category List.");
        return cateListRepository.save(cateList);
    }
}
