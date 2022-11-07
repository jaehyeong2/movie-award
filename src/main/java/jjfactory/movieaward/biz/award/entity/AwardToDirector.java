package jjfactory.movieaward.biz.award.entity;

import jjfactory.movieaward.biz.movie.entity.Director;
import jjfactory.movieaward.global.entity.BaseEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.Aware;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class AwardToDirector extends BaseEntity {
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
    public AwardToDirector(Award award, Director director) {
        this.award = award;
        this.director = director;
    }

    public static AwardToDirector create(Director director,Award award){
        return AwardToDirector.builder()
                .award(award)
                .director(director)
                .build();
    }

    public void addDirector(){
        director.getAwardToDirectors().add(this);
    }
}
