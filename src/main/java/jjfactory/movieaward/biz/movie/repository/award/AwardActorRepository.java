package jjfactory.movieaward.biz.movie.repository.award;

import jjfactory.movieaward.biz.movie.entity.award.AwardActor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AwardActorRepository extends JpaRepository<AwardActor, Long> {
}