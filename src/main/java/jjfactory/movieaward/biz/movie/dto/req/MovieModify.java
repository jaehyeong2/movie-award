package jjfactory.movieaward.biz.movie.dto.req;

import jjfactory.movieaward.biz.movie.entity.MovieGenre;
import jjfactory.movieaward.global.entity.Country;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@NoArgsConstructor
@Getter
public class MovieModify {
    @NotNull
    private Long movieId;
    @NotEmpty
    private String title;
    private Country country;
    @NotEmpty
    private String releaseYear;

    private List<Long> actorIds;

    @Builder
    public MovieModify(String title, Country country, String releaseYear) {
        this.title = title;
        this.country = country;
        this.releaseYear = releaseYear;
    }
}
