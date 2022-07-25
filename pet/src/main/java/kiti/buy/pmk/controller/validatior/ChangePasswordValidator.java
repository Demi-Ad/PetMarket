package kiti.buy.pmk.controller.validatior;

import kiti.buy.pmk.dto.account.AccountChangePasswordDto;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Objects;

public class ChangePasswordValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.isAssignableFrom(AccountChangePasswordDto.class);
    }

    @Override
    public void validate(Object target, Errors errors) {
        AccountChangePasswordDto dto = (AccountChangePasswordDto) target;

        if (!StringUtils.hasText(dto.getPassword())) {
            errors.rejectValue("password","password.required","비밀번호는 필수 입니다");
        }

        if (!StringUtils.hasText(dto.getPasswordCheck())) {
            errors.rejectValue("passwordCheck","passwordCheck.required","비밀번호 확인은 필수 입니다");
        }

        if (!Objects.equals(dto.getPassword(), dto.getPasswordCheck())) {
            errors.reject("password.not_match","비밀번호가 일치하지 않습니다");
        }
    }
}
