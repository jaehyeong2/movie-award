package jjfactory.movieaward.biz.movie.dto.req;

import jjfactory.movieaward.global.entity.Address;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class CompanyModify {
    private String name;
    private Address address;

    @Builder
    public CompanyModify(String name, Address address) {
        this.name = name;
        this.address = address;
    }
}
