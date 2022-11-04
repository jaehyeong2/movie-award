package jjfactory.movieaward.biz.movie.dto.res;

import jjfactory.movieaward.biz.movie.entity.Director;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Getter
public class DirectorDetailRes {
    private String name;
    private int age;
    private List<String> movieNames;
    private List<String> awards;
    private String gender;
    private String country;

    public DirectorDetailRes(String name, String gender, String country) {
        this.name = name;
        this.gender = gender;
        this.country = country;
    }

    public DirectorDetailRes(Director director) {
        this.name = director.getName();
        this.age = director.getAge();
        this.movieNames = director.getMovieNames();
        this.awards = director.getAwards();
        this.gender = director.getGender().toString();
        this.country = director.getCountry().toString();
    }
}
