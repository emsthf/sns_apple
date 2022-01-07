package apple.blog.user.model;

import apple.blog.base.UtilTimeSetter;
import apple.blog.grade.medel.Grade;
import apple.blog.sns.model.Sns;
import lombok.*;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import static javax.persistence.FetchType.EAGER;

@Data
@NoArgsConstructor
@Entity
public class User extends UtilTimeSetter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userName;
    private String password;
    private String name;
    private String location;
    private String profileImg;

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "grade_id")
    private Grade grade;

    @Builder
    public User(Long id, String userName, String password, String name, String location, String profileImg, Grade grade) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.name = name;
        this.location = location;
        this.profileImg = profileImg;
        this.grade = grade;
    }
}
