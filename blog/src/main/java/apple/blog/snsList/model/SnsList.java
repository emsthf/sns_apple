package apple.blog.snslist.model;

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
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne
    @JoinColumn(name = "sns_id")
    private Sns sns;
    private String snsUrl;

    @Builder
    public SnsList(Long id, User user, Sns sns, String snsUrl) {
        this.id = id;
        this.user = user;
        this.sns = sns;
        this.snsUrl = snsUrl;
    }
}
