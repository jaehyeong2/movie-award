package jjfactory.movieaward.biz.movie.repository.award;

import jjfactory.movieaward.biz.movie.entity.award.Award;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AwardRepository extends JpaRepository<Award,Long> {
}
