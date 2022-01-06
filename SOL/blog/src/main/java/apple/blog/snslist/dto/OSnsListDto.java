package apple.blog.snslist.dto;

import lombok.Builder;
import lombok.Data;

@Data
public class OSnsListDto {


    private Long snsId;
    private String snsUrl;

    @Builder
    public OSnsListDto(Long snsId, String snsUrl) {
        this.snsId = snsId;
        this.snsUrl = snsUrl;
    }
}
