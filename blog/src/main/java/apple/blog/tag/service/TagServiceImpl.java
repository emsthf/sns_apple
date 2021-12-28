package apple.blog.tag.service;

import apple.blog.tag.model.Tag;
import apple.blog.tag.repository.TagRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Service
public class TagServiceImpl implements TagService{

    private final TagRepository tagRepository;

    @Override
    public Tag addTag(Tag tag) {
        log.info("save Tag.");
        return tagRepository.save(tag);
    }

    @Override
    public List<Tag> getAllTag() {
        log.info("get all Tag.");
        return tagRepository.findAll();
    }

    @Override
    public Optional<Tag> getTagById(Long id) {
        log.info("get Tag by id {}.", id);
        return Optional.ofNullable(tagRepository.findById(id).get());
    }

    @Override
    public void delTag(Long id) {
        log.info("delete Tag by id {}.", id);
        tagRepository.deleteById(id);
    }
}
