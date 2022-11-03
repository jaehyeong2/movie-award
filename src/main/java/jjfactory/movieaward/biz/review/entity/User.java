package jjfactory.movieaward.biz.review.entity;

import jjfactory.movieaward.biz.review.dto.req.UserCreate;
import jjfactory.movieaward.biz.review.dto.req.UserModify;
import jjfactory.movieaward.global.entity.BaseEntity;
import jjfactory.movieaward.global.entity.Gender;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class User extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String name;
    private String email;
    private String birth;
    private boolean activeStatus;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private String profileImage;

    @Builder
    public User(String username, String name, String email, String birth, Gender gender,boolean activeStatus) {
        this.username = username;
        this.name = name;
        this.email = email;
        this.birth = birth;
        this.gender = gender;
        this.activeStatus = activeStatus;
    }

    public static User create(UserCreate dto){
        return User.builder()
                .name(dto.getName())
                .email(dto.getEmail())
                .username(dto.getUsername())
                .birth(dto.getBirth())
                .gender(dto.getGender())
                .activeStatus(true)
                .build();
    }

    public void addProfileImagePath(String imagePath) {
        this.profileImage = imagePath;
    }

    public void changeNameAndEmail(UserModify dto) {
        this.name = dto.getName();
        this.email = dto.getEmail();
    }

    public void withdraw() {
        this.activeStatus = false;
    }
}
