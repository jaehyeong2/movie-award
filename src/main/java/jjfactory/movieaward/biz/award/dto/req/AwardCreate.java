package jjfactory.movieaward.biz.award.dto.req;

import jjfactory.movieaward.biz.award.entity.WinnerType;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@Getter
public class AwardCreate {
    @NotEmpty
    private String awardName;
    @NotEmpty
    private String awardYear;
    @NotNull
    private WinnerType winnerType;

    private String winnerName;
    public AwardCreate(String awardName, String awardYear, WinnerType winnerType,String winnerName) {
        this.awardName = awardName;
        this.awardYear = awardYear;
        this.winnerType = winnerType;
        this.winnerName = winnerName;
    }
}
