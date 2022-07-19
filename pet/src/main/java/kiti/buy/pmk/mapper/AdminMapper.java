package kiti.buy.pmk.mapper;

import kiti.buy.pmk.dto.admin.AdminLoginDTO;
import kiti.buy.pmk.dto.admin.AdminMemberDTO;
import kiti.buy.pmk.vo.AdminMemberVO;
import kiti.buy.pmk.vo.AdminVO;

public interface AdminMapper {
	AdminVO adminLogin(AdminLoginDTO dto);
	AdminMemberVO adminmemberoutcheck(AdminMemberDTO dto);
}
