package apple.blog.post.dto;

import lombok.Data;

@Data
public class IPostDto {

    private String title;
    private String titleImg;
    private String content;
    private Long userId;

}
