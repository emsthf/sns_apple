package apple.blog.categorylist.service;

import apple.blog.category.model.Category;
import apple.blog.categorylist.repository.CateListRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class CateListServiceImpl implements CateListService{
    @Autowired
    private CateListRepository cateListRepository;


    @Override
    public List<Category> getAllCateList() {
        return cateListRepository.findAll();
    }

    @Override
    public Optional<Category> getCateList(Long id) {
        return Optional.ofNullable(cateListRepository.findById(id)).get();
    }
}

