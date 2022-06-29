package kiti.buy.pmk.service;

import org.springframework.stereotype.Service;

import kiti.buy.pmk.component.EncryptPasswordComponent;
import kiti.buy.pmk.mapper.AccountMapper;
import kiti.buy.pmk.vo.AccountVO;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AccountLoginService {
	private final AccountMapper accountMapper;
	private final EncryptPasswordComponent encryptPasswordComponent;
	
	public AccountVO login(String accountId, String accountPassword) {
		AccountVO account = accountMapper.findByAccountId(accountId);
		
		if (account == null) {
			return null;
		}
		
		boolean isRegisterAccount =  encryptPasswordComponent.isEncrypt(accountPassword, account.getAccountPassword());
		
		if (isRegisterAccount) {
			return account;
		}
		
		return null;
	}
}
