package jjfactory.movieaward.biz.movie.repository;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jjfactory.movieaward.biz.movie.dto.res.DirectorDetailRes;
import jjfactory.movieaward.biz.movie.dto.res.DirectorRes;
import jjfactory.movieaward.biz.movie.entity.QDirector;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;

import static jjfactory.movieaward.biz.movie.entity.QDirector.*;

@RequiredArgsConstructor
@Repository
public class DirectorQueryRepository {
    private final JPAQueryFactory queryFactory;

    public DirectorDetailRes findDirector(Long directorCode){
        return queryFactory.select(Projections.constructor(DirectorDetailRes.class, director))
                .from(director)
                .where(director.peopleCode.eq(directorCode))
                .fetchOne();
    }

    public Page<DirectorRes> findAllDirectors(Pageable pageable){
        List<DirectorRes> result = queryFactory.select(Projections.constructor(DirectorRes.class, director))
                .from(director)
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();

        int total = queryFactory.select(Projections.constructor(DirectorRes.class, director))
                .from(director)
                .fetch().size();

        return new PageImpl<>(result,pageable,total);
    }
}
