package apple.blog.commentlist.service;

import apple.blog.comment.service.CommentService;
import apple.blog.commentlist.dto.CommentListDto;
import apple.blog.commentlist.model.CommentList;
import apple.blog.commentlist.repository.CommentListRepository;
import apple.blog.post.repository.PostRepository;
import apple.blog.recommentlist.model.RecommentList;
import apple.blog.recommentlist.repository.RecommentListRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class CommentListServiceImpl implements CommentListService {

    private final CommentListRepository commentListRepository;
    private final CommentService commentService;
    private final RecommentListRepository recommentListRepository;
    private final PostRepository postRepository;

    @Override
    public CommentList addCommList(CommentListDto commentListDto) {
        log.info("add Comm List.");
        CommentList commentList = new CommentList();
        try {
            commentList = CommentList.builder()
                    .id(null)
                    .post(postRepository.findById(commentListDto.getPostId()).get())
                    .comment(commentService.getCommentById(commentListDto.getCommentId()).get())
                    .build();
            commentListRepository.save(commentList);
        } catch (Exception e) {
            log.error("error : {}", e.getMessage());
        }
        return commentList;
    }

    @Override
    public List<CommentList> getAll() {
        log.info("get all Comm List.");
        List<CommentList> commentLists = new ArrayList<>();
        try {
            commentLists = commentListRepository.findAll();
        } catch (Exception e) {
            log.error("error : {}", e.getMessage());
        }
        return commentLists;
    }

    @Override
    public List<CommentList> getAllByPostId(Long postId) {
        log.info("get all Comm List by Post id {}.", postId);
        List<CommentList> commentLists = new ArrayList<>();
        try {
            commentLists = commentListRepository.findAllByPostId(postId);
        } catch (Exception e) {
            log.error("error : {}", e.getMessage());
        }
        return commentLists;
    }

    @Override
    @Transactional(rollbackFor = {RuntimeException.class})
    public void delCommList(Long id) {
        log.info("delete Comm List {}.", id);
        try {
            // ????????? ???????????? id??? ?????? ????????? ???????????? ???????????? ?????????
            Long commentId = commentListRepository.findById(id).get().getComment().getId();
            // ????????? id??? ?????? ???????????? ?????? ???????????? ?????? ??????
            List<RecommentList> recommentLists = recommentListRepository.findAllByCommentId(commentId);
            log.info("recommentList {}", recommentLists);
            // ?????????????????? ????????? id??? ?????? ???????????? ?????? ?????? ??????????????? ????????? ?????????
            recommentListRepository.deleteAll(recommentLists);
            // ???????????? ?????? ??????????????? ????????? ???, ????????? ???????????? ????????? ???????????? ?????? ?????????
            commentListRepository.deleteById(id);
        } catch (Exception e) {
            log.error("error : {}", e.getMessage());
        }
    }
}
