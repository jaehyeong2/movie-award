package jjfactory.movieaward.biz.movie.dto.req;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CategoryCreate {
    private String name;

    public CategoryCreate(String name) {
        this.name = name;
    }
}
