package kiti.buy.pmk.dao;

import java.util.List;

import javax.inject.Inject;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import kiti.buy.pmk.dto.admin.AdminMemberDTO;
import kiti.buy.pmk.vo.AccountVO;
import kiti.buy.pmk.vo.AdminMemberVO;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class AdminMemberDAO {
	
	private final SqlSessionTemplate sqlSessionTemplate;
	 

	public void adminMemberOutCheck(int accountSeq) {
		sqlSessionTemplate.delete("kiti.buy.pmk.mapper.AccountMapper.deleteBySeq", accountSeq);
	}
	
	public List<AccountVO> findAll() {
		return sqlSessionTemplate.selectList("kiti.buy.pmk.mapper.AccountMapper.findAll");
	}
}
