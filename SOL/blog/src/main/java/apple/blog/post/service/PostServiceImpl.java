package apple.blog.post.service;

import apple.blog.categorylist.model.CategoryList;
import apple.blog.categorylist.repository.CategoryListRepository;
import apple.blog.commentlist.model.CommentList;
import apple.blog.commentlist.repository.CommentListRepository;
import apple.blog.post.dto.IPostDto;
import apple.blog.post.dto.OPostDto;
import apple.blog.post.model.Post;
import apple.blog.post.repository.PostRepository;
import apple.blog.recommentlist.model.RecommentList;
import apple.blog.recommentlist.repository.RecommentListRepository;
import apple.blog.taglist.model.TagList;
import apple.blog.taglist.repository.TagListRepository;
import apple.blog.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class PostServiceImpl implements PostService{

    private final PostRepository postRepository;
    private final UserRepository userRepository;
    private final CommentListRepository commentListRepository;
    private final RecommentListRepository recommentListRepository;
    private final TagListRepository tagListRepository;
    private final CategoryListRepository categoryListRepository;

    @Override
    public int addPost(IPostDto iPostDto) {
        log.info("add Post.");
        Post post = new Post();
        try {
            post = postRepository.save(Post.builder()
                    .id(null)
                    .content(iPostDto.getContent())
                    .title(iPostDto.getTitle())
                    .titleImg(iPostDto.getTitleImg())
                    .user(userRepository.findById(iPostDto.getUserId()).get())
                    .view(0L)
                    .build()
            );
            return 1;
        } catch (Exception e) {
            log.error("error : {}", e.getMessage());
            return 0;
        }
    }

    @Override
    public int editPost(IPostDto iPostDto) {
        log.info("edit Post. {}", postRepository.findById(iPostDto.getId()).get());
        Post post = new Post();
        try {
            post = Post.builder()
                    .id(iPostDto.getId())
                    .content(iPostDto.getContent())
                    .title(iPostDto.getTitle())
                    .titleImg(iPostDto.getTitleImg())
                    .user(userRepository.findById(iPostDto.getUserId()).get())
                    .view(iPostDto.getView())
                    .build();
            postRepository.save(post);
            return 1;
        } catch (Exception e) {
            log.error("error : {}", e.getMessage());
            return 0;
        }
    }

    @Override
    public List<Post> getAllPost() {
        log.info("get all Posts.");
        List<Post> posts = new ArrayList<>();
        try {
            posts = postRepository.findAll();
        } catch (Exception e) {
            log.error("error : {}", e.getMessage());
        }
        return posts;
    }

    @Override
    public List<Post> getAllOrderByCreatedDesc() {
        log.info("포스트 날짜로 내림차순 정렬");
        List<Post> posts = new ArrayList<>();
        try {
            posts = postRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
        } catch (Exception e) {
            log.error("error : {}", e.getMessage());
        }
        return posts;
    }

    @Override
    public OPostDto getPostById(Long id) {
        log.info("get Post by Id {}.", id);
        OPostDto oPostDto = new OPostDto();
        try {
            Post post = postRepository.findById(id).get();
            oPostDto = OPostDto.builder()
                    .content(post.getContent())
                    .createDate(post.getCreateDate())
                    .modifiedDate(post.getModifiedDate())
                    .title(post.getTitle())
                    .titleImg(post.getTitleImg())
                    .userId(post.getId())
                    .view(post.getView())
                    .build();
        } catch (Exception e) {
            log.error("error : {}", e.getMessage());
        }
        return oPostDto;
    }

    @Override
    public List<Post> getPostByAuthId(Long id) {
        log.info("작성자로 포스트 검색.");
        List<Post> posts = new ArrayList<>();
        try {
            posts = postRepository.findAllByUserId(id);
        } catch (Exception e) {
            log.error("error : {}", e.getMessage());
        }
        return posts;
    }

    @Override
    public void delPost(Long id) {
        log.info("delete Post by Id {} with comments.", id);
        try {
            try {
                // 포스트에 달린 댓글 지우기
                List<CommentList> commentLists = commentListRepository.findAllByPostId(id);
                log.info("commentList DELETE {}", commentLists);
                // 포스트에 달린 댓글을 지우기 전에 댓글에 달린 모든 대댓글 삭제
                commentLists.stream().forEach(
                        commentList -> {
                            List<RecommentList> recommentLists = recommentListRepository.findAllByCommentId(commentList.getComment().getId());
                            log.info("recommentList {}", recommentLists);
                            recommentListRepository.deleteAll(recommentLists);
                        }
                );
                log.info("commentList Delete {}", commentLists);
                commentListRepository.deleteAll(commentLists);

                // 포스트에 달린 태그 지우기
                List<TagList> tagLists = tagListRepository.findAllByPostId(id);
                tagListRepository.deleteAll(tagLists);

                // 카테고리 리스트 지우기
                List<CategoryList> categoryLists = categoryListRepository.findAllByPostId(id);
                categoryListRepository.deleteAll(categoryLists);

            } catch (Exception exception) {
                log.error("포스트 지우기 실패!!!!!!!! {}", exception.getMessage());
            }
            postRepository.deleteById(id);
        } catch (Exception e) {
            log.error("error : {}", e.getMessage());
        }
    }
}
