package apple.blog.snslist.service;

import apple.blog.sns.service.SnsService;
import apple.blog.snslist.dto.OSnsListDto;
import apple.blog.snslist.dto.SnsListDto;
import apple.blog.snslist.model.SnsList;
import apple.blog.snslist.repository.SnsListRepository;
import apple.blog.user.repository.UserRepository;
import apple.blog.user.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class SnsListServiceImpl implements SnsListService {

    private final SnsListRepository snsListRepository;
    private final SnsService snsService;
    private final UserRepository userRepository;

    @Override
    public SnsList addSnsList(SnsListDto snsListDto) {
        log.info("add Sns List.");
        SnsList snsList = new SnsList();
        try {
            snsList = snsListRepository.save(
                    SnsList.builder()
                            .id(null)
                            .sns(snsService.getSnsById(snsListDto.getSnsId()).get())
                            .user(userRepository.findById(snsListDto.getUserId()).get())
                            .snsUrl(snsListDto.getSnsUrl())
                            .build()
            );
        } catch (Exception e) {
            log.error("error : {}", e.getMessage());
        }
        return snsList;
    }

    @Override
    public SnsList editSnsList(SnsListDto snsListDto) {
        log.info("edit Sns List By id {}.", snsListDto.getId());
        SnsList snsList = new SnsList();
        try {
            snsList = snsListRepository.save(
                    SnsList.builder()
                            .id(snsListDto.getId())
                            .sns(snsService.getSnsById(snsListDto.getSnsId()).get())
                            .user(userRepository.findById(snsListDto.getUserId()).get())
                            .snsUrl(snsListDto.getSnsUrl())
                            .build()
            );
        } catch (Exception e) {
            log.error("error : {}", e.getMessage());
        }
        return snsList;
    }

    @Override
    public List<OSnsListDto> getAll(Long userId) {
        log.info("get all Sns List.");
        List<OSnsListDto> oSnsListDtoList = new ArrayList<>();
        List<SnsList> snsLists = new ArrayList<>();
        try {
            snsLists = snsListRepository.findAllByUserId(userId);
            log.info("Userid {}, snsList {}" , userId, snsLists);
            snsLists.stream().forEach(
                    snsList -> {
                        oSnsListDtoList.add(OSnsListDto.builder()
                                .snsId(snsList.getSns().getId())
                                .snsUrl(snsList.getSnsUrl())
                                .build());
                    }
            );
        } catch (Exception e) {
            log.error("error : {}", e.getMessage());
        }
        return oSnsListDtoList;
    }

    @Override
    public void delSnsList(Long id) {
        log.info("delete Sns List by Id {}.", id);
        try {
            snsListRepository.deleteById(id);
        } catch (Exception e) {
            log.error("error : {}", e.getMessage());
        }
    }
}
