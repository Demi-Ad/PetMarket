package kiti.buy.pmk.dto.note;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class NoteResultDTO implements Serializable {
    private int noteSeq;
    private String noteTitle;
    private String noteContent;
    private String senderId;
}
