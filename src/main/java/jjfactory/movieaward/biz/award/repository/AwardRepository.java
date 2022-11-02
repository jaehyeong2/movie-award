package jjfactory.movieaward.biz.award.repository;

import jjfactory.movieaward.biz.award.entity.Award;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AwardRepository extends JpaRepository<Award,Long> {
}
