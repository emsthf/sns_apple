package apple.blog.commentlist.service;

import apple.blog.commentlist.dto.CommentListDto;
import apple.blog.commentlist.model.CommentList;

import java.util.List;

public interface CommentListService {
    CommentList addCommList(CommentListDto commentListDto);
    List<CommentList> getAll();
    List<CommentList> getAllByPostId(Long postId);
    void delCommList(Long id);
    void delCommListAll(Long postId);
}
