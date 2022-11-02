package jjfactory.movieaward.biz.movie.entity;

import jjfactory.movieaward.global.entity.BaseEntity;
import jjfactory.movieaward.global.entity.Country;
import jjfactory.movieaward.global.entity.Gender;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class Actor extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @Comment("영화인 코드")
    private MovieCode actorCode;

    private Gender gender;
    private String name;
    private int age;

    @Enumerated(EnumType.STRING)
    private Country country;

    @Builder
    public Actor(MovieCode actorCode, Gender gender, String name, int age, Country country) {
        this.actorCode = actorCode;
        this.gender = gender;
        this.name = name;
        this.age = age;
        this.country = country;
    }
}
