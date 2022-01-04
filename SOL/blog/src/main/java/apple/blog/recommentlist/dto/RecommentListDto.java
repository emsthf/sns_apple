package apple.blog.recommentlist.dto;

import lombok.Data;

@Data
public class RecommentListDto {
    private Long id;
    private Long recommentId;
    private Long commentId;
    private Long postId;
}
