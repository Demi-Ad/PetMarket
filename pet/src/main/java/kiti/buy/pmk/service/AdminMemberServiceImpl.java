package kiti.buy.pmk.service;

import kiti.buy.pmk.dto.admin.AdminMemberDTO;
import kiti.buy.pmk.mapper.AdminMapper;

public class AdminMemberServiceImpl implements AdminMemberSerivce{
	private AdminMapper admin;
	@Override
	public void adminmemberoutcheck(AdminMemberDTO dto) throws Exception {
		admin.adminmemberoutcheck(dto);
		
	}

}
