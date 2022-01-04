package apple.blog.recomment.dto;

import lombok.Data;

@Data
public class RecommentDto {
    private Long id;
    private String text;
    private Long userId;
}
