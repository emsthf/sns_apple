package apple.blog.tagList.repository;

import apple.blog.tag.model.Tag;
import apple.blog.tagList.model.TagList;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TagListRepository extends JpaRepository<TagList, Long> {
}
