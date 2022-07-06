package kiti.buy.pmk.service;

import kiti.buy.pmk.component.EncryptPasswordComponent;
import kiti.buy.pmk.dto.account.AccountForgotPasswordDto;
import kiti.buy.pmk.mapper.AccountMapper;
import kiti.buy.pmk.vo.AccountVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class AccountForgotService {
    public static final String NOT_FOUND = "가입하지 않은 회원";
    private final AccountMapper accountMapper;
    private final EncryptPasswordComponent encryptPasswordComponent;

    public String findAccountId(String email) {
        AccountVO account = accountMapper.findByAccountEmail(email);

        if (account == null) {
            return NOT_FOUND;
        }
        return account.getAccountId();
    }



    public String generateTempPassword(String accountId) {
        String generate = tempPasswordGenerate();
        HashMap<String,String> param = new HashMap<>();
        param.put("password",generate);
        param.put("accountId",accountId);
        accountMapper.changePassword(param);
        return generate;
    }

    public Match accountQuestionAndAnswerMatch(AccountForgotPasswordDto dto) {
        AccountVO account = accountMapper.findByAccountId(dto.getAccountId());

        if (account == null) return Match.NOT_FOUND_ID;

        if (account.getAccountQuestions().equals(dto.getQuestions())) {
            if (account.getAccountAnswer().equals(dto.getAnswer())) return Match.MATCH;
            else return Match.MISS_MATCH_ANSWER;
        } else return Match.MISS_MATCH_QUESTION;

    }

    private String tempPasswordGenerate() {
        Random rand = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            int index = rand.nextInt(3);
            switch (index) {
                case 0:
                    sb.append((char) (rand.nextInt(26) + 97));
                    break;
                case 1:
                    sb.append((char) (rand.nextInt(26) + 65));
                    break;
                case 2:
                    sb.append(rand.nextInt(10));
                    break;
            }
        }
        return sb.toString();
    }

    public enum Match {
        NOT_FOUND_ID,MISS_MATCH_QUESTION,MISS_MATCH_ANSWER, MATCH;
    }
}
