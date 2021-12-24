package apple.blog.categoryList.service;

import apple.blog.categoryList.model.CateList;

import java.util.List;
import java.util.Optional;

public interface CateListService {
    List<CateList> getAllCateList();
    Optional<CateList> getCateList(Long id);
}
