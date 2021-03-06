package apple.blog.user.controller;

import apple.blog.user.dto.IUserDto;
import apple.blog.user.dto.OUserDto;
import apple.blog.user.model.User;
import apple.blog.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @PostMapping("/add")
    public String add(@RequestBody IUserDto iUserDto) {
        if (userService.addUser(iUserDto) == 1) {
            return "success";
        } else {
            return "fail";
        }
    }

    @PutMapping("/edit")
    public void edit(@RequestBody IUserDto iUserDto) {
        userService.editUser(iUserDto);
    }

    @GetMapping("/getAll")
    public ResponseEntity< List<User> > getAll() {
        return ResponseEntity.ok().body( userService.getAllUser() );
    }

    @GetMapping("/get/{id}")
    public OUserDto get(@PathVariable("id") Long id) {
        return userService.getUserById(id);
    }

    @DeleteMapping("/del/{id}")
    public void del(@PathVariable("id") Long id) {
        userService.delUser(id);
    }
}
