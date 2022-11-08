package jjfactory.movieaward.biz.movie.entity;

import jjfactory.movieaward.biz.award.entity.AwardToActor;
import jjfactory.movieaward.biz.movie.dto.req.ActorCreate;
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

@DiscriminatorValue("A")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class Actor extends MoviePeople {
    @OneToMany(mappedBy = "actor")
    private List<Casting> castings = new ArrayList<>();

    @OneToMany(mappedBy = "actor")
    private List<AwardToActor> awardToActors = new ArrayList<>();
    @Builder
    public Actor(String name, int age, Gender gender, Country country) {
        super(name, age, gender,country);
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
        return castings.stream()
                .map(ma-> ma.getMovie().getTitle())
                .collect(Collectors.toList());
    }

    public List<String> getAwardNames(){
        return awardToActors.stream()
                .map(a-> a.getAward().getName())
                .collect(Collectors.toList());
    }
}
