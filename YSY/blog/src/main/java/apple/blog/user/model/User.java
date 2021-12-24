package apple.blog.user.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Data
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userId;
    private String password;
    @Column(name = "name")
    private String userName;
    private String location;
    private String profileImg;
    private String snsList;
    private String grade;
}
