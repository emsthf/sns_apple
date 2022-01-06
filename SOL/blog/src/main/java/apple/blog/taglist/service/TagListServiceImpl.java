package apple.blog.taglist.service;

import apple.blog.post.repository.PostRepository;
import apple.blog.tag.service.TagService;
import apple.blog.taglist.dto.TagListDto;
import apple.blog.taglist.model.TagList;
import apple.blog.taglist.repository.TagListRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class TagListServiceImpl implements TagListService {

    private final TagListRepository tagListRepository;
    private final TagService tagService;
    private final PostRepository postRepository;

    @Override
    public TagList addTagList(TagListDto tagListDto) {
        log.info("add TagList.");
        TagList tagList = new TagList();
        try {
            tagList = tagListRepository.save(
                    TagList.builder()
                            .id(null)
                            .tag(tagService.getTagById(tagListDto.getTagId()).get())
                            .post(postRepository.findById(tagListDto.getPostId()).get())
                            .build()
            );
        } catch (Exception e) {
            log.error("error : {}", e.getMessage());
        }
        return tagList;
    }

    @Override
    public List<TagList> getAll() {
        log.info("get all TagList.");
        List<TagList> tagLists = new ArrayList<>();
        try {
            tagLists = tagListRepository.findAll();
        } catch (Exception e) {
            log.error("error : {}", e.getMessage());
        }
        return tagLists;
    }

    @Override
    public List<TagList> getAllTagByPostId(Long postId) {
        log.info("포스트 id로 태그 검색 {}.", postId);
        List<TagList> tagLists = new ArrayList<>();
        try {
            tagLists = tagListRepository.findAllByPostId(postId);
        } catch (Exception e) {
            log.error("error : {}", e.getMessage());
        }
        return tagLists;
    }

    @Override
    public void delTagList(Long id) {
        log.info("태그 id로 지우기. {}", id);
        try {
            tagListRepository.deleteById(id);
        } catch (Exception e) {
            log.error("error : {}", e.getMessage());
        }
    }

    @Override
    public void delAllByPostId(Long postId) {
        log.info("포스트 id로 태그 전부 지우기 {}.", postId);
        try {
            List<TagList> tagLists = tagListRepository.findAllByPostId(postId);
            tagListRepository.deleteAll(tagLists);
        } catch (Exception e) {
            log.error("error : {}", e.getMessage());
        }
    }
}
