package kiti.buy.pmk.dto.account;

import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;

import org.springframework.web.multipart.MultipartFile;


import lombok.Data;

/**
 * 
 * @author 박종성
 * @apiNote 회원가입 리퀘스트 객체
 * 
 * 추후 FORM 에서 이름 매치가 필요합니다.
 *
 */
@Data
public class AccountRegisterDto {
	
	
	@Pattern(regexp = "^[a-zA-Z0-9]{3,20}$",message = "아이디는 영문 대소문자 + 숫자 3글자 이상 20글자 이하여야 합니다")
	private String accountId;
	
	@Pattern(regexp = "^[a-zA-Z0-9]{3,20}$",message = "비밀번호는 영문 대소문자 + 숫자 3글자 이상 20글자 이하여야 합니다")
	private String accountPassword;

	@Email
	private String accountEmail;
	
	private String accountLocation;
	private MultipartFile uploadImage;
	private String accountQuestions;
	private String accountAnswer;
}
