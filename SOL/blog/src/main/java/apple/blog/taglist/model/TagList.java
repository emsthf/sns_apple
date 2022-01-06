package apple.blog.taglist.model;

import apple.blog.post.model.Post;
import apple.blog.tag.model.Tag;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
public class TagList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "tag_id")
    private Tag tag;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

    @Builder
    public TagList(Long id, Tag tag, Post post) {
        this.id = id;
        this.tag = tag;
        this.post = post;
    }
}
