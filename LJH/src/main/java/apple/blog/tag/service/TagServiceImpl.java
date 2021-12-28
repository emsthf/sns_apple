package apple.blog.tag.service;

import apple.blog.tag.model.Tag;
import apple.blog.tag.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TagServiceImpl implements TagService{

    @Autowired
    private TagRepository tagRepository;

    @Override
    public Tag addTag(Tag tag) {
        return tagRepository.save(tag);
    }

    @Override
    public List<Tag> getAllTag() {
        return tagRepository.findAll();
    }

    @Override
    public Optional<Tag> getTag(Long id) {
        return Optional.ofNullable(tagRepository.findById(id).get());
    }

    @Override
    public void delTag(Long id) {
        tagRepository.deleteById(id);
    }
}
