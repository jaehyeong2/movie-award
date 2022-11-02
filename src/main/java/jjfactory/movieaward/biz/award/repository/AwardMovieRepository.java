package jjfactory.movieaward.biz.award.repository;

import jjfactory.movieaward.biz.award.entity.AwardToMovie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AwardMovieRepository extends JpaRepository<AwardToMovie, Long> {
}