package jjfactory.movieaward.biz.movie.repository;

import jjfactory.movieaward.biz.movie.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie,Long> {
}
