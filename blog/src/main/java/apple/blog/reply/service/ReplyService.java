package apple.blog.reply.service;

import apple.blog.reply.model.Reply;

import java.util.List;
import java.util.Optional;

public interface ReplyService {
    Reply addReply(Reply reply);
    List<Reply> getAllReply();
    Optional<Reply> getReply(Long id);
    void delReply(Long id);
}
