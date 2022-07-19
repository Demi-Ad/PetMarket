package kiti.buy.pmk.dto.account;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AccountChangePasswordDto {
    private String password;
    private String passwordCheck;
}
