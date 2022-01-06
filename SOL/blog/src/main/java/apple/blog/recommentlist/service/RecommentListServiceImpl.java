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
        return recommentListRepository.save(
                RecommentList.builder()
                        .comment(commentService.getCommentById(recommentListDto.getCommentId()).get())
                        .recomment(recommentService.getRecommentById(recommentListDto.getRecommentId()).get())
                        .build()
        );
    }

    @Override
    public List<RecommentList> getAll() {
        return recommentListRepository.findAll();
    }

    @Override
    public List<RecommentList> getAllByCommentId(Long commentId) {
        return recommentListRepository.findAllByCommentId(commentId);
    }

    @Override
    public void delRecommentList(Long id) {
        recommentListRepository.deleteById(id);
    }
}
