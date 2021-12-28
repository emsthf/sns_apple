package apple.blog.user.service;

import apple.blog.user.model.User;
import apple.blog.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User addUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getALlUser() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> getUser(Long id) {
        return Optional.ofNullable(userRepository.findById(id)).get();
    }

    @Override
    public void delUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public User updateUser(HttpServletRequest request) {
        return null;
    }
}
