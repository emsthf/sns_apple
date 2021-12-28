package apple.blog.post.model;

import apple.blog.base.UtilTimeSetter;
import apple.blog.user.model.User;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Post extends UtilTimeSetter {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private int view;
    private String titleImg;
    private String content;
    private Long authorId;
}
