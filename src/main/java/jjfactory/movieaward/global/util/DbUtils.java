package jjfactory.movieaward.global.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.NoSuchElementException;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public abstract class DbUtils {

    public static <T> T getOrThrow(JpaRepository<T,Long> repository,Long id){
        return repository.findById(id).orElseThrow(NoSuchElementException::new);
    }
}
