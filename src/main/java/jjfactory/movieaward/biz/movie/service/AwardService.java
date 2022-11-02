package jjfactory.movieaward.biz.movie.service;

import jjfactory.movieaward.biz.movie.repository.award.AwardQueryRepository;
import jjfactory.movieaward.biz.movie.repository.award.AwardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@RequiredArgsConstructor
@Service
public class AwardService {
    private final AwardQueryRepository awardQueryRepository;
    private final AwardRepository awardRepository;

}
