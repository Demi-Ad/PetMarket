package kiti.buy.pmk.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NoteVO {
	
	private int noteSeq;
	private int noteSender;
	private int noteRecipient;
	private String noteTitle;
	private String noteContent;
	
	
	public NoteVO(int noteSender, int noteRecipient, String noteTitle, String noteContent) {
		this.noteSender = noteSender;
		this.noteRecipient = noteRecipient;
		this.noteTitle = noteTitle;
		this.noteContent = noteContent;
	}
	
	

}
