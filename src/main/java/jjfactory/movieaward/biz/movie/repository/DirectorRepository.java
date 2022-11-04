package jjfactory.movieaward.biz.movie.repository;

import jjfactory.movieaward.biz.movie.entity.Director;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DirectorRepository extends JpaRepository<Director, Long> {
    Optional<Director> findByName(String name);
}