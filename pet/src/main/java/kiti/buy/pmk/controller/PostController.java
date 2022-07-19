package kiti.buy.pmk.controller;

import kiti.buy.pmk.service.PostService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
 
@Controller
@Slf4j
@RequiredArgsConstructor
public class PostController {
	private final PostService postService;


	
	@GetMapping("/post/create")
	public String postView() {
		return "postCreate";
	}
}