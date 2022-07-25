package kiti.buy.pmk.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import kiti.buy.pmk.dto.admin.AdminLoginDTO;
import kiti.buy.pmk.dto.admin.AdminMemberDTO;
import kiti.buy.pmk.dto.admin.AdminPostListDTO;
import kiti.buy.pmk.service.AdminService;
import kiti.buy.pmk.service.PostService;
import kiti.buy.pmk.vo.AccountVO;
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
	public String dashForm(Model model) {
		return "admin/admindash";
	}
	
	
	@GetMapping("/admin/accountList")
	@ResponseBody
	public HttpEntity<?> accountList() {
		return ResponseEntity.ok(adminService.findAllAccount());
	}
	
	@GetMapping("/admin/delete/{accountSeq}")
	public String deleteAccount(@PathVariable("accountSeq") int accountSeq) {
		adminService.deleteAccount(accountSeq);
		return "redirect:/admin/dash";
	}
	
	
	@GetMapping(value="/admin/postDelete/{postSeq}")
	public String PostDelete(@PathVariable int postSeq){
		adminService.postDelete(postSeq);
		return "redirect:/admin/dash";
	}
	
	@GetMapping("/admin/postList")
	@ResponseBody
	public HttpEntity<?> postList() {
		List<AdminPostListDTO> postList = adminService.postList();
		return ResponseEntity.ok(postList);
	}
	
	@PostMapping("/admin/note")
	@ResponseBody
	public HttpEntity<?> adminNoteCreate(@RequestBody Map<String,Object> data) {
		String text = (String) data.get("text");
		adminService.adminNoteCreate(text);
		return ResponseEntity.ok().build();
	}
	
}
