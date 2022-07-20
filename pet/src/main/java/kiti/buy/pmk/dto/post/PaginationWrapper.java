package kiti.buy.pmk.dto.post;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
public class PaginationWrapper {

    private final int PAGE_CONTENT_COUNT = 10;
    private final int totalCount;
    private final int currentPage;
    private final List<?> data;
    private int totalPage;
    private int currentStartPage;
    private int currentLastPage;
    private boolean isFirstPage;
    private boolean isLastPage;

    @Builder
    public PaginationWrapper(int totalCount, int currentPage, List<?> data) {
        this.totalCount = totalCount;
        this.currentPage = currentPage;
        this.data = data;
        calculationPagination();
    }

    private void calculationPagination() {
        this.isFirstPage = currentPage == 1; // 이 페이지가 첫번째 페이지 인지 확인
        this.totalPage = ((totalCount - 1) / 10) + 1;// 전체 페이지 갯수
        this.isLastPage = currentPage == totalPage; // 이페이지가 마지막 페이지 인지 확인
        this.currentStartPage = ((currentPage - 1) / 5) * 5 + 1;
        this.currentLastPage = Math.min(currentStartPage + 5 - 1, totalPage);
    }

}
