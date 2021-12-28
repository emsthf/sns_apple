package apple.blog.tagList.service;

import apple.blog.tagList.model.TagList;
import apple.blog.tagList.repository.TagListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TagListServiceImpl implements TagListService{

    @Autowired
    private TagListRepository tagListRepository;

    @Override
    public TagList addTagList(TagList tagList) {
        return tagListRepository.save(tagList);
    }

    @Override
    public List<TagList> getAllTagList() {
        return tagListRepository.findAll();
    }

    @Override
    public Optional<TagList> getTagList(Long id) {
        return Optional.ofNullable(tagListRepository.findById(id).get());
    }
}
