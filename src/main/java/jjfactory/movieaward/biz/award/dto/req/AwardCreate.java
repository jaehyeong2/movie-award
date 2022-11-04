package jjfactory.movieaward.biz.award.dto.req;

import jjfactory.movieaward.biz.award.entity.WinnerType;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@NoArgsConstructor
@Getter
public class AwardCreate {
    @NotEmpty
    private String awardName;
    @NotEmpty
    private String awardYear;
    @NotNull
    private WinnerType winnerType;

    private List<String> winnerNames;
    public AwardCreate(String awardName, String awardYear, WinnerType winnerType) {
        this.awardName = awardName;
        this.awardYear = awardYear;
        this.winnerType = winnerType;
    }
}
