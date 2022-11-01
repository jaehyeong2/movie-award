package jjfactory.movieaward.biz.movie.entity;


import jjfactory.movieaward.biz.movie.dto.req.CompanyCreate;
import jjfactory.movieaward.biz.movie.dto.req.CompanyModify;
import jjfactory.movieaward.global.entity.Address;
import jjfactory.movieaward.global.entity.BaseEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class Company extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    @Column(unique = true)
    @Comment("사업자 번호")
    private String bizNum;

    @Embedded
    private Address address;

    @Builder
    public Company(String name, String bizNum, Address address) {
        this.name = name;
        this.bizNum = bizNum;
        this.address = address;
    }

    public static Company create(CompanyCreate dto){
        return Company.builder()
                .name(dto.getName())
                .bizNum(dto.getBizNum())
                .address(dto.getAddress())
                .build();
    }

    public void changeBizNum(String bizNum) {
        this.bizNum = bizNum;
    }

    public void modify(CompanyModify dto) {
        this.name = dto.getName();
        this.address = dto.getAddress();
    }
}
