package jjfactory.movieaward.biz.movie.dto.req;

import jjfactory.movieaward.global.entity.Address;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class CompanyCreate {
    private String name;
    private String bizNum;
    private Address address;

    @Builder
    public CompanyCreate(String name, String bizNum, Address address) {
        this.name = name;
        this.bizNum = bizNum;
        this.address = address;
    }
}
