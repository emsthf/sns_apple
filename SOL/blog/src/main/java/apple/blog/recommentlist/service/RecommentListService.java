package apple.blog.recommentlist.service;

import apple.blog.recommentlist.dto.RecommentListDto;
import apple.blog.recommentlist.model.RecommentList;

import java.util.List;

public interface RecommentListService {
    RecommentList addRecommentList(RecommentListDto recommentListDto);
    List<RecommentList> getAll();
    List<RecommentList> getAllByCommentId(Long commentId);
}
