package jjfactory.movieaward.biz.movie.entity.award;

import jjfactory.movieaward.biz.movie.entity.Director;
import jjfactory.movieaward.global.entity.BaseEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class AwardDirector extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "award_id")
    private Award award;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "director_id")
    private Director director;

    @Builder
    public AwardDirector(Award award, Director director) {
        this.award = award;
        this.director = director;
    }
}
