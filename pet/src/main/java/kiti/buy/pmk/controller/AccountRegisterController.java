package kiti.buy.pmk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AccountRegisterController {

    @GetMapping("/register")
    public String registerForm() {
        return "register";
    }
}
