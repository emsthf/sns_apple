package apple.blog.snslist.service;

import apple.blog.snslist.dto.SnsListDto;
import apple.blog.snslist.model.SnsList;

import java.util.List;

public interface SnsListService {
    SnsList addSnsList(SnsListDto snsListDto);
    SnsList editSnsList(SnsListDto snsListDto);
    List<SnsList> getAll();
    void delSnsList(Long id);
}
