package kiti.buy.pmk.dto.note;

import lombok.Data;

@Data
public class NoteCreateDTO {
	private String recipientId;
	private String title;
	private String content;
}
