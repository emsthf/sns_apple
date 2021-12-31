package apple.blog.categorylist.model;

import apple.blog.largeCategory.model.LargeCategory;
import apple.blog.post.model.Post;
import apple.blog.smallCategory.model.Category;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
public class CategoryList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "large_category_id")
    private LargeCategory largeCategory;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

    @Builder
    public CategoryList(Long id, LargeCategory largeCategory, Category category, Post post) {
        this.id = id;
        this.largeCategory = largeCategory;
        this.category = category;
        this.post = post;
    }
}
