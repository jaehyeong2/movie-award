package jjfactory.movieaward.biz.movie.dto.req;

import jjfactory.movieaward.biz.movie.entity.MovieGenre;
import jjfactory.movieaward.global.entity.Country;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
public class MovieCreate {
    private String title;
    private Country country;
    private String releaseYear;
    private int viewCount;
    private MovieGenre genre;

    @Builder
    public MovieCreate(String title, Country country, String releaseYear, int viewCount) {
        this.title = title;
        this.country = country;
        this.releaseYear = releaseYear;
        this.viewCount = viewCount;
    }
}
