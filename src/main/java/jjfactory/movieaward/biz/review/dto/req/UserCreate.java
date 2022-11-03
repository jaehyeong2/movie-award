package jjfactory.movieaward.biz.review.dto.req;

import jjfactory.movieaward.global.entity.Gender;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@Getter
public class UserCreate {
    @NotEmpty
    private String name;
    @NotEmpty
    private String username;
    @NotEmpty
    private String email;
    @NotEmpty
    private String birth;
    @NotNull
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
