package jjfactory.movieaward.biz.review.entity;

import jjfactory.movieaward.biz.movie.entity.Movie;
import jjfactory.movieaward.biz.review.dto.req.ReviewCreate;
import jjfactory.movieaward.biz.review.dto.req.ReviewModify;
import jjfactory.movieaward.global.entity.BaseEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Table(uniqueConstraints = {
        @UniqueConstraint(
                columnNames = {"reviewer_id","movie_id"}
        )
})
@Entity
public class Review extends BaseEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JoinColumn(name = "reviewer_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private User reviewer;
    @JoinColumn(name = "movie_id")
    @OneToOne(fetch = FetchType.LAZY)
    private Movie movie;
    private String content;
    private int star;

    @Builder
    public Review(User reviewer, Movie movie, String content, int star) {
        this.reviewer = reviewer;
        this.movie = movie;
        this.content = content;
        this.star = star;
    }

    public static Review create(User user, Movie movie, ReviewCreate dto){
        return Review.builder()
                .reviewer(user)
                .movie(movie)
                .content(dto.getContent())
                .star(dto.getStar())
                .build();
    }

    public void modify(ReviewModify dto) {
        this.content = dto.getContent();
        this.star = dto.getStar();
    }
}
