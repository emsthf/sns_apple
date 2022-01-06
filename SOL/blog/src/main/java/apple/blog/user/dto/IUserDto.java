package apple.blog.user.dto;

import lombok.Data;
import javax.persistence.Column;

@Data
public class IUserDto {
    private Long id;
    private String userName;
    private String password;
    private String name;
    private String location;
    private String profileImg;
    private Long grade;
}
