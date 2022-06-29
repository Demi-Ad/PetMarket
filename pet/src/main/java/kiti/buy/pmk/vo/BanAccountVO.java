package kiti.buy.pmk.vo;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BanAccountVO {
	private int banSeq;
	private int banAccountSeq;
	private LocalDate banPeroid;
	private String banComment;
	
	@Builder
	public BanAccountVO(int banAccountSeq, LocalDate banPeroid, String banComment) {
		this.banAccountSeq = banAccountSeq;
		this.banPeroid = banPeroid;
		this.banComment = banComment;
	}
}
