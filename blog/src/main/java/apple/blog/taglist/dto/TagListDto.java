package apple.blog.taglist.dto;

import lombok.Data;

@Data
public class TagListDto {
    private Long id;
    private Long tagId;
    private Long postId;
}
