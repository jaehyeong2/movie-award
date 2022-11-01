package jjfactory.movieaward.biz.movie.dto.res;


import jjfactory.movieaward.biz.movie.entity.Company;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class CompanyRes {
    private String name;
    private String city;

    public CompanyRes(String name, String city) {
        this.name = name;
        this.city = city;
    }

    public CompanyRes(Company company) {
        this.name = company.getName();
        this.city = company.getAddress().getCity();
    }
}
