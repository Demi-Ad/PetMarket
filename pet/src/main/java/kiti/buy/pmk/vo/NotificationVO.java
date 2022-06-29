package kiti.buy.pmk.vo;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NotificationVO {
	private int notificationSeq;
	private String notificationContent;
	private LocalDate createdDate;
	private LocalDate publishingPeroid;
	
	@Builder
	public NotificationVO(String notificationContent, LocalDate createdDate, LocalDate publishingPeroid) {
		this.notificationContent = notificationContent;
		this.createdDate = createdDate;
		this.publishingPeroid = publishingPeroid;
	}
	
}
