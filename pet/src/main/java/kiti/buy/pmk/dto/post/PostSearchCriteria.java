package kiti.buy.pmk.dto.post;

import lombok.Data;

@Data
public class PostSearchCriteria {
    private int pageNum = 1;
    private String keyword;
}
