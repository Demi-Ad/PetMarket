package kiti.buy.pmk.vo;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostVO {
	private int postSeq;
	private String postTitle;
	private String postContent;
	private LocalDate postCreatedDate;
	private int postHit;
	private int postCategory;
	private int postAuthor;
	private String postImgPath;
	
	
	@Builder
	public PostVO(String postTitle, String postContent, int postCategory, int postAuthor, String postImgPath) {
		
		this.postTitle = postTitle;
		this.postContent = postContent;
		this.postCreatedDate = LocalDate.now();
		this.postCategory = postCategory;
		this.postAuthor = postAuthor;
		this.postHit = 0;
		this.postImgPath = postImgPath;
	}
	
}
