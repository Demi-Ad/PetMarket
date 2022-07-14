package kiti.buy.pmk.service;

import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kiti.buy.pmk.dto.admin.AdminLoginDTO;
import kiti.buy.pmk.dto.admin.AdminMemberDTO;
import kiti.buy.pmk.mapper.AdminMapper;
import kiti.buy.pmk.vo.AccountVO;
import kiti.buy.pmk.vo.AdminVO;
import lombok.RequiredArgsConstructor;

@Service
public class AdminService {
	
	private AdminMapper adminMapper;
	
	
	@Autowired
	public AdminService(AdminMapper adminMapper) {
		this.adminMapper = adminMapper;
	}



	public AdminVO login(AdminLoginDTO dto) {
		
		return adminMapper.adminLogin(dto);
		
	}
	
	
	
	
	
	public void adminMemberOut(AdminMemberDTO dto) throws Exception{
		
	}


}


