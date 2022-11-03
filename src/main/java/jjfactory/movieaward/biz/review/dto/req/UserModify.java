package jjfactory.movieaward.biz.review.dto.req;

import jjfactory.movieaward.global.entity.Gender;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class UserModify {
    private String name;
    private String email;

    @Builder
    public UserModify(String name, String email) {
        this.name = name;
        this.email = email;
    }
}
