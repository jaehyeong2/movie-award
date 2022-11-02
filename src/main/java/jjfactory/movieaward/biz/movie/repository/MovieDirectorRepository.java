package jjfactory.movieaward.biz.movie.repository;

import jjfactory.movieaward.biz.movie.entity.MovieDirector;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieDirectorRepository extends JpaRepository<MovieDirector, Long> {
}