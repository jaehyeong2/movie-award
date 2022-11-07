package jjfactory.movieaward.biz.movie.dto.res;


import jjfactory.movieaward.biz.movie.entity.Company;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class CompanyRes {
    private Long id;
    private String name;
    private String city;

    public CompanyRes(Long id, String name, String city) {
        this.id = id;
        this.name = name;
        this.city = city;
    }

    public CompanyRes(Company company) {
        this.id = company.getId();
        this.name = company.getName();
        this.city = company.getAddress().getCity();
    }
}
