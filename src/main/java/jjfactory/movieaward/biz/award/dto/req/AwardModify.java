package jjfactory.movieaward.biz.award.dto.req;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class AwardModify {
    private String name;
    private String awardYear;

    public AwardModify(String name, String awardYear) {
        this.name = name;
        this.awardYear = awardYear;
    }
}
