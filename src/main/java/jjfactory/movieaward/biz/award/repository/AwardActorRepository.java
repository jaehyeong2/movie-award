package jjfactory.movieaward.biz.award.repository;

import jjfactory.movieaward.biz.award.entity.AwardToActor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AwardActorRepository extends JpaRepository<AwardToActor, Long> {
}