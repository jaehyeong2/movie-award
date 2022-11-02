package jjfactory.movieaward.biz.movie.dto.req;

import jjfactory.movieaward.biz.movie.entity.MovieGenre;
import jjfactory.movieaward.global.entity.Country;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class MovieModify {
    private String title;
    private Country country;
    private String releaseYear;

    @Builder
    public MovieModify(String title, Country country, String releaseYear) {
        this.title = title;
        this.country = country;
        this.releaseYear = releaseYear;
    }
}
