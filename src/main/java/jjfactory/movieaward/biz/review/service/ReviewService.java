package jjfactory.movieaward.biz.review.service;

import jjfactory.movieaward.biz.movie.entity.Movie;
import jjfactory.movieaward.biz.movie.repository.MovieRepository;
import jjfactory.movieaward.biz.review.dto.req.ReviewCreate;
import jjfactory.movieaward.biz.review.dto.req.ReviewModify;
import jjfactory.movieaward.biz.review.entity.Review;
import jjfactory.movieaward.biz.review.entity.User;
import jjfactory.movieaward.biz.review.repository.ReviewQueryRepository;
import jjfactory.movieaward.biz.review.repository.ReviewRepository;
import jjfactory.movieaward.biz.review.repository.UserRepository;
import jjfactory.movieaward.global.dto.res.PagingRes;
import jjfactory.movieaward.global.util.DbUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class ReviewService {
    private final ReviewRepository reviewRepository;
    private final UserRepository userRepository;
    private final ReviewQueryRepository reviewQueryRepository;
    private final MovieRepository movieRepository;

    public void findReviews(){

    }

    @Transactional(readOnly = true)
    public PagingRes findReviewsByMovieId(Pageable pageable, Long movieId){
        return new PagingRes(reviewQueryRepository.findReviewsByMovieId(pageable,movieId));
    }

    public Long save(Long reviewerId, Long movieId, ReviewCreate dto){
        User user = DbUtils.getOrThrow(userRepository,reviewerId);
        Movie movie = DbUtils.getOrThrow(movieRepository,movieId);

        Review review = Review.create(user, movie, dto);
        Review save = reviewRepository.save(review);

        return save.getId();
    }

    public String delete(Long reviewId){
        Review review = DbUtils.getOrThrow(reviewRepository,reviewId);
        reviewRepository.delete(review);
        return "ok";
    }

    public String modify(Long reviewId, ReviewModify dto){
        Review review = DbUtils.getOrThrow(reviewRepository,reviewId);
        review.modify(dto);
        return "ok";
    }

}
