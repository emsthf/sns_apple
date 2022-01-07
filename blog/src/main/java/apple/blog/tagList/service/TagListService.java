package apple.blog.taglist.service;

import apple.blog.taglist.dto.TagListDto;
import apple.blog.taglist.model.TagList;

import java.util.List;

public interface TagListService {
    TagList addTagList(TagListDto tagListDto);
    List<TagList> getAll();
    List<TagList> getAllTagByPostId(Long postId);
    void delTagList(Long id);
    void delAllByPostId(Long postId);
}
