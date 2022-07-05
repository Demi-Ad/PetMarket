package kiti.buy.pmk.controller;

import kiti.buy.pmk.service.AccountRegisterService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

@RestController
@RequiredArgsConstructor
@RequestMapping("/duplicateCheck")
@Validated
public class AccountDuplicateCheckController {
    private final AccountRegisterService accountRegisterService;


    @GetMapping("/id")
    public HttpEntity<DuplicateCheckResult> duplicateIdCheck(@RequestParam @Size(min = 3, max = 20, message = "���̵�� 3���� �̻� 20���� �����Դϴ�") String value) {
        DuplicateCheckResult result = new DuplicateCheckResult();

        boolean check = accountRegisterService.duplicateIdCheck(value);
        if (check) {
            result.isAspect = false;
            result.message = "�̹� ���Ե� ID �Դϴ�";
        } else {
            result.isAspect = true;
        }
        return ResponseEntity.ok(result);
    }

    @GetMapping("/email")
    public HttpEntity<DuplicateCheckResult> duplicateEmailCheck(@RequestParam @Email(message = "�̸��� ������ �ƴմϴ�") String value) {
        DuplicateCheckResult result = new DuplicateCheckResult();

        boolean check = accountRegisterService.duplicateEmailCheck(value);
        if (check) {
            result.isAspect = false;
            result.message = "�̹� ���Ե� �̸��� �Դϴ�";
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
