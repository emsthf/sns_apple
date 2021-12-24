package apple.blog.user.model;

import apple.blog.grade.medel.Grade;
import apple.blog.snsList.model.SnsList;
import lombok.*;

import javax.persistence.*;

@Data
@NoArgsConstructor
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
    @ManyToOne
    @JoinColumn(name = "sns_id")
    private SnsList snsList;
    @ManyToOne
    @JoinColumn(name = "grade_id")
    private Grade grade;

    public Grade getGrade() {
        return grade;
    }

    public SnsList getSnsList() {
        return snsList;
    }

    @Builder
    public User(String userId, String password, String userName, String location, String profileImg, SnsList snsList, Grade grade) {
        this.userId = userId;
        this.password = password;
        this.userName = userName;
        this.location = location;
        this.profileImg = profileImg;
        this.snsList = snsList;
        this.grade = grade;
    }
}
