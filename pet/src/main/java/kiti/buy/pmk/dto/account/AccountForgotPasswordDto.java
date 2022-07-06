package kiti.buy.pmk.dto.account;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountForgotPasswordDto {
    private String accountId;
    private String questions;
    private String answer;
}
