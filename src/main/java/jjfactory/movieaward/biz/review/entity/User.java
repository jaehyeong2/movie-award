package jjfactory.movieaward.biz.review.entity;

import jjfactory.movieaward.biz.review.dto.req.UserCreate;
import jjfactory.movieaward.global.entity.Gender;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String name;
    private String email;
    private String birth;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private String profileImage;

    @Builder
    public User(String username, String name, String email, String birth, Gender gender) {
        this.username = username;
        this.name = name;
        this.email = email;
        this.birth = birth;
        this.gender = gender;
    }

    public static User create(UserCreate dto){
        return User.builder()
                .name(dto.getName())
                .email(dto.getEmail())
                .username(dto.getUsername())
                .birth(dto.getBirth())
                .gender(dto.getGender())
                .build();
    }

    public void addProfileImagePath(String imagePath) {
        this.profileImage = imagePath;
    }
}
