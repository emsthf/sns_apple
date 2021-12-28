package apple.blog.sns.service;

import apple.blog.sns.model.Sns;

import java.util.List;
import java.util.Optional;

public interface SnsService {
    Sns addSns(Sns sns);
    List<Sns> getAllSns();
    Optional<Sns> getSns(Long id);
    void delSns(Long id);
}
