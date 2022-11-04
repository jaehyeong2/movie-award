package jjfactory.movieaward.biz.movie.entity;

import jjfactory.movieaward.biz.award.entity.AwardToDirector;
import jjfactory.movieaward.biz.movie.dto.req.DirectorCreate;
import jjfactory.movieaward.global.entity.BaseEntity;
import jjfactory.movieaward.global.entity.Country;
import jjfactory.movieaward.global.entity.Gender;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@DiscriminatorValue("D")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class Director extends MoviePeople {
    @OneToMany(mappedBy = "director")
    private List<AwardToDirector> awardToDirectors = new ArrayList<>();

    @OneToMany(mappedBy = "director")
    private List<MovieDirector> movieDirectors = new ArrayList<>();

    @Builder
    public Director(String name, int age, Gender gender, Country country) {
        super(name, age, gender, country);
    }

    public static Director create(DirectorCreate dto){
        return Director.builder()
                .name(dto.getName())
                .age(dto.getAge())
                .country(dto.getCountry())
                .gender(dto.getGender())
                .build();
    }

    public List<String> getAwards(){
        return awardToDirectors.stream()
                .map(ad-> ad.getAward().getName())
                .collect(Collectors.toList());
    }

    public List<String> getMovieNames(){
        return movieDirectors.stream()
                .map(md-> md.getMovie().getTitle())
                .collect(Collectors.toList());
    }

    public List<String> getMovieNamesLimit3(){
        return movieDirectors.stream()
                .map(md-> md.getMovie().getTitle())
                .limit(3)
                .collect(Collectors.toList());
    }
}
