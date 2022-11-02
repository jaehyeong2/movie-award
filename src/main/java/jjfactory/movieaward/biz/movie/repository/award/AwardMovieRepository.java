package jjfactory.movieaward.biz.movie.repository.award;

import jjfactory.movieaward.biz.movie.entity.award.AwardMovie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AwardMovieRepository extends JpaRepository<AwardMovie, Long> {
}