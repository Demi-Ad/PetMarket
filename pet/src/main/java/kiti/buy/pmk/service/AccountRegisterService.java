package kiti.buy.pmk.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kiti.buy.pmk.component.EncryptPasswordComponent;
import kiti.buy.pmk.component.MultipartImageUploadComponent;
import kiti.buy.pmk.component.MultipartImageUploadComponent.SaveType;
import kiti.buy.pmk.dto.account.AccountRegisterDto;
import kiti.buy.pmk.mapper.AccountMapper;
import kiti.buy.pmk.vo.AccountVO;
import lombok.RequiredArgsConstructor;

/**
 * 
 * @author 박종성
 * @apiNote 회원가입 서비스
 * @version 1.0
 */
@Service
@RequiredArgsConstructor
@Transactional
public class AccountRegisterService {
	
	private final EncryptPasswordComponent encryptPasswordComponent;
	private final MultipartImageUploadComponent multipartImageUploadComponent;
	private final AccountMapper accountMapper;
	
	public void register(AccountRegisterDto dto) {
		String accountId = dto.getAccountId();
		String profilePath =  multipartImageUploadComponent.saveImage(dto.getUploadImage(), SaveType.PROFILE);
		String encryptPassword = encryptPasswordComponent.encryptPassword(dto.getAccountPassword());
		
		AccountVO account = AccountVO.builder()
		.accountId(accountId)
		.accountPassword(encryptPassword)
		.accountProfliePath(profilePath)
		.accountEmail(dto.getAccountEmail())
		.accountLocation(dto.getAccountLocation())
		.accountQuestions(dto.getAccountQuestions())
		.accountAnswer(dto.getAccountAnswer())
		.build();
		
		accountMapper.register(account);
	}
	
	/**
	 * @param accountId
	 * @return true -> 해당값 존재 , false -> 존재하지 않음
	 */
	@Transactional(readOnly = true)
	public boolean duplicateIdCheck(String accountId) {
		return accountMapper.idInUse(accountId) == 1;
	}
	
	@Transactional(readOnly = true)
	public boolean duplicateEmailCheck(String email) {
		return accountMapper.emailInUse(email) == 1;
	}
}
