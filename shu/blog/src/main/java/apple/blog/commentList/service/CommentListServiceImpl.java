package apple.blog.commentList.service;

import apple.blog.commentList.model.CommentList;
import apple.blog.commentList.repository.CommentListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentListServiceImpl implements CommentListService {
    @Autowired
    private CommentListRepository commentListRepository;

    @Override
    public CommentList addCommentList(CommentList commentList) {
        return commentListRepository.save(commentList);
    }

    @Override
    public List<CommentList> getAllCommentList() {
        return commentListRepository.findAll();
    }

    @Override
    public Optional<CommentList> getCommentList(Long id) {
        return Optional.ofNullable(commentListRepository.findById(id)).get();
    }

    @Override
    public void delCommentList(Long id) {
        commentListRepository.deleteById(id);
    }
}
