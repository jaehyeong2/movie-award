package jjfactory.movieaward.biz.review.dto.req;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class ReviewCreate {
    private String content;
    private int star;

    public ReviewCreate(String content, int star) {
        this.content = content;
        this.star = star;
    }
}
