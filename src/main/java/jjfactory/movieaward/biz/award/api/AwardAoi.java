package jjfactory.movieaward.biz.award.api;

import jjfactory.movieaward.biz.award.dto.req.AwardCreate;
import jjfactory.movieaward.biz.award.dto.req.AwardModify;
import jjfactory.movieaward.biz.award.dto.res.AwardRes;
import jjfactory.movieaward.biz.award.service.AwardService;
import jjfactory.movieaward.global.dto.req.MyPageReq;
import jjfactory.movieaward.global.dto.res.ApiPagingRes;
import jjfactory.movieaward.global.dto.res.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/award")
@RequiredArgsConstructor
@RestController
public class AwardAoi {
    private final AwardService awardService;

    @GetMapping
    public ApiPagingRes<AwardRes> findAll(@RequestParam(required = false, defaultValue = "1") int page,
                                          @RequestParam(required = false,defaultValue = "10") int size){
        return new ApiPagingRes<>(awardService.findAllAwards(new MyPageReq(page,size).of()));
    }

    @PostMapping
    public ApiResponse<Long> save(@RequestParam Long categoryId,
                                  @RequestBody AwardCreate dto){
        return new ApiResponse<>(awardService.save(categoryId,dto));
    }

    @DeleteMapping("/{awardId}")
    public ApiResponse<String> delete(@PathVariable Long awardId){
        return new ApiResponse<>(awardService.delete(awardId));
    }

    @PutMapping("/{awardId}")
    public ApiResponse<String> modify(@PathVariable Long awardId,
                                      @RequestBody AwardModify dto){
        return new ApiResponse<>(awardService.modify(awardId,dto));
    }
}
