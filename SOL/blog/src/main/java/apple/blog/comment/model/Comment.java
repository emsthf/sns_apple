package apple.blog.comment.model;

import apple.blog.base.UtilTimeSetter;
import apple.blog.post.model.Post;
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
    private String text;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Builder
    public Comment(Long id, String text, User user) {
        this.id = id;
        this.text = text;
        this.user = user;
    }
}
