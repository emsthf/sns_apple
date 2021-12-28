package apple.blog.tagList.service;

import apple.blog.tagList.model.TagList;

import java.util.List;
import java.util.Optional;

public interface TagListService {
    TagList addTagList(TagList tagList);
    List<TagList> getAllTagList();
    Optional<TagList> getTagListById(Long id);
}
