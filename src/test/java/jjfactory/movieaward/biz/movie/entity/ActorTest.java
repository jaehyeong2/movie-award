package jjfactory.movieaward.biz.movie.entity;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ActorTest {

    @Test
    void getFilmographyLimit3() {
        Movie movie1 = Movie.builder().title("1").build();
        Movie movie2 = Movie.builder().title("1").build();
        Movie movie3 = Movie.builder().title("1").build();
        Movie movie4 = Movie.builder().title("1").build();

        Actor lee = Actor.builder().name("lee").build();

        MovieActor movieActor1 = MovieActor.create(movie1, lee);
        MovieActor movieActor2 = MovieActor.create(movie2, lee);
        MovieActor movieActor3 = MovieActor.create(movie3, lee);
        MovieActor movieActor4 = MovieActor.create(movie4, lee);

        movieActor1.addToActor();
        movieActor2.addToActor();
        movieActor3.addToActor();
        movieActor4.addToActor();

        List<String> list = lee.getFilmographyLimit3();
        Assertions.assertThat(list.size()).isEqualTo(3);
    }
}