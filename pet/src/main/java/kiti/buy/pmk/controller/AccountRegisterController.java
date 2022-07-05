package kiti.buy.pmk.controller;

import kiti.buy.pmk.dto.account.AccountRegisterDto;
import kiti.buy.pmk.service.AccountRegisterService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/register")
@RequiredArgsConstructor
@Slf4j
public class AccountRegisterController {

    private final AccountRegisterService accountRegisterService;

    @GetMapping
    public String registerForm() {
        return "register";
    }

    @PostMapping
    public String register(@ModelAttribute @Valid AccountRegisterDto dto, BindingResult bindingResult) {
        log.info("data = {}",dto);
        if (bindingResult.hasErrors()) {
            log.info("valid Fail = {}",bindingResult);
            return "register";
        }
        accountRegisterService.register(dto);
        return "redirect:/";
    }
}
