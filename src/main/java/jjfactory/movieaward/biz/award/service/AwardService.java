package jjfactory.movieaward.biz.award.service;

import jjfactory.movieaward.biz.award.repository.AwardQueryRepository;
import jjfactory.movieaward.biz.award.repository.AwardRepository;
import jjfactory.movieaward.biz.award.repository.CategoryRepository;
import jjfactory.movieaward.biz.award.dto.req.AwardCreate;
import jjfactory.movieaward.biz.award.dto.req.AwardModify;
import jjfactory.movieaward.biz.award.entity.Award;
import jjfactory.movieaward.biz.award.entity.Category;
import jjfactory.movieaward.global.util.DbUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@RequiredArgsConstructor
@Service
public class AwardService {
    private final AwardQueryRepository awardQueryRepository;
    private final AwardRepository awardRepository;
    private final CategoryRepository categoryRepository;

    @Transactional(readOnly = true)
    public void findOne(){

    }

    @Transactional(readOnly = true)
    public void findAll(){

    }

    public Long save(Long categoryId, AwardCreate dto){
        Category category = DbUtils.getOrThrow(categoryRepository, categoryId);
        Award award = Award.create(dto, category);
        awardRepository.save(award);
        return award.getId();
    }

    public String delete(Long awardId){
        awardRepository.deleteById(awardId);
        return "ok";
    }

    public String modify(Long awardId, AwardModify dto){
        Award award = DbUtils.getOrThrow(awardRepository, awardId);
        award.modify(dto);
        return "ok";
    }

}
