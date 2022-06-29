package kiti.buy.pmk.vo;

import java.io.Serializable;

import lombok.Getter;

@Getter
public class SessionDetail implements Serializable {
	

	private static final long serialVersionUID = 8095560940708808397L;
	private String accountId;
	private String profilePath;
	
	
	public SessionDetail(String accountId, String profilePath) {
		this.accountId = accountId;
		this.profilePath = profilePath;
	}
	
	
	
}
