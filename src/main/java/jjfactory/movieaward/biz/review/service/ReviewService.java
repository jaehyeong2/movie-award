package jjfactory.movieaward.biz.review.service;

import jjfactory.movieaward.biz.movie.entity.Movie;
import jjfactory.movieaward.biz.movie.repository.MovieRepository;
import jjfactory.movieaward.biz.review.dto.req.ReviewCreate;
import jjfactory.movieaward.biz.review.dto.req.ReviewModify;
import jjfactory.movieaward.biz.review.dto.res.ReviewRes;
import jjfactory.movieaward.biz.review.entity.Review;
import jjfactory.movieaward.biz.review.entity.User;
import jjfactory.movieaward.biz.review.repository.ReviewQueryRepository;
import jjfactory.movieaward.biz.review.repository.ReviewRepository;
import jjfactory.movieaward.biz.review.repository.UserRepository;
import jjfactory.movieaward.global.dto.res.PagingRes;
import jjfactory.movieaward.global.exception.DuplicateReviewCreateException;
import jjfactory.movieaward.global.util.DbUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
@Transactional
public class ReviewService {
    private final ReviewRepository reviewRepository;
    private final UserRepository userRepository;
    private final ReviewQueryRepository reviewQueryRepository;
    private final MovieRepository movieRepository;


    /**
     * 내가 작성한 리뷰 조회
     */
    @Transactional(readOnly = true)
    public PagingRes<ReviewRes> findMyReviews(Pageable pageable, Long userId){
        return new PagingRes(reviewQueryRepository.findMyReviews(pageable,userId));
    }

    /**
     * 영화 한개 리뷰 조회
     */
    @Transactional(readOnly = true)
    public PagingRes<ReviewRes> findReviewsByMovieId(Pageable pageable, Long movieId){
        return new PagingRes(reviewQueryRepository.findReviewsByMovieId(pageable,movieId));
    }

    public Long save(ReviewCreate dto){
        User user = DbUtils.getOrThrow(userRepository,dto.getUserId());
        Movie movie = DbUtils.getOrThrow(movieRepository,dto.getMovieId());

        if(reviewRepository.findReviewByMovieIdAndReviewerId(movie.getId(),user.getId()).isPresent()){
            throw new DuplicateReviewCreateException();
        }

        Review review = Review.create(user, movie, dto);

        reviewRepository.save(review);
        movie.increaseReviewCount();
        return review.getId();
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
