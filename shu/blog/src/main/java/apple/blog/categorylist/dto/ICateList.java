package apple.blog.categorylist.dto;

import apple.blog.category.model.Category;
import apple.blog.post.model.Post;
import lombok.Data;

import java.io.PipedOutputStream;

@Data
public class ICateList {
    private Long id;
    private Long categoryId;
    private Long postId;
}
