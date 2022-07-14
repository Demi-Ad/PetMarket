package kiti.buy.pmk.vo;

import lombok.Data;

@Data
public class ResultVO {
	Object result;
	boolean success;
	
	// »ý¼ºÀÚ
	public ResultVO(boolean success, Object result) {
		this.result = result;
		this.success = false;
	}
}
