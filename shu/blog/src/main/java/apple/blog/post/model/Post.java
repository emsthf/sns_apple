package apple.blog.post.model;

import apple.blog.base.UtilTimeSetter;
import apple.blog.user.model.User;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
public class Post extends UtilTimeSetter {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private int view;
    private String titleImg;
    private String content;
    private Long authorId;

    @Builder
    public Post(String title, int view, String titleImg, String content, Long authorId) {
        this.title = title;
        this.view = view;
        this.titleImg = titleImg;
        this.content = content;
        this.authorId = authorId;
    }
}
