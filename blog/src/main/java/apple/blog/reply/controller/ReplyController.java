package apple.blog.reply.controller;

import apple.blog.comment.service.CommentService;
import apple.blog.reply.dto.IReply;
import apple.blog.reply.model.Reply;
import apple.blog.reply.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reply")
public class ReplyController {
    @Autowired
    private ReplyService replyService;

    @Autowired
    private CommentService commentService;

    @PostMapping("/add")
    public Reply add(@RequestBody IReply iReply) {
        return replyService.addReply(
                new Reply(
                        commentService.getComment(iReply.getCommentId()).get()
                )
        );
    }

    @GetMapping("/getAll")
    public List<Reply> get() {
        return replyService.getAllReply();
    }

    @GetMapping("/get/{id}")
    public Reply get(@PathVariable("id") Long id) {
        return replyService.getReply(id).get();
    }

    @DeleteMapping("del/{id}")
    public void del(@PathVariable("id") Long id) {
        replyService.delReply(id);
    }
}
