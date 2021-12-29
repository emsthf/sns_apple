package apple.blog.user.model;

import apple.blog.base.UtilTimeSetter;
import apple.blog.grade.medel.Grade;
import apple.blog.sns.model.Sns;
import lombok.*;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.Collection;

import static javax.persistence.FetchType.EAGER;

@Data
@NoArgsConstructor
@Entity
public class User extends UtilTimeSetter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userId;
    private String password;
    @Column(name = "name")
    private String userName;
    private String location;
    private String profileImg;
    @ManyToOne
    @JoinColumn(name = "grade_id")
    private Grade grade;
//    @ManyToMany(fetch = EAGER)
//    private Collection<Sns> sns = new ArrayList<>();

    @Builder
    public User(String userId, String password, String userName, String location, String profileImg, Grade grade) {
        this.userId = userId;
        this.password = password;
        this.userName = userName;
        this.location = location;
        this.profileImg = profileImg;
        this.grade = grade;
    }

//    @Builder
//    public User(Long id, String userId, String password, String userName, String location, String profileImg, Grade grade, Collection<Sns> sns) {
//        this.id = id;
//        this.userId = userId;
//        this.password = password;
//        this.userName = userName;
//        this.location = location;
//        this.profileImg = profileImg;
//        this.grade = grade;
//        this.sns = sns;
//    }
}
