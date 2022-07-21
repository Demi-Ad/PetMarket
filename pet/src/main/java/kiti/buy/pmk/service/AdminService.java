package kiti.buy.pmk.service;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kiti.buy.pmk.dao.AdminMemberDAO;
import kiti.buy.pmk.dto.admin.AdminLoginDTO;
import kiti.buy.pmk.dto.admin.AdminPostListDTO;
import kiti.buy.pmk.mapper.AdminMapper;
import kiti.buy.pmk.mapper.PostMapper;
import kiti.buy.pmk.vo.AccountVO;
import kiti.buy.pmk.vo.AdminVO;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class AdminService {
	
	private final AdminMapper adminMapper;
	private final AdminMemberDAO AdminMemberDAO;
	private final PostMapper postMapper;
	
	
	public AdminVO login(AdminLoginDTO dto) {
		return adminMapper.adminLogin(dto);
	}
	
	public void deleteAccount(int accountSeq) {
		AdminMemberDAO.adminMemberOutCheck(accountSeq);
	}
	
	public List<AccountVO> findAllAccount() {
		return AdminMemberDAO.findAll();
	}
	
	public void postDelete(int seq){
		postMapper.postDelete(seq);
	}
	
	public List<AdminPostListDTO> postList() {
		return postMapper.adminPostList();
	}


	
}


