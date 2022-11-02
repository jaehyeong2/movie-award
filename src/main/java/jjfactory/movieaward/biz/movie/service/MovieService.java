package jjfactory.movieaward.biz.movie.service;

import jjfactory.movieaward.biz.movie.dto.req.MovieCreate;
import jjfactory.movieaward.biz.movie.dto.req.MovieModify;
import jjfactory.movieaward.biz.movie.dto.res.MovieDetailRes;
import jjfactory.movieaward.biz.movie.dto.res.MovieRes;
import jjfactory.movieaward.biz.movie.entity.Actor;
import jjfactory.movieaward.biz.movie.entity.Company;
import jjfactory.movieaward.biz.movie.entity.Movie;
import jjfactory.movieaward.biz.movie.entity.MovieActor;
import jjfactory.movieaward.biz.movie.repository.CompanyRepository;
import jjfactory.movieaward.biz.movie.repository.MovieActorRepository;
import jjfactory.movieaward.biz.movie.repository.MovieQueryRepository;
import jjfactory.movieaward.biz.movie.repository.MovieRepository;
import jjfactory.movieaward.global.dto.res.PagingRes;
import jjfactory.movieaward.global.entity.Country;
import jjfactory.movieaward.global.util.DbUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    public PagingRes<MovieRes> findMovies(Pageable pageable, String companyName, String title, String country){
        return new PagingRes<>(movieQueryRepository.findMovies(pageable,companyName,title, Country.valueOf(country)));
    }

    @Transactional(readOnly = true)
    public MovieDetailRes findMovie(Long movieId){
        return movieQueryRepository.findMovieDetailInfo(movieId);
    }

    /**
     * 영화는 배우가 없을 수 있따.
     */
    public void save(Long companyId, MovieCreate dto){
        Company company = DbUtils.getOrThrow(companyRepository, companyId);

        Movie movie = Movie.create(company, dto);
        movieRepository.save(movie);
    }

    public void addActors(Long movieId,List<Actor> actors){
        Movie movie = DbUtils.getOrThrow(movieRepository, movieId);

        actors.forEach(a->{
            MovieActor movieActor = MovieActor.create(movie, a);
            movieActorRepository.save(movieActor);
        });
    }

    public String delete(Long movieId){
        movieRepository.deleteById(movieId);
        return "ok";
    }

    public String modify(Long movieId, MovieModify dto){
        Movie movie = DbUtils.getOrThrow(movieRepository, movieId);
        movie.modify(dto);
        return "ok";
    }
}
