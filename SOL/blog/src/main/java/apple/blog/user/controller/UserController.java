package apple.blog.user.controller;

import apple.blog.grade.service.GradeService;
import apple.blog.user.dto.IUserDto;
import apple.blog.user.model.User;
import apple.blog.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;
    private final GradeService gradeService;

    @PostMapping("/add")
    public User add(@RequestBody IUserDto iUserDto) {
        return userService.addUser(iUserDto);
    }

    @PutMapping("/edit")
    public User edit(@RequestBody IUserDto iUserDto) {
        return userService.editUser(iUserDto);
    }
//    @GetMapping("/getAll")
//    public List<User> getAll() {
//        return userService.getAllUser();
//    }

    @GetMapping("/getAll")
    public ResponseEntity< List<User> > getAll() {
        return ResponseEntity.ok().body( userService.getAllUser() );
    }

    @GetMapping("/get/{id}")
    public Optional<User> get(@PathVariable("id") Long id) {
        return userService.getUserById(id);
    }

    @DeleteMapping("/del/{id}")
    public void del(@PathVariable("id") Long id) {
        userService.delUser(id);
    }
}
