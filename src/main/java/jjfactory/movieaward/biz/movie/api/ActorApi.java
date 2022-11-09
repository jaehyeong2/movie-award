package jjfactory.movieaward.biz.movie.api;

import jjfactory.movieaward.biz.movie.dto.req.ActorCreate;
import jjfactory.movieaward.biz.movie.dto.res.ActorDetailRes;
import jjfactory.movieaward.biz.movie.dto.res.ActorRes;
import jjfactory.movieaward.biz.movie.service.ActorService;
import jjfactory.movieaward.global.dto.req.MyPageReq;
import jjfactory.movieaward.global.dto.res.ApiPagingRes;
import jjfactory.movieaward.global.dto.res.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequestMapping("/actors")
@RequiredArgsConstructor
@RestController
public class ActorApi {
    private final ActorService actorService;

    @GetMapping("/{actorId}")
    public ApiResponse<ActorDetailRes> find(@PathVariable Long actorId){
        return new ApiResponse<>(actorService.findActorDetail(actorId));
    }

    @GetMapping
    public ApiPagingRes<ActorRes> findALl(@RequestParam(defaultValue = "1") int page,
                                          @RequestParam(defaultValue = "10") int size){
        return new ApiPagingRes<>(actorService.findActors(new MyPageReq(page,size).of()));
    }

    @PostMapping
    public ApiResponse<Long> save(@Valid @RequestBody ActorCreate dto){
        return new ApiResponse<>(actorService.save(dto));
    }

    @DeleteMapping("/{actorId}")
    public ApiResponse<String> delete(@PathVariable Long actorId){
        return new ApiResponse<>(actorService.delete(actorId));
    }

    @PutMapping("/{actorId}")
    public ApiResponse<String> update(@PathVariable Long actorId){
        return new ApiResponse<>(actorService.updateActorInfo(actorId));
    }

}
