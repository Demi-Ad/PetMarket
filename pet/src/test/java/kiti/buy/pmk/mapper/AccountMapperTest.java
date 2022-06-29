package kiti.buy.pmk.mapper;



import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import kiti.buy.pmk.vo.AccountVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Transactional
public class AccountMapperTest {
	
	@Autowired
	AccountMapper accountMapper;
	
	@Test
	public void duplicateIdTest() {
		AccountVO account = new AccountVO();
		String id = "AAA";
		account.setAccountId(id);
		account.setAccountPassword("AAA");
		account.setAccountEmail("AAA");
		account.setAccountLocation("ASDASD");
		account.setAccountQuestions("QQQ");
		account.setAccountAnswer("QQQ");
		account.setAccountProfilePath(null);
		accountMapper.register(account);
		
		int i = accountMapper.idInUse(id);
		
		Assert.assertEquals(i, 1);
	}

}
