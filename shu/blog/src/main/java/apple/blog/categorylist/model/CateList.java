package apple.blog.categorylist.model;

import apple.blog.category.model.Category;
import apple.blog.post.model.Post;

import javax.persistence.*;
import java.math.BigInteger;

@Entity
public class CateList {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

    public Post getPost() {
        return post;
    }

    public Category getCategory() {
        return category;
    }
}
