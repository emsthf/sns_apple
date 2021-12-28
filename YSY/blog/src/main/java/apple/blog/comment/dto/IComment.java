package apple.blog.comment.dto;

import lombok.Data;

@Data
public class IComment {
    private Long id;
    private String comment;
    private Long userId;
}
