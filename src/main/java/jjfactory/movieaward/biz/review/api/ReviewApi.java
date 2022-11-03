package jjfactory.movieaward.biz.review.api;

import jjfactory.movieaward.biz.movie.dto.req.MovieCreate;
import jjfactory.movieaward.biz.review.dto.req.ReviewCreate;
import jjfactory.movieaward.biz.review.dto.req.ReviewModify;
import jjfactory.movieaward.biz.review.dto.res.ReviewRes;
import jjfactory.movieaward.biz.review.service.ReviewService;
import jjfactory.movieaward.global.dto.req.MyPageReq;
import jjfactory.movieaward.global.dto.res.ApiPagingRes;
import jjfactory.movieaward.global.dto.res.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class ReviewApi {
    private final ReviewService reviewService;

    @GetMapping("/{userId}")
    public ApiPagingRes<ReviewRes> findMyReviews(@RequestParam(required = false, defaultValue = "1")int page,
                                               @RequestParam(required = false, defaultValue = "10")int size,
                                               @PathVariable Long userId){
        return new ApiPagingRes<>(reviewService.findMyReviews(new MyPageReq(page,size).of(),userId));
    }

    @GetMapping("/{movieId}")
    public ApiPagingRes<ReviewRes> findReviewsByMovieId(@RequestParam(required = false, defaultValue = "1")int page,
                                                 @RequestParam(required = false, defaultValue = "10")int size,
                                                 @PathVariable Long movieId){
        return new ApiPagingRes<>(reviewService.findReviewsByMovieId(new MyPageReq(page,size).of(),movieId));
    }

    @PostMapping
    public ApiResponse<Long> save(@RequestBody ReviewCreate dto){
        return new ApiResponse<>(reviewService.save(dto));
    }

    @DeleteMapping("/{reviewId}")
    public ApiResponse<String> delete(@PathVariable Long reviewId){
        return new ApiResponse<>(reviewService.delete(reviewId));
    }

    @PutMapping("/{reviewId}")
    public ApiResponse<String> modify(@PathVariable Long reviewId,
                                      @RequestBody ReviewModify dto){
        return new ApiResponse<>(reviewService.modify(reviewId,dto));
    }

}
