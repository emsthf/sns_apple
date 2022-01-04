package apple.blog.tag.model;

import apple.blog.post.model.Post;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
public class Tag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

    @Builder
    public Tag(String name, Post post) {
        this.name = name;
        this.post = post;
    }
}
