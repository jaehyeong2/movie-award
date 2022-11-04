package jjfactory.movieaward.biz.movie.api;

import jjfactory.movieaward.biz.movie.dto.req.DirectorCreate;
import jjfactory.movieaward.biz.movie.dto.res.DirectorDetailRes;
import jjfactory.movieaward.biz.movie.dto.res.DirectorRes;
import jjfactory.movieaward.biz.movie.service.DirectorService;
import jjfactory.movieaward.global.dto.req.MyPageReq;
import jjfactory.movieaward.global.dto.res.ApiPagingRes;
import jjfactory.movieaward.global.dto.res.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/directors")
@RequiredArgsConstructor
@RestController
public class DirectorApi {
    private final DirectorService directorService;

    @GetMapping
    public ApiPagingRes<DirectorRes> findAll(@RequestParam(required = false, defaultValue = "1")int page,
                                             @RequestParam(required = false, defaultValue = "10")int size){
        return new ApiPagingRes<>(directorService.findAll(new MyPageReq(page,size).of()));
    }

    @GetMapping("/{directorId}")
    public ApiResponse<DirectorDetailRes> findOne(Long directorId){
        return new ApiResponse<>(directorService.findOne(directorId));
    }

    @PostMapping
    public ApiResponse<Long> save(@RequestBody DirectorCreate dto){
        return new ApiResponse<>(directorService.save(dto));
    }

    @DeleteMapping("/{directorId}")
    public ApiResponse<String> delete(@PathVariable Long directorId){
        return new ApiResponse<>(directorService.delete(directorId));
    }


}
