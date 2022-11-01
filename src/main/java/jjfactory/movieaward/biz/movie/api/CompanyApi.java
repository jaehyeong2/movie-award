package jjfactory.movieaward.biz.movie.api;

import jjfactory.movieaward.biz.movie.dto.req.CompanyCreate;
import jjfactory.movieaward.biz.movie.dto.req.CompanyModify;
import jjfactory.movieaward.biz.movie.dto.res.CompanyDetailRes;
import jjfactory.movieaward.biz.movie.dto.res.CompanyRes;
import jjfactory.movieaward.biz.movie.service.CompanyService;
import jjfactory.movieaward.global.dto.res.ApiListResponse;
import jjfactory.movieaward.global.dto.res.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/company")
@RequiredArgsConstructor
@RestController
public class CompanyApi {
    private final CompanyService companyService;

    @GetMapping("/{companyId}")
    public ApiResponse<CompanyDetailRes> get(@PathVariable Long companyId){
        return new ApiResponse<>(companyService.findOne(companyId));
    }

    @GetMapping
    public ApiListResponse<CompanyRes> getAll(){
        return new ApiListResponse<>(companyService.findAll());
    }

    @PostMapping
    public ApiResponse<Long> save(@RequestBody CompanyCreate dto){
        return new ApiResponse<>(companyService.save(dto));
    }

    @DeleteMapping
    public ApiResponse<String> delete(@PathVariable Long companyId){
        return new ApiResponse<>(companyService.delete(companyId));
    }

    @PutMapping
    public ApiResponse<String> update(@PathVariable Long companyId,
                                      @RequestBody CompanyModify dto){
        return new ApiResponse<>(companyService.modify(companyId,dto));
    }

    @PatchMapping
    public ApiResponse<String> modifyBizNum(@PathVariable Long companyId,
                                            @RequestParam String bizNum){
        return new ApiResponse<>(companyService.changeBizNum(companyId,bizNum));
    }
}
