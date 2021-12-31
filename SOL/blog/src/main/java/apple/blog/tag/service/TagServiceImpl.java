package apple.blog.tag.service;

import apple.blog.post.service.PostService;
import apple.blog.tag.dto.TagDto;
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
    private final PostService postService;

    @Override
    public Tag addTag(TagDto tagDto) {
        log.info("add Tag.");
        return tagRepository.save(
                Tag.builder()
                    .name(tagDto.getName())
                    .post(postService.getPostById(tagDto.getPostId()).get())
                    .build()
        );
    }

    @Override
    public List<Tag> getAllTag() {
        log.info("get all Tags.");
        return tagRepository.findAll();
    }

    @Override
    public List<Tag> getAllTagByPostId(Long postId) {
        log.info("get Tags by Post Id {}.", postId);
        return tagRepository.findAllByPostId(postId);
    }

    @Override
    public Optional<Tag> getTagById(Long id) {
        log.info("get Tag by Id {}.", id);
        return Optional.ofNullable(tagRepository.findById(id).get());
    }

    @Override
    public void delTag(Long id) {
        log.info("delete Tag by Id {}.", id);
        tagRepository.deleteById(id);
    }
}
