package jjfactory.movieaward.biz.movie.entity.award;

import jjfactory.movieaward.biz.movie.entity.Actor;
import jjfactory.movieaward.global.entity.BaseEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.util.Lazy;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class AwardActor extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "award_id")
    private Award award;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "actor_id")
    private Actor actor;

    @Builder
    public AwardActor(Award award, Actor actor) {
        this.award = award;
        this.actor = actor;
    }
}
