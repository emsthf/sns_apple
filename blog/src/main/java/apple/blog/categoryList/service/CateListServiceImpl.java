package apple.blog.categoryList.service;

import apple.blog.categoryList.model.CateList;
import apple.blog.categoryList.repository.CateListRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Service
public class CateListServiceImpl implements CateListService {

    private final CateListRepository cateListRepository;

    @Override
    public List<CateList> getAllCateList() {
        log.info("get all CateList.");
        return cateListRepository.findAll();
    }

    @Override
    public Optional<CateList> getCateListById(Long id) {
        log.info("get CateList by Id {}.", id);
        return Optional.ofNullable(cateListRepository.findById(id)).get();
    }

    @Override
    public CateList addCateList(CateList cateList) {
        log.info("add CateList.");
        return cateListRepository.save(cateList);
    }
}
