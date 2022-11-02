package jjfactory.movieaward.biz.award.repository;

import jjfactory.movieaward.biz.award.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Long> {
}
