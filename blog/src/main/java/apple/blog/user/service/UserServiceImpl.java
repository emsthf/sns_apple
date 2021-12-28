package apple.blog.user.service;

import apple.blog.user.model.User;
import apple.blog.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public User addUser(User user) {
        log.info("save User.");
        return userRepository.save(user);
    }

    @Override
    public List<User> getALlUser() {
        log.info("get all User.");
        return userRepository.findAll();
    }

    @Override
    public Optional<User> getUserById(Long id) {
        log.info("get User by id {}.", id);
        return Optional.ofNullable(userRepository.findById(id).get());
    }

    @Override
    public void delUser(Long id) {
        log.info("delete User {}.", id);
        userRepository.deleteById(id);
    }

    @Override
    public User updateUser(HttpServletRequest request) {
        return null;
    }
}
