package kiti.buy.pmk.dto.account;

import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;

import org.springframework.web.multipart.MultipartFile;


import lombok.Data;

/**
 * 
 * @author ������
 * @apiNote ȸ������ ������Ʈ ��ü
 * 
 * ���� FORM ���� �̸� ��ġ�� �ʿ��մϴ�.
 *
 */
@Data
public class AccountRegisterDto {
	
	
	@Pattern(regexp = "^[a-zA-Z0-9]{3,20}$",message = "���̵�� ���� ��ҹ��� + ���� 3���� �̻� 20���� ���Ͽ��� �մϴ�")
	private String accountId;
	
	@Pattern(regexp = "^[a-zA-Z0-9]{3,20}$",message = "��й�ȣ�� ���� ��ҹ��� + ���� 3���� �̻� 20���� ���Ͽ��� �մϴ�")
	private String accountPassword;

	@Email
	private String accountEmail;
	
	private String accountLocation;
	private MultipartFile uploadImage;
	private String accountQuestions;
	private String accountAnswer;
}
