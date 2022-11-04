package jjfactory.movieaward.biz.movie.entity;

import jjfactory.movieaward.global.entity.BaseEntity;
import jjfactory.movieaward.global.entity.Country;
import jjfactory.movieaward.global.entity.Gender;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Inheritance(strategy = InheritanceType.JOINED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class MoviePeople extends BaseEntity {

    @Column(name = "people_code")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long peopleCode;

    private String name;
    private int age;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    @Enumerated(EnumType.STRING)
    private Country country;

    @Builder(builderMethodName = "moviePeopleBuilder")
    public MoviePeople(String name, int age, Gender gender,Country country) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.country = country;
    }
}
