package apple.blog.tag.service;

import apple.blog.tag.dto.TagDto;
import apple.blog.tag.model.Tag;

import java.util.List;
import java.util.Optional;

public interface TagService {
    Tag addTag(TagDto tagDto);
    List<Tag> getAllTag();
    List<Tag> getAllTagByPostId(Long id);
    Optional<Tag> getTagById(Long id);
    void delTag(Long id);
}
