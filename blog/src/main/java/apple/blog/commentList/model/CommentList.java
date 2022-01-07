package apple.blog.commentlist.model;

import apple.blog.comment.model.Comment;
import apple.blog.post.model.Post;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
public class CommentList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "post_id")
    private Post post;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "comment_id")
    private Comment comment;

    @Builder
    public CommentList(Long id, Post post, Comment comment) {
        this.id = id;
        this.post = post;
        this.comment = comment;
    }
}
