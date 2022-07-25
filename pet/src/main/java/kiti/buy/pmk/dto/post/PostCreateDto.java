package kiti.buy.pmk.dto.post;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
@AllArgsConstructor
public class PostCreateDto {
	private String postTitle;
	private String postContent;
	private Integer postCategory;
	private MultipartFile postImg;
}
