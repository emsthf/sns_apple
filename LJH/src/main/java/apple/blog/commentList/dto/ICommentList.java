package apple.blog.commentList.dto;

import lombok.Data;

@Data
public class ICommentList {
    private Long id;
    private Long postId;
    private Long commentId;
}
