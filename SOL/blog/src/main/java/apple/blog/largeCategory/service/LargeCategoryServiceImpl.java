package apple.blog.largeCategory.service;

import apple.blog.largeCategory.model.LargeCategory;
import apple.blog.largeCategory.repository.LargeCategoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Service
public class LargeCategoryServiceImpl implements LargeCategoryService {

    private final LargeCategoryRepository largeCategoryRepository;

    @Override
    public LargeCategory addLargeCate(LargeCategory largeCategory) {
        return largeCategoryRepository.save(largeCategory);
    }

    @Override
    public List<LargeCategory> getAllLargeCate() {
        return largeCategoryRepository.findAll();
    }

    @Override
    public Optional<LargeCategory> getLargeCateById(Long id) {
        return Optional.ofNullable(largeCategoryRepository.findById(id).get());
    }
}
