package apple.blog.user.service;

import apple.blog.grade.service.GradeService;
import apple.blog.sns.model.Sns;
import apple.blog.sns.repository.SnsRepository;
import apple.blog.user.dto.IUserDto;
import apple.blog.user.model.User;
import apple.blog.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Transactional
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final SnsRepository snsRepository;
    private final GradeService gradeService;

    @Override
    public User addUser(IUserDto iUserDto) {
        log.info("save User.");
        User user = User.builder()
                .id(null)
                .userId(iUserDto.getUserId())
                .password(iUserDto.getPassword())
                .location(iUserDto.getLocation())
                .grade(gradeService.getGrade(iUserDto.getGrade()).get())
                .profileImg(iUserDto.getProfileImg())
                .userName(iUserDto.getUserName())
                .snss(new ArrayList<>())
                .build();
        userRepository.save(user);
        addSnsIdByUserId(user.getId(), iUserDto.getSnsListId());
        return user;
    }

    @Override
    public User editUser(IUserDto iUserDto) {
        log.info("Eidt User. : {}", userRepository.findById(iUserDto.getId()).get());
        User user = User.builder()
                .id(iUserDto.getId())
                .userId(iUserDto.getUserId())
                .password(iUserDto.getPassword())
                .location(iUserDto.getLocation())
                .grade(gradeService.getGrade(iUserDto.getGrade()).get())
                .profileImg(iUserDto.getProfileImg())
                .userName(iUserDto.getUserName())
                .snss(new ArrayList<>())
                .build();
//        user.setCreatDate(userRepository.findById(iUserDto.getId()).get().getCreatDate());
        userRepository.save(user);
        return user;
    }

    @Override
    public void addSnsByUser(String userName, String snsName) {
        log.info("Add SNS {} to User {}.", snsName, userName);
        User user = userRepository.findByUserName(userName);
        Sns sns = snsRepository.findByName(snsName);
        user.getSnss().add(sns);
    }

    @Override
    public List<User> getAllUser() {
        log.info("get all User.");
        return userRepository.findAll();
    }

    @Override
    public Optional<User> getUserById(Long id) {
        log.info("get User by Id {}.", id);
        return Optional.ofNullable(userRepository.findById(id).get());
    }

    @Override
    public void addSnsIdByUserId(Long userId, Long snsId) {
        log.info("Add Sns Id {} to User Id {}.", snsId, userId);
        User user = userRepository.findById(userId).get();   // 받아온 유저 id 파라미터로 해당 유저를 찾음
        Sns sns = snsRepository.findById(snsId).get();       // 받아온 sns id 파라미터로 해당 sns를 찾음
        user.getSnss().add(sns);                             // 찾은 sns를 유저에 넣어줌
    }

    @Override
    public void delUser(Long id) {
        log.info("delete User by Id {}.", id);
        userRepository.deleteById(id);
    }

    @Override
    public User updateUser(HttpServletRequest request) {
        return null;
    }
}
