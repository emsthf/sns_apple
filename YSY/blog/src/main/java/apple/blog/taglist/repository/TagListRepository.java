package apple.blog.taglist.repository;

import apple.blog.taglist.model.TagList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagListRepository extends JpaRepository<TagList, Long> {
}
