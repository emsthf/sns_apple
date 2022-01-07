package apple.blog.user.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class OUserDto {
    private String userName;
    private String password;
    private String name;
    private String location;
    private String profileImg;
    private LocalDateTime createDate;
    private LocalDateTime modifiedDate;

    @Builder
    public OUserDto(String userName, String password, String name, String location, String profileImg, LocalDateTime createDate, LocalDateTime modifiedDate) {
        this.userName = userName;
        this.password = password;
        this.name = name;
        this.location = location;
        this.profileImg = profileImg;
        this.createDate = createDate;
        this.modifiedDate = modifiedDate;
    }
}
