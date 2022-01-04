package apple.blog.commentlist.service;

import apple.blog.comment.service.CommentService;
import apple.blog.commentlist.dto.CommentListDto;
import apple.blog.commentlist.model.CommentList;
import apple.blog.commentlist.repository.CommentListRepository;
import apple.blog.post.service.PostService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class CommentListServiceImpl implements CommentListService {

    private final CommentListRepository commentListRepository;
    private final PostService postService;
    private final CommentService commentService;

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
    public void delCommList(Long id) {
        log.info("delete Comm List {}.", id);
        commentListRepository.deleteById(id);
    }

    @Override
    public void delCommListAll(Long postId) {   // 해당 포스트에 달린 모든 코멘트 삭제 메소드
        log.info("delete Comm List by Post id {}.", postId);
        List<CommentList> commentLists = commentListRepository.findAllByPostId(postId);   // 포스트 id로 코멘트 리스트를 검색해서
        commentListRepository.deleteAll(commentLists);   // 검색된 코멘트 리스트 모두 삭제
    }
}
