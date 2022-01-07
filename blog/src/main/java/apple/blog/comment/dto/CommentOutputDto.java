package apple.blog.comment.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CommentOutputDto {
    private Long id;
    private LocalDateTime createDate;
    private LocalDateTime modifiedDate;
    private String text;
    private Long user;

    @Builder
    public CommentOutputDto(Long id, LocalDateTime createDate, LocalDateTime modifiedDate, String text, Long user) {
        this.id = id;
        this.createDate = createDate;
        this.modifiedDate = modifiedDate;
        this.text = text;
        this.user = user;
    }
}
