package kiti.buy.pmk.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import kiti.buy.pmk.dto.admin.AdminLoginDTO;
import kiti.buy.pmk.dto.admin.AdminMemberDTO;

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

	private final AdminService adminService;

	@GetMapping("/admin/login")
	public String adminLoginView() {
		return "admin/admin_login";
	}

	@PostMapping("/admin/login")
	public String adminLogin(@ModelAttribute AdminLoginDTO dto, HttpSession session) {
		 AdminVO admin = adminService.login(dto);
		 if (admin == null) {
			 return "admin/admin_login";
		 }
		 
		 session.setAttribute("session_detail", admin);
		 
		 return "redirect:/admin/dash";
	}
	
	@GetMapping("/admin/dash")
	public String dashForm() {
		return "admin/admindash";
	}
	
	
	
	

}

