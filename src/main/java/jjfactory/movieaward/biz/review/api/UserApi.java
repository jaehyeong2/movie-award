package jjfactory.movieaward.biz.review.api;

import jjfactory.movieaward.biz.review.dto.req.UserCreate;
import jjfactory.movieaward.biz.review.dto.req.UserModify;
import jjfactory.movieaward.biz.review.service.UserService;
import jjfactory.movieaward.global.dto.res.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;

@RequestMapping("/user")
@RequiredArgsConstructor
@RestController
public class UserApi {
    private final UserService userService;

    @PostMapping
    public ApiResponse<Long> save(@Valid @RequestPart UserCreate dto,
                                  @RequestPart(required = false) MultipartFile image){
        return new ApiResponse<>(userService.join(dto,image));
    }

    @DeleteMapping("/{userId}")
    public ApiResponse<String> withdraw(@PathVariable Long userId){
        return new ApiResponse<>(userService.withdraw(userId));
    }

    @PatchMapping("/{userId}")
    public ApiResponse<String> update(@PathVariable Long userId,
                                      @Valid @RequestBody UserModify dto){
        return new ApiResponse<>(userService.updateInfo(userId,dto));
    }


}
