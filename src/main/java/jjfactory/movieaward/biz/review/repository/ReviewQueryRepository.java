package jjfactory.movieaward.biz.review.repository;


import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jjfactory.movieaward.biz.review.dto.res.ReviewRes;
import jjfactory.movieaward.biz.review.entity.QUser;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;

import static jjfactory.movieaward.biz.review.entity.QReview.review;
import static jjfactory.movieaward.biz.review.entity.QUser.*;

@Repository
@RequiredArgsConstructor
public class ReviewQueryRepository {
    private final JPAQueryFactory queryFactory;

    public Page<ReviewRes> findMyReviews(Pageable pageable,Long userId){
        List<ReviewRes> results = queryFactory.select(Projections.fields(ReviewRes.class,
                        review.id.as("id"),
                        user.username.as("username"),
                        review.content,
                        review.star,
                        review.createDate))
                .from(review)
                .innerJoin(review.reviewer,user)
                .where(user.id.eq(userId))
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .orderBy(review.createDate.desc())
                .fetch();

        int total = queryFactory.select(Projections.fields(ReviewRes.class,
                        review.id.as("id"),
                        user.username.as("username"),
                        review.content,
                        review.star,
                        review.createDate))
                .from(review)
                .innerJoin(review.reviewer,user)
                .where(user.id.eq(userId))
                .fetch().size();

        return new PageImpl<>(results,pageable,total);
    }

    public Page<ReviewRes> findReviewsByMovieId(Pageable pageable, Long movieId){
        List<ReviewRes> results = queryFactory.select(Projections.constructor(ReviewRes.class, review))
                .from(review)
                .where(review.movie.id.eq(movieId))
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .orderBy(review.createDate.desc())
                .fetch();

        int total = queryFactory.select(Projections.constructor(ReviewRes.class, review))
                .from(review)
                .where(review.movie.id.eq(movieId))
                .fetch().size();

        return new PageImpl<>(results,pageable,total);
    }
}
