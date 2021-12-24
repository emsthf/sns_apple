package apple.blog.tagList.repository;

import apple.blog.tagList.model.TagList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagListRepository extends JpaRepository<TagList, Long> {
}
