package apple.blog.commentlist.dto;

import lombok.Data;

@Data
public class CommentListDto {
    private Long id;
    private Long postId;
    private Long commentId;
}
