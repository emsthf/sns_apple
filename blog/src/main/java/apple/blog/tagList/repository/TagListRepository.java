package apple.blog.taglist.repository;

import apple.blog.taglist.model.TagList;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TagListRepository extends JpaRepository<TagList, Long> {
    List<TagList> findAllByPostId(Long postId);
}
