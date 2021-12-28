package apple.blog.commentList.service;

import apple.blog.commentList.model.CommentList;
import apple.blog.commentList.repository.CommentListRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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
        log.info("save Comment List.");
        return commentListRepository.save(commentList);
    }

    @Override
    public List<CommentList> getAllCommentList() {
        log.info("get all Comment List.");
        return commentListRepository.findAll();
    }

    @Override
    public Optional<CommentList> getCommentListById(Long id) {
        log.info("get Comment List {}.", id);
        return Optional.ofNullable(commentListRepository.findById(id)).get();
    }

    @Override
    public void delCommentList(Long id) {
        log.info("delete Comment List {}.", id);
        commentListRepository.deleteById(id);
    }
}
