package apple.blog.categoryList.service;

import apple.blog.categoryList.model.CateList;

import java.util.List;
import java.util.Optional;

public interface CateListService {
    CateList addCateList(CateList cateList);
    List<CateList> getAllCateList();
    Optional<CateList> getCateListById(Long id);
}
