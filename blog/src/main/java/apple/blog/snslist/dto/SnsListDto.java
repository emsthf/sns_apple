package apple.blog.snslist.dto;

import lombok.Data;

@Data
public class SnsListDto {
    private Long id;
    private Long userId;
    private Long snsId;
    private String snsUrl;
}
