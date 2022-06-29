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
	private LocalDate createdDate;
	private int postHit;
	private int postCategory;
	private int postAuthor;
	
	
	@Builder
	public PostVO(String postTitle, String postContent, LocalDate createdDate, int postCategory, int postAuthor) {
		
		this.postTitle = postTitle;
		this.postContent = postContent;
		this.createdDate = createdDate;
		this.postCategory = postCategory;
		this.postAuthor = postAuthor;
		this.postHit = 0;
	}
	
}
