package apple.blog.comment.dto;

import lombok.Data;

@Data
public class ICommentDto {
    private Long id;
    private String comment;
    private Long userId;
    private Long postId;
}
