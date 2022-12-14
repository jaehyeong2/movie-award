package jjfactory.movieaward.biz.movie.entity;

import jjfactory.movieaward.global.entity.BaseEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.util.Lazy;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class MovieDirector extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "movie_id")
    private Movie movie;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "director_id")
    private Director director;

    @Builder
    public MovieDirector(Movie movie, Director director) {
        this.movie = movie;
        this.director = director;
    }

    public static MovieDirector create(Movie movie,Director director){
        return MovieDirector.builder()
                .movie(movie)
                .director(director)
                .build();
    }

    public void addToMovie(){
        movie.getMovieDirectors().add(this);
    }

//    public void addToDirectors(){
//        director.get().add(this);
//    }


}
