package jjfactory.movieaward.biz.movie.dto.req;

import jjfactory.movieaward.global.entity.Country;
import jjfactory.movieaward.global.entity.Gender;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class DirectorCreate {
    private String name;
    private int age;
    private Gender gender;
    private Country country;

    public DirectorCreate(String name, int age, Gender gender, Country country) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.country = country;
    }
}
