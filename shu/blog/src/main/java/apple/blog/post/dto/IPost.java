package apple.blog.post.dto;

import lombok.Data;

@Data
public class IPost {

    private Long id;
    private String title;
    private int view;
    private String titleImg;
    private String content;
    private Long authorId;
}
