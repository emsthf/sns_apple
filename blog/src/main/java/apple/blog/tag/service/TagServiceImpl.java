package apple.blog.tag.service;

import apple.blog.tag.model.Tag;
import apple.blog.tag.repository.TagRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
        Tag addtag = new Tag();
        try {
            addtag = tagRepository.save(tag);
        } catch (Exception e) {
            log.error("error : {}", e.getMessage());
        }
        return addtag;
    }

    @Override
    public Tag editTag(Tag tag) {
        log.info("edit Tag {}.", tagRepository.findById(tag.getId()).get());
        Tag editTag = new Tag();
        try {
            editTag = Tag.builder()
                    .name(tag.getName())
                    .id(tag.getId())
                    .build();
            tagRepository.save(editTag);
        } catch (Exception exception) {
            log.error("error : {}", exception.getMessage());
        }
        return editTag;
    }

    @Override
    public List<Tag> getAll() {
        log.info("get all Tags.");
        List<Tag> tagList = new ArrayList<>();
        try {
            tagList = tagRepository.findAll();
        } catch (Exception e) {
            log.error("error : {}", e.getMessage());
        }
        return tagList;
    }

    @Override
    public Optional<Tag> getTagById(Long id) {
        log.info("get Tag by Tag id {}.", id);
        Optional<Tag> tag = Optional.empty();
        try {
            tag = Optional.ofNullable(tagRepository.findById(id).get());
        } catch (Exception e) {
            log.error("error : {}", e.getMessage());
        }
        return tag;
    }

    @Override
    public void delTag(Long id) {
        log.info("delete Tag by Tag id {}.", id);
        try {
            tagRepository.deleteById(id);
        } catch (Exception e) {
            log.error("error : {}", e.getMessage());
        }
    }
}
