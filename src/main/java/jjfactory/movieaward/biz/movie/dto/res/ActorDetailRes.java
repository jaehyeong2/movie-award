package jjfactory.movieaward.biz.movie.dto.res;

import jjfactory.movieaward.biz.movie.entity.Actor;
import jjfactory.movieaward.global.entity.Country;
import jjfactory.movieaward.global.entity.Gender;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Getter
public class ActorDetailRes {
    private String name;
    private Country country;
    private int age;
    private Gender gender;
    private List<String> movieNames;
    private List<String> awards;

    public ActorDetailRes(String name, Country country, int age,Gender gender) {
        this.name = name;
        this.country = country;
        this.age = age;
        this.gender = gender;
    }

    public ActorDetailRes(Actor actor) {
        this.name = actor.getName();
        this.country = actor.getCountry();
        this.age = actor.getAge();
        this.gender = actor.getGender();
        this.movieNames = actor.getFilmography();
        this.awards = actor.getAwardNames();
    }
}
