package jjfactory.movieaward.biz.award.dto.res;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Getter
public class AwardRes {
    private String awardName;
    private List<String> winnerName;
    private String awardYear;
    private String winYear;
    private int winnerType;

    public AwardRes(String awardName, String awardYear, String winYear, int winnerType) {
        this.awardName = awardName;
        this.awardYear = awardYear;
        this.winYear = winYear;
        this.winnerType = winnerType;
    }
}
