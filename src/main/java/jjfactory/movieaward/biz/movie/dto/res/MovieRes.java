package jjfactory.movieaward.biz.movie.dto.res;

import jjfactory.movieaward.biz.award.entity.Category;
import jjfactory.movieaward.biz.movie.entity.Movie;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor
@Getter
public class MovieRes {
    private String name;
    private String releaseYear;
    private String companyName;
    private List<String> genre;

    public MovieRes(String name, String releaseYear, String companyName,List<String> genre) {
        this.name = name;
        this.releaseYear = releaseYear;
        this.companyName = companyName;
        this.genre = genre;
    }

    public MovieRes(Movie movie) {
        this.name = movie.getTitle();
        this.releaseYear = movie.getReleaseYear();
        this.companyName = movie.getCompany().getName();
        this.genre = movie.getGenres().stream().map(Enum::toString).collect(Collectors.toList());
    }
}
