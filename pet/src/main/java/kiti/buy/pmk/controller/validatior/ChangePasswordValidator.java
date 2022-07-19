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
            errors.rejectValue("password","password.required","��й�ȣ�� �ʼ� �Դϴ�");
        }

        if (!StringUtils.hasText(dto.getPasswordCheck())) {
            errors.rejectValue("passwordCheck","passwordCheck.required","��й�ȣ Ȯ���� �ʼ� �Դϴ�");
        }

        if (!Objects.equals(dto.getPassword(), dto.getPasswordCheck())) {
            errors.reject("password.not_match","��й�ȣ�� ��ġ���� �ʽ��ϴ�");
        }
    }
}
