package kiti.buy.pmk.mapper;

import kiti.buy.pmk.vo.AdminNoteVO;

public interface AdminNoteMapper {
	//note기능 -->crud 정의
	void adminNotemessage(String data);
	
	AdminNoteVO showNote();
	
	
}
