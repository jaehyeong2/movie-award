package jjfactory.movieaward.biz.movie.repository;

import jjfactory.movieaward.biz.movie.entity.Actor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ActorRepository extends JpaRepository<Actor,Long> {
    Optional<Actor> findByName(String name);
}
