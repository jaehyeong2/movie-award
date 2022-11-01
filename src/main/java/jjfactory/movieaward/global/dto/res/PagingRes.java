package jjfactory.movieaward.global.dto.res;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;

import java.util.List;

@NoArgsConstructor
@Getter
public class PagingRes<T> {
    private Long totalCount;
    private int currentPage;
    private int totalPage;
    private List<T> dataList;

    public PagingRes(Long totalCount, int currentPage, int totalPage, List<T> dataList) {
        this.totalCount = totalCount;
        this.currentPage = currentPage;
        this.totalPage = totalPage;
        this.dataList = dataList;
    }

    public PagingRes(Page<T> page) {
        this.totalCount = page.getTotalElements();
        this.currentPage = page.getPageable().getPageNumber()+1;
        this.totalPage = page.getTotalPages();
        this.dataList = page.getContent();
    }

}
