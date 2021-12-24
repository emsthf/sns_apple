package apple.blog.reply.service;

import apple.blog.reply.model.Reply;
import apple.blog.reply.repository.ReplyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReplyServiceImpl implements ReplyService {
    @Autowired
    private ReplyRepository replyRepository;

    @Override
    public Reply addReply(Reply reply) {
        return replyRepository.save(reply);
    }

    @Override
    public List<Reply> getAllReply() {
        return replyRepository.findAll();
    }

    @Override
    public Optional<Reply> getReply(Long id) {
        return Optional.ofNullable(replyRepository.findById(id)).get();
    }

    @Override
    public void delReply(Long id) {
        replyRepository.deleteById(id);
    }
}
