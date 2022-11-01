package jjfactory.movieaward.biz.movie.dto.res;


import jjfactory.movieaward.biz.movie.entity.Company;
import jjfactory.movieaward.global.entity.Address;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class CompanyDetailRes {
    private String name;
    private String city;
    private String street;
    private String zipCode;

    public CompanyDetailRes(String name, String city, String street, String zipCode) {
        this.name = name;
        this.city = city;
        this.street = street;
        this.zipCode = zipCode;
    }

    public CompanyDetailRes(Company company) {
        this.name = company.getName();
        this.city = company.getAddress().getCity();
        this.street = company.getAddress().getStreet();
        this.zipCode = company.getAddress().getZipCode();
    }
}
