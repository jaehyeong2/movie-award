package jjfactory.movieaward.biz.movie.dto.res;


import jjfactory.movieaward.biz.movie.entity.Company;
import jjfactory.movieaward.global.entity.Address;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Getter
public class CompanyDetailRes {
    private Long id;
    private String name;
    private String city;
    private String street;
    private String zipCode;
    private List<String> movies;

    public CompanyDetailRes(Long id,String name, String city, String street, String zipCode) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.street = street;
        this.zipCode = zipCode;
    }

    public CompanyDetailRes(Company company, List<String> movies) {
        this.id = company.getId();
        this.name = company.getName();
        this.city = company.getAddress().getCity();
        this.street = company.getAddress().getStreet();
        this.zipCode = company.getAddress().getZipCode();
        this.movies = movies;
    }

    public CompanyDetailRes(Company company) {
        this.id = company.getId();
        this.name = company.getName();
        this.city = company.getAddress().getCity();
        this.street = company.getAddress().getStreet();
        this.zipCode = company.getAddress().getZipCode();
    }
}
