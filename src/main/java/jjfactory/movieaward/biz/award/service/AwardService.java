package jjfactory.movieaward.biz.award.service;

import jjfactory.movieaward.biz.award.dto.res.AwardRes;
import jjfactory.movieaward.biz.award.entity.*;
import jjfactory.movieaward.biz.award.repository.*;
import jjfactory.movieaward.biz.award.dto.req.AwardCreate;
import jjfactory.movieaward.biz.award.dto.req.AwardModify;
import jjfactory.movieaward.biz.movie.entity.Actor;
import jjfactory.movieaward.biz.movie.entity.Director;
import jjfactory.movieaward.biz.movie.entity.Movie;
import jjfactory.movieaward.biz.movie.repository.ActorRepository;
import jjfactory.movieaward.biz.movie.repository.DirectorRepository;
import jjfactory.movieaward.biz.movie.repository.MovieRepository;
import jjfactory.movieaward.global.dto.res.PagingRes;
import jjfactory.movieaward.global.util.DbUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.NoSuchElementException;

//@Transactional
@RequiredArgsConstructor
@Service
public class AwardService {
    private final AwardQueryRepository awardQueryRepository;
    private final AwardRepository awardRepository;
    private final AwardActorRepository awardActorRepository;
    private final AwardDirectorRepository awardDirectorRepository;
    private final AwardMovieRepository awardMovieRepository;
    private final CategoryRepository categoryRepository;
    private final MovieRepository movieRepository;
    private final ActorRepository actorRepository;
    private final DirectorRepository directorRepository;

    @Transactional(readOnly = true)
    public PagingRes<AwardRes> findAllAwards(Pageable pageable){
        return new PagingRes<>(awardQueryRepository.findAllAwards(pageable));
    }

    public Long save(Long categoryId, AwardCreate dto){
        Category category = DbUtils.getOrThrow(categoryRepository, categoryId);
        Award award = Award.create(dto, category);
        awardRepository.save(award);

        if(StringUtils.hasText(dto.getWinnerName())){
            if (dto.getWinnerType().equals(WinnerType.MOVIE)){
                createAwardToMovie(dto, award);
            }else if(dto.getWinnerType().equals(WinnerType.DIRECTOR)){
                createAwardToDirector(dto, award);
            }else if(dto.getWinnerType().equals(WinnerType.ACTOR)){
                createAwardToActor(dto, award);
            }
        }
        return award.getId();
    }

    private void createAwardToActor(AwardCreate dto, Award award) {
        Actor actor = actorRepository.findByName(dto.getWinnerName()).orElseThrow(NoSuchElementException::new);
        AwardToActor awardToActor = AwardToActor.create(actor, award);
        awardActorRepository.save(awardToActor);
    }

    private void createAwardToDirector(AwardCreate dto, Award award) {
        Director director = directorRepository.findByName(dto.getWinnerName()).orElseThrow(NoSuchElementException::new);
        AwardToDirector awardToDirector = AwardToDirector.create(director, award);
        awardDirectorRepository.save(awardToDirector);
    }

    private void createAwardToMovie(AwardCreate dto, Award award) {
        Movie movie = movieRepository.findByName(dto.getWinnerName()).orElseThrow(NoSuchElementException::new);
        AwardToMovie awardToMovie = AwardToMovie.create(movie, award);
        awardMovieRepository.save(awardToMovie);
    }

    public String delete(Long awardId){
        awardRepository.deleteById(awardId);
        return "ok";
    }

    public String modify(Long awardId, AwardModify dto){
        Award award = DbUtils.getOrThrow(awardRepository, awardId);
        award.modify(dto);
        return "ok";
    }

}
