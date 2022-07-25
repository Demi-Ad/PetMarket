package kiti.buy.pmk.mapper;

import kiti.buy.pmk.vo.AccountVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;

@Mapper
public interface AccountMapper {
	
	void register(AccountVO account);

	int idInUse(String id);
	
	AccountVO findByAccountId(String id);
	
	int emailInUse(String email);

	AccountVO findByAccountEmail(String email);

	void changePassword(HashMap<String,String> param);

	void changeProfile(HashMap<String,String> param);
}
