package apple.blog.recommentlist.model;

import apple.blog.comment.model.Comment;
import apple.blog.post.model.Post;
import apple.blog.recomment.model.Recomment;
import apple.blog.user.model.User;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
public class RecommentList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "recomment_id")
    private Recomment recomment;

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "comment_id")
    private Comment comment;


    @Builder
    public RecommentList(Long id, Recomment recomment, Comment comment) {
        this.id = id;
        this.recomment = recomment;
        this.comment = comment;
    }
}
