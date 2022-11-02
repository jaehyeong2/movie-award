package jjfactory.movieaward.biz.award.repository;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jjfactory.movieaward.biz.review.dto.res.ReviewRes;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;


@RequiredArgsConstructor
@Repository
public class AwardQueryRepository {
    private final JPAQueryFactory queryFactory;

}
