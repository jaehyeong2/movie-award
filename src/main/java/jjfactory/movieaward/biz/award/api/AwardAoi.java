package jjfactory.movieaward.biz.award.api;

import jjfactory.movieaward.biz.award.service.AwardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class AwardAoi {
    private final AwardService awardService;
}
