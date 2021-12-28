package apple.blog.commentList.model;

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
    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;
    @ManyToOne
    @JoinColumn(name = "comment_id")
    private Comment comment;

    public Comment getComment() {
        return comment;
    }

    public Post getPost() {
        return post;
    }

    @Builder
    public CommentList(Post post, Comment comment) {
        this.post = post;
        this.comment = comment;
    }
}
