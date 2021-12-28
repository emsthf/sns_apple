package apple.blog.tag.service;

import apple.blog.tag.model.Tag;

import java.util.List;
import java.util.Optional;

public interface TagService {
    Tag addTag(Tag tag);
    List<Tag> getAllTag();
    Optional<Tag> getTagById(Long id);
    void delTag(Long id);
}
