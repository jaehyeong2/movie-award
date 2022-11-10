package jjfactory.movieaward.biz.review.dto.res;

import com.fasterxml.jackson.annotation.JsonFormat;
import jjfactory.movieaward.biz.review.entity.Review;
import jjfactory.movieaward.biz.review.entity.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@NoArgsConstructor
@Getter
public class ReviewRes {
    private Long id;
    private String username;
    private String content;
    private int star;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone = "Asia/Seoul")
    private LocalDateTime createDate;

    public ReviewRes(String username, String content, int star, LocalDateTime createDate) {
        this.username = username;
        this.content = content;
        this.star = star;
        this.createDate = createDate;
    }

    public ReviewRes(Review review, User user) {
        this.id = review.getId();
        this.username = user.getUsername();
        this.content = review.getContent();
        this.star = review.getStar();
        this.createDate = review.getCreateDate();
    }
}
