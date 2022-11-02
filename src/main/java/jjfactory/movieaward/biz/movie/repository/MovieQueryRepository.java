package jjfactory.movieaward.biz.movie.repository;


import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jjfactory.movieaward.biz.movie.dto.res.MovieDetailRes;
import jjfactory.movieaward.biz.movie.dto.res.MovieRes;
import jjfactory.movieaward.biz.movie.entity.Actor;
import jjfactory.movieaward.biz.movie.entity.QActor;
import jjfactory.movieaward.global.entity.Country;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.util.List;

import static jjfactory.movieaward.biz.movie.entity.QActor.*;
import static jjfactory.movieaward.biz.movie.entity.QMovie.*;

@RequiredArgsConstructor
@Repository
public class MovieQueryRepository {
    private final JPAQueryFactory queryFactory;

    public MovieDetailRes findMovieDetailInfo(Long movieId){
        return queryFactory.select(Projections.constructor(MovieDetailRes.class,movie))
                .from(movie)
                .where(movie.id.eq(movieId))
                .fetchOne();
    }

    /**
     * 제목 검색, 제작사 검색, 감독명 검색, 개봉년도 검색
     *
     * @return
     */
    public PageImpl<MovieRes> findMovies(Pageable pageable, String companyName, String title, Country country){
        List<MovieRes> result = queryFactory.select(Projections.constructor(MovieRes.class, movie))
                .from(movie)
                .where(containsCompanyName(companyName),
                        containsTitle(title),
                        eqCountry(country))
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .orderBy(movie.createDate.desc())
                .fetch();

        int total = queryFactory.select(Projections.constructor(MovieRes.class, movie))
                .from(movie)
                .where(containsCompanyName(companyName),
                        containsTitle(title),
                        eqCountry(country))
                .fetch().size();

        return new PageImpl<>(result,pageable,total);
    }

    public List<Actor> findActors(List<Long> actorIds){
        return queryFactory.selectFrom(actor)
                .where(actor.id.in(actorIds))
                .fetch();
    }

    private static BooleanExpression containsTitle(String title) {
        if(!StringUtils.hasText(title)) return null;
        return movie.title.contains(title);
    }

    private static BooleanExpression eqCountry(Country country) {
        if(ObjectUtils.isEmpty(country)) return null;
        return movie.country.eq(country);
    }

    private static BooleanExpression containsCompanyName(String companyName) {
        if(!StringUtils.hasText(companyName)) return null;
        return movie.company.name.contains(companyName);
    }
}
