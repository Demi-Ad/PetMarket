package kiti.buy.pmk.mapper;

import kiti.buy.pmk.vo.AdminNoteVO;

public interface AdminNoteMapper {
	//note��� -->crud ����
	void adminNotemessage(String data);
	
	AdminNoteVO showNote();
	
	
}
