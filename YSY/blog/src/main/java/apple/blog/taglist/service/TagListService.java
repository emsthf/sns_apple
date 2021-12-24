package apple.blog.taglist.service;

import apple.blog.tag.model.Tag;
import apple.blog.taglist.model.TagList;

import java.util.List;
import java.util.Optional;

public interface TagListService {
    TagList addTagList(TagList tagList);
    List<TagList> getAllTagList();
    Optional<TagList> getTagList(Long id);
}
