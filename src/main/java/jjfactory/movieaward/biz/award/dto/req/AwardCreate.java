package jjfactory.movieaward.biz.award.dto.req;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@NoArgsConstructor
@Getter
public class AwardCreate {
    @NotEmpty
    private String name;
    @NotEmpty
    private String awardYear;

    public AwardCreate(String name, String awardYear) {
        this.name = name;
        this.awardYear = awardYear;
    }
}
