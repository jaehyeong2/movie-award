package jjfactory.movieaward.biz.movie.dto.res;

import jjfactory.movieaward.biz.movie.entity.Actor;
import jjfactory.movieaward.biz.movie.entity.Movie;
import jjfactory.movieaward.biz.movie.entity.MovieActor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;
import java.util.stream.Collectors;

@ToString
@NoArgsConstructor
@Getter
public class MovieDetailRes {
    private String name;
    private String releaseYear;
    private String companyName;
    private String genre;
    private Long movieSeq;
    private List<String> actorNames;
    private List<String> directorNames;

    public MovieDetailRes(String name, String releaseYear, String companyName, String genre) {
        this.name = name;
        this.releaseYear = releaseYear;
        this.companyName = companyName;
        this.genre = genre;
    }

    public MovieDetailRes(Movie movie) {
        this.name = movie.getTitle();
        this.releaseYear = movie.getReleaseYear();
        this.companyName = movie.getCompany().getName();
        this.genre = movie.getGenre().toString();
        this.movieSeq = movie.getId();
        this.actorNames = movie.getActorNames();
        this.directorNames = movie.getDirectorNames();
    }
}
