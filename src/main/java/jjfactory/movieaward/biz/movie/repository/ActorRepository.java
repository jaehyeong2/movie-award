package jjfactory.movieaward.biz.movie.repository;

import jjfactory.movieaward.biz.movie.entity.Actor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActorRepository extends JpaRepository<Actor,Long> {
}
