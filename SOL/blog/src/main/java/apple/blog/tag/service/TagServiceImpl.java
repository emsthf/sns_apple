package apple.blog.tag.service;

import apple.blog.tag.model.Tag;
import apple.blog.tag.repository.TagRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class TagServiceImpl implements TagService {

    private final TagRepository tagRepository;

    @Override
    public Tag addTag(Tag tag) {
        log.info("add Tag.");
        return tagRepository.save(tag);
    }

    @Override
    public Tag editTag(Tag tag) {
        log.info("edit Tag {}.", tagRepository.findById(tag.getId()).get());
        Tag editTag = Tag.builder()
                .name(tag.getName())
                .id(tag.getId())
                .build();
        tagRepository.save(editTag);
        return editTag;
    }

    @Override
    public List<Tag> getAll() {
        log.info("get all Tags.");
        return tagRepository.findAll();
    }

    @Override
    public Optional<Tag> getTagById(Long id) {
        log.info("get Tag by Tag id {}.", id);
        return Optional.ofNullable(tagRepository.findById(id).get());
    }

    @Override
    public void delTag(Long id) {
        log.info("delete Tag by Tag id {}.", id);
        tagRepository.deleteById(id);
    }
}
