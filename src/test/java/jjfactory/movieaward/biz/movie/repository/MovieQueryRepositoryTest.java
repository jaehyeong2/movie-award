package jjfactory.movieaward.biz.movie.repository;

import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jjfactory.movieaward.biz.movie.dto.res.MovieDetailRes;
import jjfactory.movieaward.biz.movie.dto.res.MovieRes;
import jjfactory.movieaward.biz.movie.entity.*;
import jjfactory.movieaward.global.dto.req.MyPageReq;
import jjfactory.movieaward.global.entity.Country;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;

import java.util.List;

import static jjfactory.movieaward.biz.movie.entity.QMovie.movie;


@DataJpaTest
class MovieQueryRepositoryTest {

    @Autowired
    EntityManager em;
    private JPAQueryFactory queryFactory;
    @BeforeEach
    void setUp(){
        queryFactory = new JPAQueryFactory(em);
    }

    @Test
    @DisplayName("영화 단건 조회 성공")
    void findMovie(){
        Company companyA = Company.builder().name("companyA").build();
        Company companyB = Company.builder().name("companyB").build();
        em.persist(companyA);
        em.persist(companyB);

            Company companyTmp = companyA;

            Movie find = Movie.builder()
//                    .genre(MovieGenre.HORROR)
                    .country(Country.JAPAN)
                    .company(companyTmp)
                    .title("영화에염~")
                    .releaseYear("2021")
                    .build();
            em.persist(find);

        Actor lee = Actor.builder().name("lee").build();
        Actor kim = Actor.builder().name("kim").build();
        em.persist(lee);
        em.persist(kim);

        Casting casting1 = Casting.create(find, kim);
        Casting casting2 = Casting.create(find, lee);

//        find.addMovieActor(movieActor1);
//        find.addMovieActor(movieActor2);

        casting1.addToMovie();
        casting2.addToMovie();

        Director directorA = Director.builder().name("directorA").build();
        MovieDirector movieDirector = MovieDirector.create(find, directorA);

//        find.addMovieDirector(movieDirector);

        movieDirector.addToMovie();
        MovieDetailRes result = queryFactory.select(Projections.constructor(MovieDetailRes.class, movie))
                .from(movie)
//                .where(movie.genre.eq(MovieGenre.HORROR))
                .fetchOne();

        System.out.println("result = " + result);
    }

    @DisplayName("영화검색 성공 페이징")
    @Test
    void findMovies() {
        Company companyA = Company.builder().name("companyA").build();
        Company companyB = Company.builder().name("companyB").build();
        em.persist(companyA);
        em.persist(companyB);

        for (int i = 1; i < 17; i++) {
            Company companyTmp = companyA;
            if (i %2 == 0) companyTmp = companyB;

            Movie movie = Movie.builder()
//                    .genre(MovieGenre.HORROR)
                    .country(Country.JAPAN)
                    .title("바람" + i)
                    .company(companyTmp)
                    .releaseYear("2021")
                    .build();
            em.persist(movie);
        }

        String companyName = "A";
        String title = "바람";

        PageRequest pageable = new MyPageReq(1, 10).of();

        List<MovieRes> result = queryFactory.select(Projections.constructor(MovieRes.class, movie))
                .from(movie)
                .where(containsCompanyName(companyName),
                        containsTitle(title),
                        eqCountry(null))
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();

        Assertions.assertThat(result.size()).isEqualTo(8);
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