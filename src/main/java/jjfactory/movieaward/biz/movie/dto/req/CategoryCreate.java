package jjfactory.movieaward.biz.movie.dto.req;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Getter
@NoArgsConstructor
public class CategoryCreate {
    @NotEmpty
    private String name;

    public CategoryCreate(String name) {
        this.name = name;
    }
}
