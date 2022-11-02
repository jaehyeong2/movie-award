package jjfactory.movieaward.biz.movie.service;

import jjfactory.movieaward.biz.movie.dto.req.CategoryCreate;
import jjfactory.movieaward.biz.movie.dto.res.CategoryRes;
import jjfactory.movieaward.biz.award.entity.Category;
import jjfactory.movieaward.biz.award.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Transactional
@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;

    @Transactional(readOnly = true)
    public List<CategoryRes> findAll(){
        return categoryRepository.findAll().stream().map(CategoryRes::new)
                .collect(Collectors.toList());
    }

    public String save(CategoryCreate dto){
        Category category = Category.builder()
                .name(dto.getName())
                .build();

        categoryRepository.save(category);
        return "ok";
    }

    public String delete(Long categoryId){
        categoryRepository.deleteById(categoryId);
        return "ok";
    }
}
