package kiti.buy.pmk.mapper;

import org.apache.ibatis.annotations.Mapper;

import kiti.buy.pmk.vo.NoteVO;

@Mapper
public interface NoteMapper {
	void writeNote(NoteVO note);
}
