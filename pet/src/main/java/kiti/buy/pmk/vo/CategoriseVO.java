package kiti.buy.pmk.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoriseVO {
	private int categoriseSeq;
	private String categoriseName;
	
	@Builder
	public CategoriseVO(String categoriseName, int categoriseParent) {
		this.categoriseName = categoriseName;
		this.categoriseParent = categoriseParent;
	}
	private int categoriseParent;
}
