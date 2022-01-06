package apple.blog.commentlist.service;

import apple.blog.comment.service.CommentService;
import apple.blog.commentlist.dto.CommentListDto;
import apple.blog.commentlist.model.CommentList;
import apple.blog.commentlist.repository.CommentListRepository;
import apple.blog.post.service.PostService;
import apple.blog.recomment.repository.RecommentRepository;
import apple.blog.recommentlist.model.RecommentList;
import apple.blog.recommentlist.repository.RecommentListRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class CommentListServiceImpl implements CommentListService {

    private final CommentListRepository commentListRepository;
    private final PostService postService;
    private final CommentService commentService;
    private final RecommentRepository recommentRepository;
    private final RecommentListRepository recommentListRepository;

    @Override
    public CommentList addCommList(CommentListDto commentListDto) {
        log.info("add Comm List.");
        CommentList commentList = CommentList.builder()
                .id(null)
                .post(postService.getPostById(commentListDto.getPostId()).get())
                .comment(commentService.getCommentById(commentListDto.getCommentId()).get())
                .build();
        commentListRepository.save(commentList);
        return commentList;
    }

    @Override
    public List<CommentList> getAll() {
        log.info("get all Comm List.");
        return commentListRepository.findAll();
    }

    @Override
    public List<CommentList> getAllByPostId(Long postId) {
        log.info("get all Comm List by Post id {}.", postId);
        return commentListRepository.findAllByPostId(postId);
    }

    @Override
    @Transactional(rollbackFor = {RuntimeException.class})
    public void delCommList(Long id) {
        log.info("delete Comm List {}.", id);
        // 코멘트 리스트의 id로 해당 코멘트 리스트의 코멘트를 받는다
        Long commentId = commentListRepository.findById(id).get().getComment().getId();
        // 코멘트 id로 찾은 코멘트에 달린 리코멘트 전부 찾기
        List<RecommentList> recommentLists = recommentListRepository.findAllByCommentId(commentId);
        log.info("recommentList {}", recommentLists);
        // 리코멘트에서 코멘트 id로 해당 코멘트에 달린 모든 리코멘트를 찾아서 지운다
        recommentListRepository.deleteAll(recommentLists);
        // 코멘트에 달린 리코멘트가 지워진 후, 코멘트 리스트를 지워서 코멘트도 함께 지운다
        commentListRepository.deleteById(id);
    }
}
