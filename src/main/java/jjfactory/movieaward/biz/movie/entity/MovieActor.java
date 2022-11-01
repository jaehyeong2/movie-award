package jjfactory.movieaward.biz.movie.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class MovieActor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @JoinColumn(name = "movie_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Movie movie;

    @JoinColumn(name = "actor_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Actor actor;

    @Builder
    public MovieActor(Movie movie, Actor actor) {
        this.movie = movie;
        this.actor = actor;
    }

    public static MovieActor create(Movie movie,Actor actor){
        return MovieActor.builder()
                .movie(movie)
                .actor(actor)
                .build();
    }
}
