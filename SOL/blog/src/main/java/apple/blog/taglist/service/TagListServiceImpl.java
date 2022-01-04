package apple.blog.taglist.service;

import apple.blog.post.service.PostService;
import apple.blog.tag.service.TagService;
import apple.blog.taglist.dto.TagListDto;
import apple.blog.taglist.model.TagList;
import apple.blog.taglist.repository.TagListRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class TagListServiceImpl implements TagListService {

    private final TagListRepository tagListRepository;
    private final TagService tagService;
    private final PostService postService;

    @Override
    public TagList addTagList(TagListDto tagListDto) {
        log.info("add TagList.");
        return tagListRepository.save(
                TagList.builder()
                        .id(null)
                        .tag(tagService.getTagById(tagListDto.getTagId()).get())
                        .post(postService.getPostById(tagListDto.getPostId()).get())
                        .build()
        );
    }

    @Override
    public List<TagList> getAll() {
        log.info("get all TagList.");
        return tagListRepository.findAll();
    }

    @Override
    public List<TagList> getAllTagByPostId(Long postId) {
        log.info("포스트 id로 태그 검색 {}.", postId);
        return tagListRepository.findAllByPostId(postId);
    }

    @Override
    public void delTagList(Long id) {
        log.info("태그 id로 지우기. {}", id);
        tagListRepository.deleteById(id);
    }

    @Override
    public void delAllByPostId(Long postId) {
        log.info("포스트 id로 태그 전부 지우기 {}.", postId);
        List<TagList> tagLists = tagListRepository.findAllByPostId(postId);
        tagListRepository.deleteAll(tagLists);
    }
}
