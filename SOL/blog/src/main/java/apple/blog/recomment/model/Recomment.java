package apple.blog.recomment.model;

import apple.blog.base.UtilTimeSetter;
import apple.blog.comment.model.Comment;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
public class Recomment extends UtilTimeSetter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "comment_id")
    private Comment comment;

    public Comment getComment() {
        return comment;
    }

    @Builder
    public Recomment(Comment comment) {
        this.comment = comment;
    }
}
