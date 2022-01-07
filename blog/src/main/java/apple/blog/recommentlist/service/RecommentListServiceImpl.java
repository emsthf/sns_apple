package apple.blog.recommentlist.service;

import apple.blog.comment.service.CommentService;
import apple.blog.post.service.PostService;
import apple.blog.recomment.service.RecommentService;
import apple.blog.recommentlist.dto.RecommentListDto;
import apple.blog.recommentlist.model.RecommentList;
import apple.blog.recommentlist.repository.RecommentListRepository;
import apple.blog.user.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class RecommentListServiceImpl implements RecommentListService {

    private final RecommentListRepository recommentListRepository;
    private final CommentService commentService;
    private final RecommentService recommentService;

    @Override
    public RecommentList addRecommentList(RecommentListDto recommentListDto) {
        log.info("리코멘트 리스트 추가.");
        RecommentList recommentList = new RecommentList();
        try {
            recommentList = recommentListRepository.save(
                    RecommentList.builder()
                            .comment(commentService.getCommentById(recommentListDto.getCommentId()).get())
                            .recomment(recommentService.getRecommentById(recommentListDto.getRecommentId()).get())
                            .build()
            );
        } catch (Exception e) {
            log.error("error : {}", e.getMessage());
        }
        return recommentList;
    }

    @Override
    public List<RecommentList> getAll() {
        log.info("리코멘트 리스트 전부 불러오기.");
        List<RecommentList> recommentLists = new ArrayList<>();
        try {
            recommentLists = recommentListRepository.findAll();
        } catch (Exception e) {
            log.error("error : {}", e.getMessage());
        }
        return recommentLists;
    }

    @Override
    public List<RecommentList> getAllByCommentId(Long commentId) {
        log.info("코멘트 id로 리코멘트 리스트 찾기");
        List<RecommentList> recommentLists = new ArrayList<>();
        try {
            recommentLists = recommentListRepository.findAllByCommentId(commentId);
        } catch (Exception e) {
            log.error("error : {}", e.getMessage());
        }
        return recommentLists;
    }

    @Override
    public void delRecommentList(Long id) {
        log.info("리코멘트 리스트 지우기.");
        try {
            recommentListRepository.deleteById(id);
        } catch (Exception e) {
            log.error("error : {}", e.getMessage());
        }
    }
}
