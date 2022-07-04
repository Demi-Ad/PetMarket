package kiti.buy.pmk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AccountLoginController {

    @GetMapping("/login")
    public String loginForm() {
        return "login";
    }
}
