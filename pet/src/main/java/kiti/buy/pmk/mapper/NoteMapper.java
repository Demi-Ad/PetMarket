package kiti.buy.pmk.mapper;

import kiti.buy.pmk.dto.note.NoteResultDTO;
import kiti.buy.pmk.vo.NoteVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface NoteMapper {
	void writeNote(NoteVO note);

	List<NoteResultDTO> findAllNote(int accountSeq);

	NoteVO findBySeq(int noteSeq);

	void deleteNote(int noteSeq);
}
