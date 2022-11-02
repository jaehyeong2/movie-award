package jjfactory.movieaward.biz.movie.dto.req;

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
    private LocalDate releaseYear;
    private int viewCount;

    @Builder
    public MovieCreate(String title, Country country, LocalDate releaseYear, int viewCount) {
        this.title = title;
        this.country = country;
        this.releaseYear = releaseYear;
        this.viewCount = viewCount;
    }
}
