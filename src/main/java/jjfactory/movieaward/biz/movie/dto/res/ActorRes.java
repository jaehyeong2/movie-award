package jjfactory.movieaward.biz.movie.dto.res;

import jjfactory.movieaward.biz.movie.entity.Actor;
import jjfactory.movieaward.global.entity.Country;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Getter
public class ActorRes {
    private String name;
    private Country country;
    private int age;
    private List<String> movieNames;

    public ActorRes(String name, Country country, int age) {
        this.name = name;
        this.country = country;
        this.age = age;
    }

    public ActorRes(Actor actor) {
        this.name = actor.getName();
        this.country = actor.getCountry();
        this.age = actor.getAge();
        this.movieNames = actor.getFilmographyLimit3();
    }
}
