package kiti.buy.pmk.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class NoteVO {
	
	private int noteSeq;
	private int noteSender;
	private int noteRecipient;
	private String noteTitle;
	private String noteContent;
	
	@Builder
	public NoteVO(int noteSender, int noteRecipient, String noteTitle, String noteContent) {
		this.noteSender = noteSender;
		this.noteRecipient = noteRecipient;
		this.noteTitle = noteTitle;
		this.noteContent = noteContent;
	}
	
	

}
