package jjfactory.movieaward.biz.movie.dto.res;

import jjfactory.movieaward.biz.movie.entity.Actor;
import jjfactory.movieaward.global.entity.Country;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Getter
public class ActorRes {
    private Long id;
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
        this.id = actor.getPeopleCode();
        this.name = actor.getName();
        this.country = actor.getCountry();
        this.age = actor.getAge();
        this.movieNames = (actor.getFilmography().size() > 3 ) ? actor.getFilmography().subList(0,3) : actor.getFilmography();
    }
}
