package apple.blog.user.service;

import apple.blog.comment.model.Comment;
import apple.blog.comment.repository.CommentRepository;
import apple.blog.grade.service.GradeService;
import apple.blog.post.model.Post;
import apple.blog.post.repository.PostRepository;
import apple.blog.recomment.model.Recomment;
import apple.blog.recomment.repository.RecommentRepository;
import apple.blog.sns.model.Sns;
import apple.blog.sns.repository.SnsRepository;
import apple.blog.snslist.model.SnsList;
import apple.blog.snslist.repository.SnsListRepository;
import apple.blog.user.dto.IUserDto;
import apple.blog.user.dto.OUserDto;
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
    private final GradeService gradeService;
    private final SnsListRepository snsListRepository;
    private final CommentRepository commentRepository;
    private final RecommentRepository recommentRepository;
    private final PostRepository postRepository;

    @Override
    public User addUser(IUserDto iUserDto) {
        log.info("save User.");
        User user = new User();
        try {
            user = User.builder()
                    .id(null)
                    .name(iUserDto.getName())
                    .password(iUserDto.getPassword())
                    .location(iUserDto.getLocation())
                    .grade(gradeService.getGrade(iUserDto.getGrade()).get())
                    .profileImg(iUserDto.getProfileImg())
                    .userName(iUserDto.getUserName())
                    .build();
            userRepository.save(user);
        } catch (Exception e) {
            log.error("error : {}" ,e.getMessage());
        }
        return user;
    }

    @Override
    public User editUser(IUserDto iUserDto) {
        log.info("Edit User. : {}", userRepository.findById(iUserDto.getId()).get());
        User user = new User();
        try {
            user = User.builder()
                    .id(iUserDto.getId())
                    .name(iUserDto.getName())
                    .password(iUserDto.getPassword())
                    .location(iUserDto.getLocation())
                    .grade(gradeService.getGrade(iUserDto.getGrade()).get())
                    .profileImg(iUserDto.getProfileImg())
                    .userName(iUserDto.getUserName())
                    .build();
        } catch (Exception e) {
            log.error("error : {}", e.getMessage());
        }
        userRepository.save(user);
        return user;
    }

    @Override
    public List<User> getAllUser() {
        log.info("get all User.");
        List<User> userList = new ArrayList<>();
        try {
            userList = userRepository.findAll();
        } catch (Exception e) {
            log.error("error : {}", e.getMessage());
        }
        return userList;
    }

    @Override
    public OUserDto getUserById(Long id) {
        log.info("get User by Id {}.", id);
        User user = new User();
        OUserDto oUserDto = new OUserDto();
        try {
            user = userRepository.findById(id).get();

            oUserDto = OUserDto.builder()
                    .createDate(user.getCreateDate())
                    .location(user.getLocation())
                    .modifiedDate(user.getModifiedDate())
                    .name(user.getName())
                    .password(user.getPassword())
                    .profileImg(user.getProfileImg())
                    .userName(user.getUserName())
                    .build();
        } catch (Exception e) {
            log.error("error : {}", e.getMessage());
        }

        return oUserDto;
    }

    @Override
    public void delUser(Long id) {
        log.info("delete User by Id {}.", id);
        try {
            // 유저의 sns 지우기
            List<SnsList> snsLists = snsListRepository.findAllByUserId(id);
            snsListRepository.deleteAll(snsLists);

            // 유저가 쓴 코멘트들 삭제
            List<Comment> comments = commentRepository.findAllByUserId(id);
            commentRepository.deleteAll(comments);

            // 유저가 쓴 리코멘트들 삭제
            List<Recomment> recomments = recommentRepository.findAllByUserId(id);
            recommentRepository.deleteAll(recomments);

            // 유저가 쓴 포스트들 삭제
            List<Post> posts = postRepository.findAllByUserId(id);
            postRepository.deleteAll(posts);
        } catch (Exception exception) {
            log.error("유저의 SNS 지우기 실패!!!!!! {}.", exception.getMessage());
        }
        userRepository.deleteById(id);
    }
}
