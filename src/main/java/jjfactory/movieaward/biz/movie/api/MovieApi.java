package jjfactory.movieaward.biz.movie.api;

import jjfactory.movieaward.biz.movie.dto.req.MovieCreate;
import jjfactory.movieaward.biz.movie.dto.req.MovieModify;
import jjfactory.movieaward.biz.movie.dto.res.MovieDetailRes;
import jjfactory.movieaward.biz.movie.dto.res.MovieRes;
import jjfactory.movieaward.biz.movie.service.MovieService;
import jjfactory.movieaward.global.dto.req.MyPageReq;
import jjfactory.movieaward.global.dto.res.ApiPagingRes;
import jjfactory.movieaward.global.dto.res.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequestMapping("/movie")
@RequiredArgsConstructor
@RestController
public class MovieApi {
    private final MovieService movieService;

    @GetMapping("/{movieId}")
    public ApiResponse<MovieDetailRes> find(@PathVariable Long movieId){
        return new ApiResponse<>(movieService.findMovie(movieId));
    }

    @GetMapping
    public ApiPagingRes<MovieRes> findMovies(@RequestParam(required = false, defaultValue = "1") int page,
                                             @RequestParam(required = false,defaultValue = "10") int size,
                                             @RequestParam(required = false) String companyName,
                                             @RequestParam(required = false) String title,
                                             @RequestParam(required = false) String country){
        return new ApiPagingRes<>(movieService.findMovies(new MyPageReq(page,size).of(),companyName,title,country));
    }

    @PostMapping
    public ApiResponse<Long> save(@Valid @RequestBody MovieCreate dto){
        return new ApiResponse<>(movieService.save(dto));
    }

    @DeleteMapping
    public ApiResponse<String> delete(@PathVariable Long movieId){
        return new ApiResponse<>(movieService.delete(movieId));
    }

    @PutMapping
    public ApiResponse<String> modify(@Valid @RequestBody MovieModify dto){
        return new ApiResponse<>(movieService.modify(dto));
    }
}
