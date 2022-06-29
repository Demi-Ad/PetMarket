package kiti.buy.pmk.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountVO {
	private int accountSeq;
	private String accountId;
	private String accountPassword;
	private String accountEmail;
	private String accountLocation;
	private String accountProfilePath;
	private String accountQuestions;
	private String accountAnswer;
	
	@Builder
	public AccountVO(String accountId, String accountPassword, String accountEmail, String accountLocation,
			String accountProfliePath, String accountQuestions, String accountAnswer) {
		this.accountId = accountId;
		this.accountPassword = accountPassword;
		this.accountEmail = accountEmail;
		this.accountLocation = accountLocation;
		this.accountProfilePath = accountProfliePath;
		this.accountQuestions = accountQuestions;
		this.accountAnswer = accountAnswer;
	}
}
