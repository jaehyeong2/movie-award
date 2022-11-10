package jjfactory.movieaward.global.util;

import jjfactory.movieaward.global.exception.EntityNotFoundException;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;


@NoArgsConstructor(access = AccessLevel.PRIVATE)
public abstract class DbUtils {

    public static <T> T getOrThrow(JpaRepository<T,Long> repository,Long id){
        return repository.findById(id).orElseThrow(EntityNotFoundException::new);
    }
}
