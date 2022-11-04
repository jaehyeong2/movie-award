package jjfactory.movieaward.biz.movie.dto.res;

import jjfactory.movieaward.biz.movie.entity.Director;
import jjfactory.movieaward.global.entity.Gender;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Getter
public class DirectorRes {
    private String name;
    private List<String> movieNames;
    private String gender;
    private String country;

    public DirectorRes(String name, String gender, String country) {
        this.name = name;
        this.gender = gender;
        this.country = country;
    }

    public DirectorRes(Director director) {
        this.name = director.getName();
        this.movieNames = director.getMovieNames().subList(0,3);
        this.gender = director.getGender().toString();
        this.country = director.getCountry().toString();
    }
}
