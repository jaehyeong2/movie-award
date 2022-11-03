package jjfactory.movieaward.biz.movie.entity;

import jjfactory.movieaward.global.entity.BaseEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class Director extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    private MovieCode directorCode;

    private String name;

    @Builder
    public Director(MovieCode directorCode, String name) {
        this.directorCode = directorCode;
        this.name = name;
    }
}
