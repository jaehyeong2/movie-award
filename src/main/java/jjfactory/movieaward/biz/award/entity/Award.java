package jjfactory.movieaward.biz.award.entity;

import jjfactory.movieaward.biz.award.dto.req.AwardCreate;
import jjfactory.movieaward.biz.award.dto.req.AwardModify;
import jjfactory.movieaward.global.entity.BaseEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class Award extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @JoinColumn(name = "category_id")
    @OneToOne(fetch = FetchType.LAZY)
    private Category category;

    private String awardYear;

    @Builder
    public Award(String name, Category category, String awardYear) {
        this.name = name;
        this.category = category;
        this.awardYear = awardYear;
    }

    public static Award create(AwardCreate dto,Category category){
        return Award.builder()
                .category(category)
                .name(dto.getName())
                .awardYear(dto.getAwardYear())
                .build();
    }

    public void modify(AwardModify dto) {
        this.name = dto.getName();
        this.awardYear = dto.getAwardYear();
    }

}
