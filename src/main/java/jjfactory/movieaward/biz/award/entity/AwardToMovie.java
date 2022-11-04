package jjfactory.movieaward.biz.award.entity;

import jjfactory.movieaward.biz.movie.entity.Movie;
import jjfactory.movieaward.global.entity.BaseEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class AwardToMovie extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "movie_id")
    private Movie movie;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "award_id")
    private Award award;

    @Builder
    public AwardToMovie(Movie movie, Award award) {
        this.movie = movie;
        this.award = award;
    }

    public static AwardToMovie create(Movie movie,Award award){
        return AwardToMovie.builder()
                .movie(movie)
                .award(award)
                .build();
    }
}
