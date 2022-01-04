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

    @ManyToOne
    @JoinColumn(name = "recomment_id")
    private Recomment recomment;

    @ManyToOne
    @JoinColumn(name = "comment_id")
    private Comment comment;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

    @Builder
    public RecommentList(Recomment recomment, Comment comment, Post post) {
        this.recomment = recomment;
        this.comment = comment;
        this.post = post;
    }
}
