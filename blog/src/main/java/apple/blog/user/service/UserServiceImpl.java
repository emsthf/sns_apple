package apple.blog.user.service;

import apple.blog.comment.model.Comment;
import apple.blog.comment.repository.CommentRepository;
import apple.blog.commentlist.model.CommentList;
import apple.blog.commentlist.repository.CommentListRepository;
import apple.blog.grade.service.GradeService;
import apple.blog.post.model.Post;
import apple.blog.post.repository.PostRepository;
import apple.blog.recomment.model.Recomment;
import apple.blog.recomment.repository.RecommentRepository;
import apple.blog.recommentlist.model.RecommentList;
import apple.blog.recommentlist.repository.RecommentListRepository;
import apple.blog.sns.model.Sns;
import apple.blog.sns.repository.SnsRepository;
import apple.blog.snslist.model.SnsList;
import apple.blog.snslist.repository.SnsListRepository;
import apple.blog.snslist.service.SnsListService;
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
    private final SnsListService snsListService;
    private final CommentRepository commentRepository;
    private final RecommentRepository recommentRepository;
    private final PostRepository postRepository;
    private final CommentListRepository commentListRepository;
    private final RecommentListRepository recommentListRepository;

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
        snsListRepository.deleteAll(snsListRepository.findAllByUserId(id));

        List<Comment> comments = commentRepository.findAllByUserId(id);

        comments.forEach(
                comment -> {
//                    List<RecommentList> recommentLists = recommentListRepository.findAllByCommentId(comment.getId());
                    log.info("리코멘트 id 뽑아 왔나? {}", comment);
//                    commentRepository.delete(comment);
//                    log.info("리코멘트 id 뽑아 왔나? {}", comment);

//                    recommentListRepository.deleteAll(recommentLists);
                }
        );
//        commentRepository.deleteAll(comments);
//        try {
//            // 유저의 sns 지우기
////            List<SnsList> snsLists = snsListRepository.findAllByUserId(id);
////            log.info("snsList {}",snsLists);
////            snsListRepository.deleteAll(snsLists);
//
//
//            // 유저가 쓴 코멘트들 삭제
//
//
////            // 코멘트 리스트의 id로 해당 코멘트 리스트의 코멘트를 받는다
////            Long commentId = commentListRepository.findById(id).get().getComment().getId();
////            // 코멘트 id로 찾은 코멘트에 달린 리코멘트 전부 찾기
////            List<RecommentList> recommentLists = recommentListRepository.findAllByCommentId(commentId);
////            log.info("recommentList {}", recommentLists);
////            // 리코멘트에서 코멘트 id로 해당 코멘트에 달린 모든 리코멘트를 찾아서 지운다
////            recommentListRepository.deleteAll(recommentLists);
////            // 코멘트에 달린 리코멘트가 지워진 후, 코멘트 리스트를 지워서 코멘트도 함께 지운다
////            commentListRepository.deleteById(id);
//
//
//            // 유저가 쓴 리코멘트들 삭제
//            List<Recomment> recomments = recommentRepository.findAllByUserId(id);
//            recommentRepository.deleteAll(recomments);
//
//            // 유저가 쓴 포스트들 삭제
//            List<Post> posts = postRepository.findAllByUserId(id);
//            posts.stream().forEach(
//                    post -> {
//                        List<CommentList> commentLists = commentListRepository.findAllByPostId(post.getId());
//                        log.info("유저가 쓴 포스트의 댓글 가져오기 : {}", commentLists);
//                        commentLists.stream().forEach(
//                                commentList -> {
//                                    List<RecommentList> recommentLists = recommentListRepository.findAllByCommentId(commentList.getComment().getId());
//                                    log.info("유저가 쓴 포스트에 달린 댓글에 달린 대댓글 {}", recommentLists);
//                                    recommentListRepository.deleteAll(recommentLists);
//                                }
//                        );
//                        commentListRepository.deleteAll(commentLists);
//                    }
//            );
//            postRepository.deleteAll(posts);
//
//        } catch (Exception exception) {
//            log.error("유저의 SNS 지우기 실패!!!!!! {}.", exception.getMessage());
//        }
//        userRepository.deleteById(id);
    }
}
