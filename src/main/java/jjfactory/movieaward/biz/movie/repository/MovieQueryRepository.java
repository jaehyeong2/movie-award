package jjfactory.movieaward.biz.movie.repository;


import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jjfactory.movieaward.biz.movie.dto.res.ActorDetailRes;
import jjfactory.movieaward.biz.movie.dto.res.ActorRes;
import jjfactory.movieaward.biz.movie.dto.res.MovieDetailRes;
import jjfactory.movieaward.biz.movie.dto.res.MovieRes;
import jjfactory.movieaward.biz.movie.entity.*;
import jjfactory.movieaward.global.entity.Country;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.util.List;

import static jjfactory.movieaward.biz.movie.entity.QActor.*;
import static jjfactory.movieaward.biz.movie.entity.QCasting.*;
import static jjfactory.movieaward.biz.movie.entity.QDirector.*;
import static jjfactory.movieaward.biz.movie.entity.QMovie.*;

@RequiredArgsConstructor
@Repository
public class MovieQueryRepository {
    private final JPAQueryFactory queryFactory;

    public MovieDetailRes findMovieDetailInfo(Long movieId){
        return queryFactory.select(Projections.constructor(MovieDetailRes.class, movie))
                .from(movie)
                .where(movie.id.eq(movieId))
                .fetchOne();
    }

    public MovieDetailRes findMovieDetailInfoV2(Long movieId){
        return queryFactory.select(Projections
                        .fields(MovieDetailRes.class,
                                movie.id.as("id"),
                                movie.title.as("name"),
                                movie.releaseYear.as("releaseYear"),
                                movie.company.name.as("companyName")
                                ))
                .from(movie)
                .where(movie.id.eq(movieId))
                .fetchOne();
    }

    /**
     * 제목 검색, 제작사 검색, 감독명 검색, 개봉년도 검색
     *
     * @return
     */
    public PageImpl<MovieRes> findMoviesInMovieIds(Pageable pageable, String companyName, String title, String country){
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

    public ActorDetailRes findActorDetails(Long actorId){
        return queryFactory.select(Projections.constructor(ActorDetailRes.class,actor))
                .from(actor)
                .where(actor.peopleCode.eq(actorId))
                .fetchOne();
    }

    public Page<ActorRes> findActors(Pageable pageable){
        List<ActorRes> result = queryFactory.select(Projections.constructor(ActorRes.class, actor))
                .from(actor)
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .orderBy(actor.createDate.desc())
                .fetch();

        int total = queryFactory.select(Projections.constructor(ActorRes.class, actor))
                .from(actor)
                .fetch().size();

        return new PageImpl<>(result,pageable,total);
    }

    public List<Movie> findMovieByCompanyId(Long companyId) {
        return queryFactory.selectFrom(movie)
                .where(movie.company.id.eq(companyId))
                .fetch();
    }

    public List<Actor> findActorsInActorCodes(List<Long> actorCodes){
        return queryFactory.selectFrom(actor)
                .where(actor._super.peopleCode.in(actorCodes))
                .fetch();
    }

    public List<Movie> findMoviesInMovieIds(List<Long> movieIds){
        return queryFactory.selectFrom(movie)
                .where(movie.id.in(movieIds))
                .fetch();
    }

    public List<Director> findDirectorsInActorCodes(List<Long> directorCodes){
        return queryFactory.selectFrom(director)
                .where(director.peopleCode.in(directorCodes))
                .fetch();
    }

    private static BooleanExpression containsTitle(String title) {
        if(!StringUtils.hasText(title)) return null;
        return movie.title.contains(title);
    }

    private static BooleanExpression eqCountry(String country) {
        if(ObjectUtils.isEmpty(country)) return null;
        return movie.country.stringValue().eq(country);
    }

    private static BooleanExpression containsCompanyName(String companyName) {
        if(!StringUtils.hasText(companyName)) return null;
        return movie.company.name.contains(companyName);
    }
}
