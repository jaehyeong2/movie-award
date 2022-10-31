package jjfactory.movieaward.review.entity;

import jjfactory.movieaward.movie.entity.Movie;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class Review {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "reviewer_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Reviewer reviewer;

    @JoinColumn(name = "movie_id")
    @OneToOne(fetch = FetchType.LAZY)
    private Movie movie;

    private String content;

    private int star;

    //TODO soft delete


}
