package jjfactory.movieaward.biz.movie.repository;

import jjfactory.movieaward.biz.movie.entity.Casting;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CastingRepository extends JpaRepository<Casting,Long> {
}
