package kiti.buy.pmk.dto.post;

import java.time.LocalDate;

import lombok.Data;

@Data
public class PostCreateDto {
	private String postTitle;
	private String postContent;
	private int postCategory;
}
