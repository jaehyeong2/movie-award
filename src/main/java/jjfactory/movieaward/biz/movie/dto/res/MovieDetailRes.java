package jjfactory.movieaward.biz.movie.dto.res;

import jjfactory.movieaward.biz.movie.entity.Movie;
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
    private List<String> genres;
    private Long movieSeq;
    private List<String> actorNames;
    private List<String> directorNames;

    public MovieDetailRes(String name, String releaseYear, String companyName, List<String> genres) {
        this.name = name;
        this.releaseYear = releaseYear;
        this.companyName = companyName;
        this.genres = genres;
    }

    public MovieDetailRes(Movie movie) {
        this.name = movie.getTitle();
        this.releaseYear = movie.getReleaseYear();
        this.companyName = movie.getCompany().getName();
        this.genres = movie.getGenres().stream().map(Enum::toString).collect(Collectors.toList());
        this.movieSeq = movie.getId();
        this.actorNames = movie.getActorNames();
        this.directorNames = movie.getDirectorNames();
    }
}
