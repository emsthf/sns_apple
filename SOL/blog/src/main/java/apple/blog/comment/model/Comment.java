package apple.blog.comment.model;

import apple.blog.base.UtilTimeSetter;
import apple.blog.commentlist.model.CommentList;
import apple.blog.post.model.Post;
import apple.blog.recommentlist.model.RecommentList;
import apple.blog.user.model.User;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
public class Comment extends UtilTimeSetter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String text;

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "user_id")
    private User user;
//
//    @OneToMany(mappedBy = "comment", cascade = CascadeType.REMOVE)
//    private List<CommentList> commentLists = new ArrayList<>();

    @Builder
    public Comment(Long id, String text, User user) {
        this.id = id;
        this.text = text;
        this.user = user;

    }
}
