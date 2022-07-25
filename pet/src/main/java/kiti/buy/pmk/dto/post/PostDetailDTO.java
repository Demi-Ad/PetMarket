package kiti.buy.pmk.dto.post;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PostDetailDTO {
    private String postTitle;
    private String postContent;
    private String postImgPath;
    private int postHit;
    private int postAuthorSeq;
    private LocalDate postCreatedDate;
    private String postAuthorId;
    private String postAuthorProfilePath;
}
