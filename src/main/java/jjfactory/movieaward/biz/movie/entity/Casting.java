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
public class Casting extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "movie_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Movie movie;

    @JoinColumn(name = "actor_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Actor actor;

    private String roleName;

    @Builder
    public Casting(Movie movie, Actor actor,String name) {
        this.movie = movie;
        this.actor = actor;
        this.roleName = name;
    }

    public static Casting create(Movie movie, Actor actor,String name){
        return Casting.builder()
                .movie(movie)
                .actor(actor)
                .name(name)
                .build();
    }

    public void addToMovie(){
        movie.getCastings().add(this);
    }

    public void addToActor(){
        actor.getCastings().add(this);
    }

}
