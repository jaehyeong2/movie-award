package jjfactory.movieaward.biz.movie.repository.award;

import jjfactory.movieaward.biz.movie.entity.award.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Long> {
}
