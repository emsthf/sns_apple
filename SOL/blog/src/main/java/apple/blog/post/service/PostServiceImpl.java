package apple.blog.post.service;

import apple.blog.categorylist.model.CategoryList;
import apple.blog.categorylist.repository.CategoryListRepository;
import apple.blog.commentlist.model.CommentList;
import apple.blog.commentlist.repository.CommentListRepository;
import apple.blog.post.dto.IPostDto;
import apple.blog.post.model.Post;
import apple.blog.post.repository.PostRepository;
import apple.blog.recommentlist.model.RecommentList;
import apple.blog.recommentlist.repository.RecommentListRepository;
import apple.blog.taglist.model.TagList;
import apple.blog.taglist.repository.TagListRepository;
import apple.blog.user.repository.UserRepository;
import apple.blog.user.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Service
public class PostServiceImpl implements PostService{

    private final PostRepository postRepository;
    private final UserRepository userRepository;
//    private final UserService userService;
    private final CommentListRepository commentListRepository;
    private final RecommentListRepository recommentListRepository;
    private final TagListRepository tagListRepository;
    private final CategoryListRepository categoryListRepository;

    @Override
    public Post addPost(IPostDto iPostDto) {
        log.info("add Post.");
        return postRepository.save(Post.builder()
                .id(null)
                .content(iPostDto.getContent())
                .title(iPostDto.getTitle())
                .titleImg(iPostDto.getTitleImg())
                .user(userRepository.findById(iPostDto.getUserId()).get())
//                .user(userService.getUserById(iPostDto.getUserId()).get())
                .view(0L)
                .build()
        );
    }

    @Override
    public Post editPost(IPostDto iPostDto) {
        log.info("edit Post. {}", postRepository.findById(iPostDto.getId()).get());
        Post post = Post.builder()
                .id(iPostDto.getId())
                .content(iPostDto.getContent())
                .title(iPostDto.getTitle())
                .titleImg(iPostDto.getTitleImg())
                .user(userRepository.findById(iPostDto.getUserId()).get())
//                .user(userService.getUserById(iPostDto.getUserId()).get())
                .view(iPostDto.getView())
                .build();
        postRepository.save(post);
        return post;
    }

    @Override
    public List<Post> getAllPost() {
        log.info("get all Posts.");
        return postRepository.findAll();
    }

    @Override
    public List<Post> getAllOrderByCreatedDesc() {
        return postRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
    }

    @Override
    public Optional<Post> getPostById(Long id) {
        log.info("get Post by Id {}.", id);
        return Optional.ofNullable(postRepository.findById(id)).get();
    }

    @Override
    public List<Post> getPostByAuthId(Long id) {
        return postRepository.findAllByUserId(id);
    }

    @Override
    public void delPost(Long id) {
        log.info("delete Post by Id {} with comments.", id);
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
            log.error("포스트 지우기 실패!!!!!!!! {}", exception);
        }
        postRepository.deleteById(id);
    }
}
