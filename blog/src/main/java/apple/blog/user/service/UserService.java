package apple.blog.user.service;

import apple.blog.user.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User addUser(User user);
    List<User> getALlUser();
    Optional<User> getUser(Long id);
    void delUser(Long id);
}
