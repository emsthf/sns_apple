package apple.blog.post.dto;

import lombok.Data;

@Data
public class IPostDto {
    private Long id;
    private String title;
    private Long view;
    private String titleImg;
    private String content;
    private Long userId;

}
