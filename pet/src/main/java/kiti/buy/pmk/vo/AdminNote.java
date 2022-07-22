package kiti.buy.pmk.vo;
import lombok.Builder;
import lombok.Data;

@Data

public class AdminNote {
private String data;


@Builder
public AdminNote(String data) {
	this.data=data;
}
}


