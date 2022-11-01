package jjfactory.movieaward.biz.review.dto.res;

import jjfactory.movieaward.biz.review.entity.Review;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.format.DateTimeFormatter;

@NoArgsConstructor
@Getter
public class ReviewRes {
    private String username;
    private String content;
    private int star;
    private String createDate;

    public ReviewRes(String username, String content, int star, String createDate) {
        this.username = username;
        this.content = content;
        this.star = star;
        this.createDate = createDate;
    }

    public ReviewRes(Review review) {
        this.username = review.getReviewer().getUsername();
        this.content = review.getContent();
        this.star = review.getStar();
        this.createDate = review.getCreateDate()
                .format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss"));
    }
}
