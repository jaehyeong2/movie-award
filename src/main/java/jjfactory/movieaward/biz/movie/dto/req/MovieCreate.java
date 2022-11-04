package jjfactory.movieaward.biz.movie.dto.req;

import jjfactory.movieaward.biz.movie.entity.MovieGenre;
import jjfactory.movieaward.global.entity.Country;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor
@Getter
public class MovieCreate {
    @NotNull
    private Long companyId;
    @NotEmpty
    private String title;
    private Country country;
    @NotEmpty
    private String releaseYear;
    @NotNull
    private int viewCount;
    private MovieGenre genre;

    private List<Long> actorIds;
    private List<Long> directorIds;

    @Builder
    public MovieCreate(String title, Country country, String releaseYear, int viewCount) {
        this.title = title;
        this.country = country;
        this.releaseYear = releaseYear;
        this.viewCount = viewCount;
    }
}
