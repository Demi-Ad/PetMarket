package kiti.buy.pmk.vo;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReportVO {
	private int reportSeq;
	private int repoertingAccount;
	private int reportedAccount;
	private LocalDateTime reportingDatetime;
	
	@Builder
	public ReportVO(int repoertingAccount, int reportedAccount, LocalDateTime reportingDatetime) {
		
		this.repoertingAccount = repoertingAccount;
		this.reportedAccount = reportedAccount;
		this.reportingDatetime = reportingDatetime;
	}
}
