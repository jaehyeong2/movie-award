package jjfactory.movieaward.biz.movie.service;

import jjfactory.movieaward.biz.movie.dto.req.MovieCreate;
import jjfactory.movieaward.biz.movie.dto.req.MovieModify;
import jjfactory.movieaward.biz.movie.dto.res.MovieDetailRes;
import jjfactory.movieaward.biz.movie.dto.res.MovieRes;
import jjfactory.movieaward.biz.movie.entity.Actor;
import jjfactory.movieaward.biz.movie.entity.Company;
import jjfactory.movieaward.biz.movie.entity.Movie;
import jjfactory.movieaward.biz.movie.entity.MovieActor;
import jjfactory.movieaward.biz.movie.repository.*;
import jjfactory.movieaward.global.dto.res.PagingRes;
import jjfactory.movieaward.global.entity.Country;
import jjfactory.movieaward.global.util.DbUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class MovieService {
    private final MovieRepository movieRepository;
    private final MovieQueryRepository movieQueryRepository;
    private final MovieActorRepository movieActorRepository;
    private final CompanyRepository companyRepository;

    @Transactional(readOnly = true)
    public PagingRes<MovieRes> findMovies(Pageable pageable, String companyName, String title, String countryFind){;
        Country country = null;
        if(StringUtils.hasText(countryFind)) {
            country = Country.valueOf(countryFind);
        }

        return new PagingRes<>(movieQueryRepository.findMoviesInMovieIds(pageable,companyName,title, country));
    }

    @Transactional(readOnly = true)
    public MovieDetailRes findMovie(Long movieId){
        return movieQueryRepository.findMovieDetailInfo(movieId);
    }

    /**
     * 영화는 배우가 없을 수 있따.
     */
    public Long save(MovieCreate dto){
        Company company = DbUtils.getOrThrow(companyRepository, dto.getCompanyId());

        Movie movie = Movie.create(company, dto);
        movieRepository.save(movie);

        if(dto.getActorIds()!=null){
            List<Actor> actors = movieQueryRepository.findActorsInActorCodes(dto.getActorIds());

            addActors(movie,actors);
        }
        return movie.getId();
    }

    private void addActors(Movie movie,List<Actor> actors){
        actors.forEach(a->{
            MovieActor movieActor = MovieActor.create(movie, a);
            movieActorRepository.save(movieActor);
//            movie.addMovieActor(movieActor);
            movieActor.addToMovie();
        });
    }

    public String delete(Long movieId){
        movieRepository.deleteById(movieId);
        return "ok";
    }

    public String modify(MovieModify dto){
        Movie movie = DbUtils.getOrThrow(movieRepository, dto.getMovieId());
        movie.modify(dto);

        if (dto.getActorIds()!= null){
            List<Actor> actors = movieQueryRepository.findActorsInActorCodes(dto.getActorIds());
            addActors(movie,actors);
        }
        return "ok";
    }
}
