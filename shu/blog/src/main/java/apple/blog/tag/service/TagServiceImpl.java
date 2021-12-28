package apple.blog.tag.service;

import apple.blog.tag.model.Tag;
import apple.blog.tag.repository.TagRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class TagServiceImpl implements TagService{

    private final TagRepository tagRepository;

    @Override
    public Tag addTag(Tag tag) {
        log.info("add tag.");
        return tagRepository.save(tag);
    }

    @Override
    public List<Tag> getAllTag() {
        log.info("");
        return tagRepository.findAll();
    }

    @Override
    public Optional<Tag> getTag(Long id) {
        log.info("");
        return Optional.ofNullable(tagRepository.findById(id).get());
    }

    @Override
    public void delTag(Long id) {
        log.info("");
        tagRepository.deleteById(id);
    }
}
