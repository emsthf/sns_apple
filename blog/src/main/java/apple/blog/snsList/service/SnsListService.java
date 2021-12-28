package apple.blog.snsList.service;

import apple.blog.snsList.model.SnsList;

import java.util.List;
import java.util.Optional;

public interface SnsListService {
    List<SnsList> getAllSnsList();
    Optional<SnsList> getSnsListById(Long id);
    SnsList addSnsList(SnsList snsList);
    void delSnsList(Long id);
}
