package jjfactory.movieaward.biz.movie.dto.req;

import lombok.*;

@Getter
public class SearchModel {
    private String title;
    private String companyName;
    private String country;

    public SearchModel(String title, String companyName, String country) {
        this.title = title;
        this.companyName = companyName;
        this.country = country;
    }
}
