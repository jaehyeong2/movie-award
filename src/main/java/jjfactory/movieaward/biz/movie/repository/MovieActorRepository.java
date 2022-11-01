package jjfactory.movieaward.biz.movie.repository;

import jjfactory.movieaward.biz.movie.entity.MovieActor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieActorRepository extends JpaRepository<MovieActor,Long> {
}
