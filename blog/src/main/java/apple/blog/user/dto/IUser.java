package apple.blog.user.dto;

import lombok.Data;
import javax.persistence.Column;

@Data
public class IUser {
    private Long id;
    private String userId;
    private String password;
    @Column(name = "name")
    private String userName;
    private String location;
    private String profileImg;
    private Long snsListId;
    private Long grade;
}
