package apple.blog.snsList.model;

import apple.blog.sns.model.Sns;
import apple.blog.user.model.User;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
public class SnsList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "sns_id")
    private Sns sns;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public User getUser() {
        return user;
    }

    public Sns getSns() {
        return sns;
    }

    @Builder
    public SnsList(Sns sns, User user) {
        this.sns = sns;
        this.user = user;
    }
}
