package kiti.buy.pmk.service;

import kiti.buy.pmk.dto.post.PaginationWrapper;
import kiti.buy.pmk.dto.post.PostSearchCriteria;
import kiti.buy.pmk.mapper.PostMapper;
import kiti.buy.pmk.vo.PostPageVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class PostPagingService {
    private final PostMapper postMapper;


    public PaginationWrapper pagingPost(int pageNum) {
        int countAll = postMapper.countAll();
        int calcPage = calculationLoadPage(pageNum);

        List<PostPageVO> postList = postMapper.listingPage(calcPage);

        return PaginationWrapper.builder()
                .data(postList)
                .currentPage(pageNum)
                .totalCount(countAll)
                .build();
    }

    public PaginationWrapper pagingPost(int pageNum, String categoryName) {
        int categorySeq = matchCategory(categoryName);
        int categoryCount = postMapper.countAllByCategory(categorySeq);
        HashMap<String,Integer> param = new HashMap<>();
        param.put("categorySeq",categorySeq);
        param.put("pageNum",pageNum);
        List<PostPageVO> postList = postMapper.categoryListingPage(param);

        return PaginationWrapper.builder()
                .data(postList)
                .currentPage(pageNum)
                .totalCount(categoryCount)
                .build();
    }

    public PaginationWrapper searchPagingPost(PostSearchCriteria postSearchCriteria) {
        int currentPageNum = postSearchCriteria.getPageNum();
        int i = calculationLoadPage(currentPageNum);
        int countAll = postMapper.countAll();
        postSearchCriteria.setPageNum(i);
        List<PostPageVO> postList = postMapper.searchListingPage(postSearchCriteria);
        return PaginationWrapper.builder()
                .data(postList)
                .currentPage(currentPageNum)
                .totalCount(countAll)
                .build();
    }

    private int calculationLoadPage(int currentPage) {
        if (currentPage == 1) {
            return 0;
        } else {
            int i = currentPage - 1;
            return Integer.parseInt("" + i + 1);
        }
    }

    private int matchCategory(String categoryName) {
        switch (categoryName) {
            case "mammalia":
                return 1;
            case "reptile":
                return 2;
            case "birds":
                return 3;
            default:
                return 4;
        }
    }
}
