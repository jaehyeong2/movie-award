package jjfactory.movieaward.biz.movie.repository;

import jjfactory.movieaward.biz.movie.entity.MovieCode;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieCodeRepository extends JpaRepository<MovieCode, Long> {
}