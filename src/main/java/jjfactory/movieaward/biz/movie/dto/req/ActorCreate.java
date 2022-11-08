package jjfactory.movieaward.biz.movie.dto.req;

import jjfactory.movieaward.global.entity.Country;
import jjfactory.movieaward.global.entity.Gender;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@NoArgsConstructor
@Getter
public class ActorCreate {
    private List<MovieIdAndCastNames> movieIdAndCastNames;
    @NotEmpty
    private String name;
    @NotNull
    private int age;
    @NotNull
    private Gender gender;
    @NotNull
    private Country country;

    public ActorCreate(String name, int age, Gender gender, Country country) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.country = country;
    }

    @NoArgsConstructor
    @Getter
    public static class MovieIdAndCastNames{
        private Long movieId;
        private String castName;
    }
}
