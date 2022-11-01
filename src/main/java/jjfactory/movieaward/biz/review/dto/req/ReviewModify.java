package jjfactory.movieaward.biz.review.dto.req;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class ReviewModify {
    private String content;
    private int star;

    public ReviewModify(String content, int star) {
        this.content = content;
        this.star = star;
    }
}
