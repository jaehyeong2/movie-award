package jjfactory.movieaward.biz.movie.dto.res;

import jjfactory.movieaward.biz.movie.entity.Movie;
import jjfactory.movieaward.biz.movie.entity.MovieGenre;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Getter
public class MovieRes {
    private Long id;
    private String name;
    private String releaseYear;
    private String companyName;
    private List<MovieGenre> genres;

    public MovieRes(String name, String releaseYear, String companyName,List<MovieGenre> genres) {
        this.name = name;
        this.releaseYear = releaseYear;
        this.companyName = companyName;
        this.genres = genres;
    }

    public MovieRes(Movie movie) {
        this.id = movie.getId();
        this.name = movie.getTitle();
        this.releaseYear = movie.getReleaseYear();
        this.companyName = movie.getCompany().getName();
        this.genres = movie.getGenres();
    }
}
