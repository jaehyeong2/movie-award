package jjfactory.movieaward.biz.movie.entity;

import jjfactory.movieaward.global.entity.BaseEntity;
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

    @Builder(builderMethodName = "moviePeopleBuilder")
    public MoviePeople(String name) {
        this.name = name;
    }
}
