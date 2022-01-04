package apple.blog.comment.dto;

import lombok.Data;

@Data
public class ICommentDto {
    private Long id;
    private String text;
    private Long userId;
}
