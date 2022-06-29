package kiti.buy.pmk.mapper;

import org.apache.ibatis.annotations.Mapper;

import kiti.buy.pmk.vo.AccountVO;

@Mapper
public interface AccountMapper {
	
	void register(AccountVO account);

	int idInUse(String id);
	
	AccountVO findByAccountId(String id);
	
	int emailInUse(String email);
}
