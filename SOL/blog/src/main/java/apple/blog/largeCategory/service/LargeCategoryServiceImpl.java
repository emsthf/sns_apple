package apple.blog.largeCategory.service;

import apple.blog.largeCategory.model.LargeCategory;
import apple.blog.largeCategory.repository.LargeCategoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Service
public class LargeCategoryServiceImpl implements LargeCategoryService {

    private final LargeCategoryRepository largeCategoryRepository;

    @Override
    public LargeCategory addLargeCate(LargeCategory largeCategory) {
        log.info("대분류 카테고리 추가.");
        LargeCategory addLargeCategory = new LargeCategory();
        try {
            addLargeCategory = largeCategoryRepository.save(largeCategory);
        } catch (Exception e) {
            log.error("error : {}", e.getMessage());
        }
        return addLargeCategory;
    }

    @Override
    public List<LargeCategory> getAllLargeCate() {
        log.info("대분류 카테고리 전부 불러오기");
        List<LargeCategory> largeCategories = new ArrayList<>();
        try {
            largeCategories = largeCategoryRepository.findAll();
        } catch (Exception e) {
            log.error("error : {}", e.getMessage());
        }
        return largeCategories;
    }

    @Override
    public Optional<LargeCategory> getLargeCateById(Long id) {
        log.info("대분류 카테고리 id로 검색");
        Optional<LargeCategory> largeCategory = Optional.empty();
        try {
            largeCategory = Optional.ofNullable(largeCategoryRepository.findById(id).get());
        } catch (Exception e) {
            log.error("error : {}", e.getMessage());
        }
        return largeCategory;
    }
}
