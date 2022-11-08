package jjfactory.movieaward.biz.movie.entity;

import jjfactory.movieaward.biz.award.entity.AwardToMovie;
import jjfactory.movieaward.biz.movie.dto.req.MovieCreate;
import jjfactory.movieaward.biz.movie.dto.req.MovieModify;
import jjfactory.movieaward.global.entity.BaseEntity;
import jjfactory.movieaward.global.entity.Country;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    @CollectionTable(name = "movie_genre", joinColumns = @JoinColumn(name = "movie_id"))
    @ElementCollection(fetch = FetchType.LAZY)
    @Enumerated(EnumType.STRING)
    private List<MovieGenre> genres = new ArrayList<>();
    private int viewCount;
    @Enumerated(EnumType.STRING)
    private Country country;
    private String releaseYear;

    private int reviewCount;

    @OneToMany(mappedBy = "movie")
    private List<MovieActor> movieActors = new ArrayList<>();

    @OneToMany(mappedBy = "movie")
    private List<MovieDirector> movieDirectors = new ArrayList<>();

    @OneToMany(mappedBy = "movie")
    private List<AwardToMovie> awardToMovies = new ArrayList<>();

    @Builder
    public Movie(Company company, String title, int viewCount, Country country, String releaseYear, int reviewCount) {
        this.company = company;
        this.title = title;
        this.viewCount = viewCount;
        this.country = country;
        this.reviewCount = reviewCount;
        this.releaseYear = releaseYear;
    }

    public static Movie create(Company company, MovieCreate dto){
        return Movie.builder()
                .company(company)
                .country(dto.getCountry())
                .viewCount(dto.getViewCount())
                .title(dto.getTitle())
                .releaseYear(dto.getReleaseYear())
                .reviewCount(0)
                .build();
    }

    public void modify(MovieModify dto) {
        this.title = dto.getTitle();
        this.country = dto.getCountry();
        this.releaseYear = dto.getReleaseYear();
    }

    public List<String> getActorNames(){
        return this.movieActors.stream().map(ma->ma.getActor().getName())
                .collect(Collectors.toList());
    }

    public List<String> getDirectorNames(){
        return this.movieDirectors.stream().map(md->md.getDirector().getName())
                .collect(Collectors.toList());
    }

    public void increaseReviewCount() {
        this.reviewCount += 1;
    }

    public void addMovieGenres(List<MovieGenre> genres) {
        this.genres.addAll(genres);
    }
}
