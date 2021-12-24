package apple.blog.user.controller;

import apple.blog.user.model.User;
import apple.blog.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public User add(@RequestBody User user) {
        return userService.addUser(user);
    }

    @GetMapping("/getAll")
    public List<User> getAll() {
        return userService.getALlUser();
    }

    @GetMapping("/get/{id}")
    public Optional<User> get(@PathVariable("id") Long id) {
        return userService.getUser(id);
    }

    @DeleteMapping("/del/{id}")
    public void del(@PathVariable("id") Long id) {
        userService.delUser(id);
    }
}
