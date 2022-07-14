package kiti.buy.pmk.dto.post;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PostCreateDto {
	private String postTitle;
	private String postContent;
	private int postCategory;
}
