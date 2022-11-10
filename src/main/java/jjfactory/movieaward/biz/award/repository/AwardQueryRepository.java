package jjfactory.movieaward.biz.award.repository;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jjfactory.movieaward.biz.award.dto.res.AwardRes;
import jjfactory.movieaward.biz.award.entity.QAward;
import jjfactory.movieaward.biz.award.entity.QCategory;
import jjfactory.movieaward.biz.movie.entity.*;
import jjfactory.movieaward.biz.review.dto.res.ReviewRes;
import jjfactory.movieaward.global.exception.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;

import static jjfactory.movieaward.biz.award.entity.QAward.*;
import static jjfactory.movieaward.biz.award.entity.QCategory.*;
import static jjfactory.movieaward.biz.movie.entity.QActor.*;
import static jjfactory.movieaward.biz.movie.entity.QDirector.*;
import static jjfactory.movieaward.biz.movie.entity.QMovie.*;


@RequiredArgsConstructor
@Repository
public class AwardQueryRepository {
    private final JPAQueryFactory queryFactory;

    public Page<AwardRes> findAllAwards(Pageable pageable){
        List<AwardRes> results = queryFactory.select(Projections.constructor(AwardRes.class, award, category))
                .from(award)
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();

        int total = queryFactory.select(Projections.constructor(AwardRes.class, award,category))
                .from(award)
                .fetch().size();

        return new PageImpl<>(results,pageable,total);
    }

    public List<Actor> findActorsInNames(List<String> names){
        List<Actor> result = queryFactory.selectFrom(actor)
                .where(actor.name.in(names)).fetch();

        if(result == null || result.size()==0) throw new EntityNotFoundException();
        return result;
    }

    public List<Movie> findMoviesInNames(List<String> names){
        List<Movie> result = queryFactory.selectFrom(movie)
                .where(movie.title.in(names)).fetch();
        if(result == null || result.size() == 0) throw new EntityNotFoundException();
        return result;
    }

    public List<Director> findDirectorsInNames(List<String> names){
        List<Director> result = queryFactory.selectFrom(director)
                .where(director.name.in(names)).fetch();
        if(result == null || result.size() == 0) throw new EntityNotFoundException();
        return result;
    }

}
