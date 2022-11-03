package jjfactory.movieaward.biz.movie.entity;

import jjfactory.movieaward.global.entity.BaseEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@DiscriminatorValue("D")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class Director extends MoviePeople {

    @Builder
    public Director(String name) {
        super(name);
    }
}
