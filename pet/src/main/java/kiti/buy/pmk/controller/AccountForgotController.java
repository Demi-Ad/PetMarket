package kiti.buy.pmk.controller;

import kiti.buy.pmk.dto.account.AccountForgotPasswordDto;
import kiti.buy.pmk.service.AccountForgotService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequiredArgsConstructor
public class AccountForgotController {

    private final AccountForgotService accountForgotService;

    @GetMapping("/forgot")
    public String forgotForm() {
        return "forgot";
    }

    @GetMapping("/forgot/id")
    @ResponseBody
    public HttpEntity<Map<String, String>> findAccountId(@RequestParam("email") String email) {
        Map<String, String> resultMap = new HashMap<>();
        String accountId = accountForgotService.findAccountId(email);

        if (accountId.equals(AccountForgotService.NOT_FOUND)) {
            return ResponseEntity.badRequest().build();
        }

        resultMap.put("result", accountId);
        return ResponseEntity.ok(resultMap);
    }

    @PostMapping("/forgot/password")
    @ResponseBody
    public HttpEntity<?> passwordQuestionAnswer(@RequestBody AccountForgotPasswordDto dto) {
        AccountForgotService.Match match = accountForgotService.accountQuestionAndAnswerMatch(dto);

        switch (match) {
            case MATCH: {
                String tempPassword = accountForgotService.generateTempPassword(dto.getAccountId());

                return ResponseEntity.ok(Map.of("tempPassword", tempPassword));
            }
            case NOT_FOUND_ID:
                return ResponseEntity.badRequest().body(Map.of("message", "존재하지 않는 회원입니다"));
            case MISS_MATCH_QUESTION:
                return ResponseEntity.badRequest().body(Map.of("message", "질문이 올바르지 않습니다"));
            case MISS_MATCH_ANSWER:
                return ResponseEntity.badRequest().body(Map.of("message", "답변이 올바르지 않습니다"));
            default:
                throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
