package jjfactory.movieaward.biz.award.service;

import jjfactory.movieaward.biz.award.dto.req.CategoryCreate;
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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.stream.Collectors;

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

    @Transactional(readOnly = true)
    public PagingRes<AwardRes> findAllAwards(Pageable pageable){
        return new PagingRes<>(awardQueryRepository.findAllAwards(pageable));
    }

    public Long save(Long categoryId, AwardCreate dto){
        Category category = DbUtils.getOrThrow(categoryRepository, categoryId);
        Award award = Award.create(dto, category);
        awardRepository.save(award);

        if(dto.getWinnerNames()!=null && dto.getWinnerNames().size() > 0){
            switch (dto.getWinnerType()){
                case MOVIE: createAwardToMovie(dto,award); break;
                case ACTOR: createAwardToActor(dto,award); break;
                case DIRECTOR: createAwardToDirector(dto,award); break;
            }
        }
        return award.getId();
    }

    private void createAwardToActor(AwardCreate dto, Award award) {
        List<Actor> actors = awardQueryRepository.findActorsInNames(dto.getWinnerNames());
        actors.forEach(actor-> {
            AwardToActor awardToActor = AwardToActor.create(actor, award);
            awardActorRepository.save(awardToActor);
            awardToActor.addActor();
        });
    }

    private void createAwardToDirector(AwardCreate dto, Award award) {
        List<Director> directors = awardQueryRepository.findDirectorsInNames(dto.getWinnerNames());
        directors.forEach(director -> {
            AwardToDirector awardToDirector = AwardToDirector.create(director, award);
            awardDirectorRepository.save(awardToDirector);
            awardToDirector.addDirector();
        });
    }

    private void createAwardToMovie(AwardCreate dto, Award award) {
        List<Movie> movies = awardQueryRepository.findMoviesInNames(dto.getWinnerNames());
        movies.forEach(movie -> {
            AwardToMovie awardToMovie = AwardToMovie.create(movie, award);
            awardMovieRepository.save(awardToMovie);
            awardToMovie.addMovie();
        });
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

    public Long createCategory(CategoryCreate dto){
        return categoryRepository.save(Category.builder()
                .name(dto.getName())
                .build()).getId();
    }

}
