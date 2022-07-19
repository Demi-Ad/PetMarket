package kiti.buy.pmk.controller;

import kiti.buy.pmk.service.AccountInfoChangeService;
import kiti.buy.pmk.vo.SessionDetail;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequiredArgsConstructor
@Slf4j
public class AccountInfoChangeController {

    private final AccountInfoChangeService accountInfoChangeService;

    @GetMapping("/account/change")
    public String infoChangeForm() {
        return "infoChange";
    }


    @PostMapping("/account/change/password")
    public String passwordChange(@SessionAttribute(name = "sessionDetail") SessionDetail account, @ModelAttribute ChangePasswordDto changePasswordDto) {

        return "";
    }

    @PostMapping("/account/change/profile")
    public String profileChange(MultipartFile profile, @SessionAttribute(name = "sessionDetail") SessionDetail account) {
        String path = accountInfoChangeService.changeAccountProfile(profile, account);
        account.setProfilePath(path);

        return "redirect:/";
    }

    @Getter
    @NoArgsConstructor
    public static class ChangePasswordDto {
        private String password;
        private String passwordCheck;
    }
}
