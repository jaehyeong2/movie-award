package jjfactory.movieaward.biz.award.entity;

import jjfactory.movieaward.biz.award.dto.req.AwardCreate;
import jjfactory.movieaward.biz.award.dto.req.AwardModify;
import jjfactory.movieaward.global.entity.BaseEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    @OneToMany(mappedBy = "award")
    private List<AwardToActor> awardToActors = new ArrayList<>();

    @OneToMany(mappedBy = "award")
    private List<AwardToMovie> awardToMovies = new ArrayList<>();

    @OneToMany(mappedBy = "award")
    private List<AwardToDirector> awardToDirectors = new ArrayList<>();

    @Enumerated(EnumType.STRING)
    private WinnerType winnerType;
    @Builder
    public Award(String name, Category category, String awardYear,WinnerType winnerType) {
        this.name = name;
        this.category = category;
        this.awardYear = awardYear;
        this.winnerType = winnerType;
    }

    public static Award create(AwardCreate dto,Category category){
        return Award.builder()
                .category(category)
                .name(dto.getAwardName())
                .awardYear(dto.getAwardYear())
                .winnerType(dto.getWinnerType())
                .build();
    }

    public void modify(AwardModify dto) {
        this.name = dto.getName();
        this.awardYear = dto.getAwardYear();
    }

    public List<String> getWinnerNames(){
        List<String> result = new ArrayList<>();
        switch (winnerType){
            case MOVIE:
                result =  getAwardToMovies().stream()
                        .map(am-> am.getMovie().getTitle())
                        .collect(Collectors.toList());
                break;

            case ACTOR:
                result =  getAwardToActors().stream()
                        .map(aa-> aa.getActor().getName())
                        .collect(Collectors.toList());
                break;

            case DIRECTOR:
                result =  getAwardToDirectors().stream()
                        .map(ad-> ad.getDirector().getName())
                        .collect(Collectors.toList());
                break;
        }
        return result;
    }

}
