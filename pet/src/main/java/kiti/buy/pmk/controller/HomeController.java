package kiti.buy.pmk.controller;

import kiti.buy.pmk.dto.post.PaginationWrapper;
import kiti.buy.pmk.service.AdminService;
import kiti.buy.pmk.dto.post.PostSearchCriteria;
import kiti.buy.pmk.service.PostPagingService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
@Slf4j
public class HomeController {
	
	private final PostPagingService postPagingService;
	private final AdminService adminService;

	@GetMapping("/")
	public String home(Model model, @RequestParam(defaultValue = "1", name = "pageNum") int pageNum) {
		PaginationWrapper paginationWrapper = postPagingService.pagingPost(pageNum);
		log.info("page = {}",paginationWrapper);
		model.addAttribute("note", adminService.showNote());
		model.addAttribute("pagingData",paginationWrapper);
		return "home";
	}

	@GetMapping("/search")
	public String searchHome(Model model, @ModelAttribute PostSearchCriteria postSearchCriteria) {
		PaginationWrapper paginationWrapper = postPagingService.searchPagingPost(postSearchCriteria);
		log.info("search = {}",paginationWrapper);
		model.addAttribute("pagingData",paginationWrapper);
		model.addAttribute("keyword",postSearchCriteria.getKeyword());
		return "search";
	}
}
