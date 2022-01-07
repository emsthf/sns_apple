package apple.blog.user.service;

import apple.blog.user.dto.IUserDto;
import apple.blog.user.dto.OUserDto;
import apple.blog.user.model.User;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

public interface UserService {
    User addUser(IUserDto iUserDto);
    User editUser(IUserDto iUserDto);
    List<User> getAllUser();
    OUserDto getUserById(Long id);
    void delUser(Long id);
}
