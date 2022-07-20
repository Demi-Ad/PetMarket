package kiti.buy.pmk.controller;

import kiti.buy.pmk.dto.post.PaginationWrapper;
import kiti.buy.pmk.service.PostPagingService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
@Slf4j
public class HomeController {
	
	private final PostPagingService postPagingService;

	@GetMapping("/")
	public String home(Model model, @RequestParam(defaultValue = "1", name = "pageNum") int pageNum) {
		PaginationWrapper paginationWrapper = postPagingService.pagingPost(pageNum);
		log.info("page = {}",paginationWrapper);
		model.addAttribute("pagingData",paginationWrapper);
		return "home";
	}
}
