package kiti.buy.pmk.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import kiti.buy.pmk.dto.account.AccountRegisterDto;
import kiti.buy.pmk.mapper.AccountMapper;
import kiti.buy.pmk.vo.AccountVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Transactional
public class AccountLoginServiceTest {
	
	@Autowired
	AccountMapper accountMapper;
	
	@Autowired
	AccountLoginService loginService;
	
	@Autowired
	AccountRegisterService accountRegisterService;
	
	
	@Test
	public void test() throws IOException {
		String userId = "BBBB";
		String pwd = "QQQQ";
		String email = "BBB@BBB.BBB";
		
		AccountRegisterDto accountRegisterDto = new AccountRegisterDto();
		accountRegisterDto.setAccountId(userId);
		accountRegisterDto.setAccountPassword(pwd);
		
		accountRegisterDto.setAccountEmail(email);
		accountRegisterDto.setAccountQuestions("QQQ");
		accountRegisterDto.setAccountAnswer("WWW");
		accountRegisterDto.setAccountLocation("QWEQWE");
		
		accountRegisterService.register(accountRegisterDto);
		
		AccountVO account = loginService.login(userId, pwd);
		
		Assert.assertNotNull(account);
		Assert.assertEquals(account.getAccountEmail(), email);
		
	}
	
	
	private MockMultipartFile getMockMultipartFile(String fileName, String contentType, String path) throws IOException {
	      FileInputStream fileInputStream = new FileInputStream(new File(path));
	      return new MockMultipartFile(fileName, fileName + "." + contentType, "image/" + contentType, fileInputStream);
	  }

}
