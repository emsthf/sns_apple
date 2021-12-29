package apple.blog.commentList.service;

import apple.blog.commentList.model.CommentList;
import apple.blog.commentList.repository.CommentListRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Service
public class CommentListServiceImpl implements CommentListService {

    private final CommentListRepository commentListRepository;

    @Override
    public CommentList addCommentList(CommentList commentList) {
        log.info("add CommList.");
        return commentListRepository.save(commentList);
    }

    @Override
    public List<CommentList> getAllCommentList() {
        log.info("get all CommList.");
        return commentListRepository.findAll();
    }

    @Override
    public Optional<CommentList> getCommentListById(Long id) {
        log.info("get CommList by Id {}.", id);
        return Optional.ofNullable(commentListRepository.findById(id)).get();
    }

    @Override
    public void delCommentList(Long id) {
        log.info("delete CommList by Id {}.", id);
        commentListRepository.deleteById(id);
    }
}
