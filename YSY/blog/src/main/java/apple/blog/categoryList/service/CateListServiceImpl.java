package apple.blog.categoryList.service;

import apple.blog.category.service.CategoryService;
import apple.blog.categoryList.dto.ICateList;
import apple.blog.categoryList.model.CateList;
import apple.blog.categoryList.repository.CateListRepository;

import apple.blog.post.service.PostService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class CateListServiceImpl implements CateListService {

    private final CateListRepository cateListRepository;
    private final CategoryService categoryService;
    private final PostService postService;

    @Override
    public CateList addCateList(ICateList iCateList) {
        log.info("save cateList.");
        return cateListRepository.save(
                CateList.builder()
                        .category(categoryService.getCategory(iCateList.getCategoryId()).get())
                        .post(postService.getPost(iCateList.getPostId()).get())
                        .build()
        );
    }
    @Override
    public List<CateList> getAllCateList() {
        log.info("Fetching all category.");
        return cateListRepository.findAll();
    }

    @Override
    public Optional<CateList> getCateList(Long id) {
        log.info("Fetching category.");
        return Optional.ofNullable(cateListRepository.findById(id)).get();
    }

}
