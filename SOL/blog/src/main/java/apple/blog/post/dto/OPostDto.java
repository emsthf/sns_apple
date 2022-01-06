package apple.blog.post.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class OPostDto {

    private String title;
    private Long view;
    private String titleImg;
    private String content;
    private Long userId;
    private LocalDateTime createDate;
    private LocalDateTime modifiedDate;

    @Builder
    public OPostDto(String title, Long view, String titleImg, String content, Long userId, LocalDateTime createDate, LocalDateTime modifiedDate) {
        this.title = title;
        this.view = view;
        this.titleImg = titleImg;
        this.content = content;
        this.userId = userId;
        this.createDate = createDate;
        this.modifiedDate = modifiedDate;
    }
}
