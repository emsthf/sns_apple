package apple.blog.tagList.service;

import apple.blog.tagList.model.TagList;
import apple.blog.tagList.repository.TagListRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Service
public class TagListServiceImpl implements TagListService{

    private final TagListRepository tagListRepository;

    @Override
    public TagList addTagList(TagList tagList) {
        log.info("add Tag List.");
        return tagListRepository.save(tagList);
    }

    @Override
    public List<TagList> getAllTagList() {
        log.info("get all Tag List.");
        return tagListRepository.findAll();
    }

    @Override
    public Optional<TagList> getTagListById(Long id) {
        log.info("get Tag List by Id {}.", id);
        return Optional.ofNullable(tagListRepository.findById(id).get());
    }
}
