package kiti.buy.pmk.controller;

import kiti.buy.pmk.dto.post.PostCreateDto;
import kiti.buy.pmk.service.PostService;
import kiti.buy.pmk.vo.SessionDetail;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
@Slf4j
@RequiredArgsConstructor
public class PostController {
	private final PostService postService;


	
	@GetMapping("/post/create")
	public String postView() {
		return "postCreate";
	}

	@PostMapping("/post/create")
	public String postCreate(@ModelAttribute PostCreateDto dto, @SessionAttribute SessionDetail sessionDetail) {

		postService.postCreate(dto,sessionDetail.getAccountSeq());
		return "redirect:/";
	}
}