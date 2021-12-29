package apple.blog.user.service;

import apple.blog.user.model.User;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

public interface UserService {
    User addUser(User user);
    List<User> getAllUser();
    Optional<User> getUserById(Long id);
    void delUser(Long id);
    User updateUser(HttpServletRequest request);   // 수정 추상 메소드
}
