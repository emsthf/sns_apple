package apple.blog.comment.model;

import apple.blog.base.UtilTimeSetter;
import apple.blog.user.model.User;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
public class Comment extends UtilTimeSetter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String comment;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public User getUser() {
        return user;
    }

    @Builder
    public Comment(String comment, User user) {
        this.comment = comment;
        this.user = user;
    }
}
