package apple.blog.categoryList.model;

import apple.blog.category.model.Category;
import apple.blog.post.model.Post;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
public class CateList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @Builder

    public CateList(Category category, Post post) {
        this.category = category;
        this.post = post;
    }
}
