package kiti.buy.pmk.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kiti.buy.pmk.service.AdminService;
import kiti.buy.pmk.vo.AdminVO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class AdminController {

	
	private final AdminService adminservice;

	@GetMapping("/admin/login")
	public String adminLoginView() {
		return "admin/admin_login";
	}
	
	

}
