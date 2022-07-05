package kiti.buy.pmk.controller;

import kiti.buy.pmk.dto.account.AccountLoginDto;
import kiti.buy.pmk.service.AccountLoginService;
import kiti.buy.pmk.vo.AccountVO;
import kiti.buy.pmk.vo.SessionDetail;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor
public class AccountLoginController {

    private final AccountLoginService loginService;

    @GetMapping("/login")
    public String loginForm() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute AccountLoginDto dto, HttpSession session, RedirectAttributes redirectAttributes) {
        AccountVO login = loginService.login(dto.getId(), dto.getPassword());
        if (login == null) {
            redirectAttributes.addAttribute("message","존재하지 않는 유저이거나 비밀번호가 맞지않습니다");
            return "redirect:/login";
        }
        SessionDetail sessionDetail = new SessionDetail(login.getAccountSeq(), login.getAccountId(), login.getAccountProfilePath());
        session.setAttribute("sessionDetail",sessionDetail);
        return "redirect:/";
    }
}
