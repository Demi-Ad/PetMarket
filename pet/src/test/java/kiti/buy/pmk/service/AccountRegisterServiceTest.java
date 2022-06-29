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

import kiti.buy.pmk.dto.account.AccountRegisterDto;
import kiti.buy.pmk.mapper.AccountMapper;
import kiti.buy.pmk.vo.AccountVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class AccountRegisterServiceTest {
	
	@Autowired
	AccountRegisterService accountRegisterService;
	
	@Autowired
	AccountMapper accountMapper;
	
	
	@Test
	public void registerTest() throws IOException {
		AccountRegisterDto accountRegisterDto = new AccountRegisterDto();
		accountRegisterDto.setAccountId("AQQ");
		accountRegisterDto.setAccountPassword("AAAA");
		accountRegisterDto.setUploadImage(getMockMultipartFile("333333", "png", "src/main/webapp/resources/333333.png"));
		accountRegisterDto.setAccountEmail("AAA@AAA.AAA");
		accountRegisterDto.setAccountQuestions("QQQ");
		accountRegisterDto.setAccountAnswer("WWW");
		accountRegisterDto.setAccountLocation("QWEQWE");
		
		accountRegisterService.register(accountRegisterDto);
		
		
		AccountVO account = accountMapper.findByAccountId("AQQ");
		
		System.out.println(account);
	}
	
	
	
	private MockMultipartFile getMockMultipartFile(String fileName, String contentType, String path) throws IOException {
	      FileInputStream fileInputStream = new FileInputStream(new File(path));
	      return new MockMultipartFile(fileName, fileName + "." + contentType, "image/" + contentType, fileInputStream);
	  }

}
