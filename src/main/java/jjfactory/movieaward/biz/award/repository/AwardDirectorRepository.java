package jjfactory.movieaward.biz.award.repository;

import jjfactory.movieaward.biz.award.entity.AwardToDirector;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AwardDirectorRepository extends JpaRepository<AwardToDirector, Long> {
}