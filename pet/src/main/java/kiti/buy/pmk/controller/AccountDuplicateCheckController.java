package kiti.buy.pmk.controller;

import kiti.buy.pmk.service.AccountRegisterService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolationException;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@RestController
@RequiredArgsConstructor
@RequestMapping("/duplicateCheck")
@Validated
public class AccountDuplicateCheckController {
    private final AccountRegisterService accountRegisterService;


    @GetMapping("/id")
    public HttpEntity<DuplicateCheckResult> duplicateIdCheck(@RequestParam @Pattern(regexp = "^[a-zA-Z0-9]{3,20}$",message = "아이디는 영문 대소문자 + 숫자 3글자 이상 20글자 이하여야 합니다") String value) {
        DuplicateCheckResult result = new DuplicateCheckResult();

        boolean check = accountRegisterService.duplicateIdCheck(value);
        if (check) {
            result.isAspect = false;
            result.message = "이미 가입된 ID 입니다";
        } else {
            result.isAspect = true;
        }
        return ResponseEntity.ok(result);
    }

    @GetMapping("/email")
    public HttpEntity<DuplicateCheckResult> duplicateEmailCheck(@RequestParam @Email(message = "이메일 형식이 아닙니다") @NotEmpty String value) {
        DuplicateCheckResult result = new DuplicateCheckResult();

        boolean check = accountRegisterService.duplicateEmailCheck(value);
        if (check) {
            result.isAspect = false;
            result.message = "이미 가입된 이메일 입니다";
        } else {
            result.isAspect = true;
        }
        return ResponseEntity.ok(result);
    }


    @ExceptionHandler(ConstraintViolationException.class)
    public HttpEntity<DuplicateCheckResult> validFailHandler(ConstraintViolationException e) {
        DuplicateCheckResult result = new DuplicateCheckResult();
        result.isAspect = false;
        result.message = e.getMessage().split(":")[1].trim();
        return ResponseEntity.badRequest().body(result);
    }


    @Data
    public static class DuplicateCheckResult {
        String message;
        Boolean isAspect;
    }


}
