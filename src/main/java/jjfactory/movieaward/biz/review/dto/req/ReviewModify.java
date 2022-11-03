package jjfactory.movieaward.biz.review.dto.req;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@Getter
public class ReviewModify {
    @NotEmpty
    private String content;
    @NotNull
    private int star;

    public ReviewModify(String content, int star) {
        this.content = content;
        this.star = star;
    }
}
