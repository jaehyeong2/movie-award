package jjfactory.movieaward.biz.review.dto.req;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@Getter
public class ReviewCreate {
    @NotNull
    private Long userId;
    @NotNull
    private Long movieId;
    @NotEmpty
    private String content;
    @NotNull
    private int star;

    public ReviewCreate(String content, int star) {
        this.content = content;
        this.star = star;
    }
}
