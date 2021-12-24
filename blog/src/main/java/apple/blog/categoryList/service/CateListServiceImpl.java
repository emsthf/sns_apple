package apple.blog.categoryList.service;

import apple.blog.categoryList.model.CateList;
import apple.blog.categoryList.repository.CateListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CateListServiceImpl implements CateListService {
    @Autowired
    private CateListRepository cateListRepository;

    @Override
    public List<CateList> getAllCateList() {
        return cateListRepository.findAll();
    }

    @Override
    public Optional<CateList> getCateList(Long id) {
        return Optional.ofNullable(cateListRepository.findById(id)).get();
    }
}
