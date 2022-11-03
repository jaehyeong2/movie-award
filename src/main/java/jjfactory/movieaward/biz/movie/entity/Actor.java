package jjfactory.movieaward.biz.movie.entity;

import jjfactory.movieaward.biz.award.entity.AwardToActor;
import jjfactory.movieaward.biz.movie.dto.req.ActorCreate;
import jjfactory.movieaward.global.entity.BaseEntity;
import jjfactory.movieaward.global.entity.Country;
import jjfactory.movieaward.global.entity.Gender;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.Comment;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@DiscriminatorValue("A")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class Actor extends MoviePeople {
    private Gender gender;
    private int age;
    @Enumerated(EnumType.STRING)
    private Country country;

    @OneToMany(mappedBy = "actor")
    private List<MovieActor> movieActors = new ArrayList<>();

    @OneToMany(mappedBy = "actor")
    private List<AwardToActor> awardToActors = new ArrayList<>();

    @Builder
    public Actor(String name, Gender gender, int age, Country country) {
        super(name);
        this.gender = gender;
        this.age = age;
        this.country = country;
    }

    public static Actor create(ActorCreate dto){
        return Actor.builder()
                .name(dto.getName())
                .age(dto.getAge())
                .gender(dto.getGender())
                .country(dto.getCountry())
                .build();
    }

    public List<String> getFilmography(){
        return movieActors.stream()
                .map(ma-> ma.getMovie().getTitle())
                .collect(Collectors.toList());
    }

    public List<String> getFilmographyLimit3(){
        return movieActors.stream()
                .map(ma-> ma.getMovie().getTitle())
                .limit(3L)
                .collect(Collectors.toList());
    }

    public List<String> getAwardNames(){
        return awardToActors.stream()
                .map(a-> a.getAward().getName())
                .collect(Collectors.toList());
    }
}
