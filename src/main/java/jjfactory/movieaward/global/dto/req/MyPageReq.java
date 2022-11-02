package jjfactory.movieaward.global.dto.req;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.PageRequest;

@Getter
@NoArgsConstructor
public class MyPageReq{
    private int page;
    private int size;

    public MyPageReq(int page, int size) {
        this.page = page;
        this.size = size;
    }

    public PageRequest of(){
        return PageRequest.of(page-1,size);
    }
}
