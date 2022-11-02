package jjfactory.movieaward.biz.movie.dto.res;

import jjfactory.movieaward.biz.award.entity.Category;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class CategoryRes {

    private String name;

    public CategoryRes(String name) {
        this.name = name;
    }

    public CategoryRes(Category category) {
        this.name = category.getName();
    }
}
