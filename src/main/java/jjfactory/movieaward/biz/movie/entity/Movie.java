package jjfactory.movieaward.biz.movie.entity;

import jjfactory.movieaward.biz.movie.dto.req.MovieCreate;
import jjfactory.movieaward.global.entity.BaseEntity;
import jjfactory.movieaward.global.entity.Country;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class Movie extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "company_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Company company;

    private String title;

    private int viewCount;
    @Enumerated(EnumType.STRING)
    private Country country;

    private LocalDate releaseYear;

    @Builder
    public Movie(Company company, String title, int viewCount, Country country, LocalDate releaseYear) {
        this.company = company;
        this.title = title;
        this.viewCount = viewCount;
        this.country = country;
        this.releaseYear = releaseYear;
    }

    public static Movie create(Company company,MovieCreate dto){
        return Movie.builder()
                .company(company)
                .country(dto.getCountry())
                .viewCount(dto.getViewCount())
                .title(dto.getTitle())
                .releaseYear(dto.getReleaseYear())
                .build();
    }
}
