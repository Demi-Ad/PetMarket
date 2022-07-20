package kiti.buy.pmk.vo;

import lombok.Data;

import java.time.LocalDate;

@Data
public class PostPageVO {
    private int postSeq;
    private String postTitle;
    private String postContent;
    private String postImgPath;
    private LocalDate postCreatedDate;
    private String accountId;
    private String accountImagePath;
}
