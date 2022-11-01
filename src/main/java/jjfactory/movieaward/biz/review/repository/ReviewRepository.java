package jjfactory.movieaward.biz.review.repository;

import jjfactory.movieaward.biz.review.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review,Long> {
}
