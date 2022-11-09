package jjfactory.movieaward.biz.review.repository;

import jjfactory.movieaward.biz.review.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ReviewRepository extends JpaRepository<Review,Long> {
    Optional<Review> findReviewByMovieIdAndReviewerId(Long movieId,Long reviewId);
}
