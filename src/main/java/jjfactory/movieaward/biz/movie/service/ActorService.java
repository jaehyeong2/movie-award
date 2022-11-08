package jjfactory.movieaward.biz.movie.service;

import jjfactory.movieaward.biz.movie.dto.req.ActorCreate;
import jjfactory.movieaward.biz.movie.dto.res.ActorDetailRes;
import jjfactory.movieaward.biz.movie.dto.res.ActorRes;
import jjfactory.movieaward.biz.movie.entity.Actor;
import jjfactory.movieaward.biz.movie.entity.Casting;
import jjfactory.movieaward.biz.movie.entity.Movie;
import jjfactory.movieaward.biz.movie.repository.ActorRepository;
import jjfactory.movieaward.biz.movie.repository.CastingRepository;
import jjfactory.movieaward.biz.movie.repository.MovieQueryRepository;
import jjfactory.movieaward.biz.movie.repository.MovieRepository;
import jjfactory.movieaward.global.dto.res.PagingRes;
import jjfactory.movieaward.global.util.DbUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@Transactional
@Service
public class ActorService {
    private final ActorRepository actorRepository;
    private final MovieQueryRepository movieQueryRepository;
    private final MovieRepository movieRepository;
    private final CastingRepository castingRepository;

    @Transactional(readOnly = true)
    public ActorDetailRes findActorDetail(Long actorCode){
        return movieQueryRepository.findActorDetails(actorCode);
    }

    @Transactional(readOnly = true)
    public PagingRes<ActorRes> findActors(Pageable pageable){
        return new PagingRes<>(movieQueryRepository.findActors(pageable));
    }

    public Long save(ActorCreate dto){
        Actor actor = Actor.create(dto);
        actorRepository.save(actor);

        if(dto.getMovieIdAndCastNames() != null){
            dto.getMovieIdAndCastNames().forEach(e->{
                Movie movie = DbUtils.getOrThrow(movieRepository, e.getMovieId());

                Casting casting = Casting.create(movie, actor,e.getCastName());
                castingRepository.save(casting);
                casting.addToActor();
            });
        }
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
