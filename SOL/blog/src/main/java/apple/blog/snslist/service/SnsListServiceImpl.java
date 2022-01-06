package apple.blog.snslist.service;

import apple.blog.sns.service.SnsService;
import apple.blog.snslist.dto.SnsListDto;
import apple.blog.snslist.model.SnsList;
import apple.blog.snslist.repository.SnsListRepository;
import apple.blog.user.repository.UserRepository;
import apple.blog.user.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class SnsListServiceImpl implements SnsListService {

    private final SnsListRepository snsListRepository;
    private final SnsService snsService;
    private final UserRepository userRepository;
//    private final UserService userService;

    @Override
    public SnsList addSnsList(SnsListDto snsListDto) {
        log.info("add Sns List.");
        return snsListRepository.save(
                SnsList.builder()
                        .id(null)
                        .sns(snsService.getSnsById(snsListDto.getSnsId()).get())
                        .user(userRepository.findById(snsListDto.getUserId()).get())
//                        .user(userService.getUserById(snsListDto.getUserId()).get())
                        .snsUrl(snsListDto.getSnsUrl())
                        .build()
        );
    }

    @Override
    public SnsList editSnsList(SnsListDto snsListDto) {
        log.info("edit Sns List By id {}.", snsListDto.getId());
        return snsListRepository.save(
                SnsList.builder()
                        .id(snsListDto.getId())
                        .sns(snsService.getSnsById(snsListDto.getSnsId()).get())
                        .user(userRepository.findById(snsListDto.getUserId()).get())
//                        .user(userService.getUserById(snsListDto.getUserId()).get())
                        .snsUrl(snsListDto.getSnsUrl())
                        .build()
        );
    }

    @Override
    public List<SnsList> getAll() {
        log.info("get all Sns List.");
        return snsListRepository.findAll();
    }

    @Override
    public void delSnsList(Long id) {
        log.info("delete Sns List by Id {}.", id);
        snsListRepository.deleteById(id);
    }
}
