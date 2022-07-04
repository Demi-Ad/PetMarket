package kiti.buy.pmk.vo;

import lombok.Getter;

import java.io.Serializable;

@Getter
public class SessionDetail implements Serializable {
	

	private static final long serialVersionUID = 8095560940708808397L;

	private Integer accountSeq;
	private String accountId;
	private String profilePath;
	
	
	public SessionDetail(Integer accountSeq, String accountId, String profilePath) {
		this.accountSeq = accountSeq;
		this.accountId = accountId;
		this.profilePath = profilePath;
	}
	
	
	
}
