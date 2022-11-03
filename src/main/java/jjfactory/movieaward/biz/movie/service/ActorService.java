package jjfactory.movieaward.biz.movie.service;

import jjfactory.movieaward.biz.movie.dto.req.ActorCreate;
import jjfactory.movieaward.biz.movie.dto.res.ActorDetailRes;
import jjfactory.movieaward.biz.movie.dto.res.ActorRes;
import jjfactory.movieaward.biz.movie.entity.Actor;
import jjfactory.movieaward.biz.movie.entity.Movie;
import jjfactory.movieaward.biz.movie.entity.MovieActor;
import jjfactory.movieaward.biz.movie.repository.ActorRepository;
import jjfactory.movieaward.biz.movie.repository.MovieActorRepository;
import jjfactory.movieaward.biz.movie.repository.MovieQueryRepository;
import jjfactory.movieaward.global.dto.res.ApiResponse;
import jjfactory.movieaward.global.dto.res.PagingRes;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Transactional
@Service
public class ActorService {
    private final ActorRepository actorRepository;
    private final MovieQueryRepository movieQueryRepository;
    private final MovieActorRepository movieActorRepository;

    @Transactional(readOnly = true)
    public ApiResponse<ActorDetailRes> findActorDetail(Long actorCode){
        return new ApiResponse<>(movieQueryRepository.findActorDetails(actorCode));
    }

    @Transactional(readOnly = true)
    public PagingRes<ActorRes> findActors(Pageable pageable){
        return new PagingRes<>(movieQueryRepository.findActors(pageable));
    }

    /**
     * 하나 이상의 영화를 찍은 사람만 배우인걸로 치는걸로 함.
     */

    public Long save(ActorCreate dto){
        Actor actor = Actor.create(dto);
        actorRepository.save(actor);

        List<Movie> movies = movieQueryRepository.findMoviesInMovieIds(dto.getMovieIds());
        movies.forEach(m-> {
            MovieActor movieActor = MovieActor.create(m, actor);
            movieActorRepository.save(movieActor);
            movieActor.addToActor();
        });

        return actor.getPeopleCode();
    }

    public String delete(Long actorId){
        actorRepository.deleteById(actorId);
        return "ok";
    }

    public String updateActorInfo(Long actorId){
        //TODO

        return "ok";
    }
}
