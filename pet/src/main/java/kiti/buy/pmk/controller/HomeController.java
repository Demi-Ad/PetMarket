package kiti.buy.pmk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import kiti.buy.pmk.dao.SampleDao;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class HomeController {
	
	private final SampleDao sampleDao;

	@GetMapping("/")
	public String home(Model model) {
		model.addAttribute("model",sampleDao.sample());
		model.addAttribute("note", "공지사항");
		return "home";
	}
}
