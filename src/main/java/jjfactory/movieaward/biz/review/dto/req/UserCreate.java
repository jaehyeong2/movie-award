package jjfactory.movieaward.biz.review.dto.req;

import jjfactory.movieaward.global.entity.Gender;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class UserCreate {
    private String name;
    private String username;
    private String email;

    private String birth;
    private Gender gender;

    @Builder
    public UserCreate(String name, String username, String email, String birth, Gender gender) {
        this.name = name;
        this.username = username;
        this.email = email;
        this.birth = birth;
        this.gender = gender;
    }
}
