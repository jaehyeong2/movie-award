package jjfactory.movieaward.biz.award.dto.res;

import jjfactory.movieaward.biz.award.entity.Award;
import jjfactory.movieaward.biz.award.entity.Category;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Getter
public class AwardRes {
    private Long id;
    private String awardName;
    private List<String> winnerName;
    private String winYear;
    private String awardCategory;

    public AwardRes(String awardName, String winYear, String awardCategory) {
        this.awardName = awardName;
        this.winYear = winYear;
        this.awardCategory = awardCategory;
    }

    public AwardRes(Award award, Category category) {
        this.id = award.getId();
        this.awardName = award.getName();
        this.winnerName = award.getWinnerNames();
        this.winYear = award.getAwardYear();
        this.awardCategory = category.getName();
    }
}
