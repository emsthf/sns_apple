package apple.blog.smallCategory.model;

import apple.blog.largeCategory.model.LargeCategory;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
public class Category {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToOne
    @JoinColumn(name = "large_category_id")
    private LargeCategory largeCategory;

    @Builder
    public Category(String name, LargeCategory largeCategory) {
        this.name = name;
        this.largeCategory = largeCategory;
    }
}
