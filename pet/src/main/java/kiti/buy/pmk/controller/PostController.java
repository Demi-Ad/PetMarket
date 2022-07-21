package kiti.buy.pmk.controller;

import kiti.buy.pmk.dto.post.PaginationWrapper;
import kiti.buy.pmk.dto.post.PostCreateDto;
import kiti.buy.pmk.dto.post.PostDetailDTO;
import kiti.buy.pmk.service.PostPagingService;
import kiti.buy.pmk.service.PostService;
import kiti.buy.pmk.vo.PostVO;
import kiti.buy.pmk.vo.SessionDetail;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@Controller
@Slf4j
@RequiredArgsConstructor
public class PostController {
	private final PostService postService;
	private final PostPagingService postPagingService;

	
	@GetMapping("/post/create")
	public String postView() {
		return "postCreate";
	}

	@PostMapping("/post/create")
	public String postCreate(@ModelAttribute PostCreateDto dto, @SessionAttribute SessionDetail sessionDetail) {

		postService.postCreate(dto,sessionDetail.getAccountSeq());
		return "redirect:/";
		
		
	}

	@GetMapping("/post/category/{categoryName}")
	public String category(@PathVariable String categoryName, @RequestParam(defaultValue = "1") int pageNum, Model model) {
		PaginationWrapper paginationWrapper = postPagingService.pagingPost(pageNum, categoryName);
		model.addAttribute("pagingData",paginationWrapper);
		return "home";
	}

	@GetMapping("/post/{postSeq}")
	public String postDetail(@PathVariable int postSeq, Model model) {
		PostDetailDTO postDetailDTO = postService.postDetail(postSeq);
		log.info("postDetail = {}",postDetailDTO);
		model.addAttribute("detail",postDetailDTO);
		return "postDetail";
	}

	@PostMapping("/post/delete/{postSeq}")
	public String postDelete(@PathVariable int postSeq, @SessionAttribute(required = false) SessionDetail sessionDetail) {
		isLoginAccount(sessionDetail);
		postService.postDelete(postSeq,sessionDetail.getAccountSeq());
		return "redirect:/";
	}

	@GetMapping("/post/edit/{postSeq}")
	public String postEdit(@PathVariable int postSeq, @SessionAttribute(required = false) SessionDetail sessionDetail, Model model) {
		isLoginAccount(sessionDetail);
		PostVO post = postService.postEditData(postSeq, sessionDetail.getAccountSeq());
		model.addAttribute("post",post);
		return "postEdit";
	}

	@PostMapping("/post/edit/{postSeq}")
	public String postEdit(@PathVariable int postSeq, @ModelAttribute("post") PostVO post, @SessionAttribute SessionDetail sessionDetail) {
		isLoginAccount(sessionDetail);
		postService.postEdit(post);
		return "redirect:/post/{postSeq}";
	}

	private void isLoginAccount(SessionDetail sessionDetail) {
		if (sessionDetail == null) {
			throw new ResponseStatusException(HttpStatus.UNAUTHORIZED,"로그인 되지않은 사용자");
		}
	}
}