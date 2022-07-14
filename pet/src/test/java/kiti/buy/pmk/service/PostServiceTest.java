package kiti.buy.pmk.service;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import kiti.buy.pmk.dto.account.AccountRegisterDto;
import kiti.buy.pmk.dto.post.PostCreateDto;
import kiti.buy.pmk.mapper.AccountMapper;
import kiti.buy.pmk.vo.AccountVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Rollback(true)
@Transactional
public class PostServiceTest {

	@Autowired
	PostService postService;
	
	@Autowired
	AccountRegisterService accountRegisterService;
	
	@Autowired
	AccountMapper accountMapper;
	
	@Test
	public void createTest() {
		AccountRegisterDto accountRegisterDto = new AccountRegisterDto();
		accountRegisterDto.setAccountId("AQQ");
		accountRegisterDto.setAccountPassword("AAAA");
		accountRegisterDto.setAccountEmail("AAA@AAA.AAA");
		accountRegisterDto.setAccountQuestions("QQQ");
		accountRegisterDto.setAccountAnswer("WWW");
		accountRegisterDto.setAccountLocation("QWEQWE");
		
		accountRegisterService.register(accountRegisterDto);
		
		AccountVO account = accountMapper.findByAccountId(accountRegisterDto.getAccountId());
		
		PostCreateDto postCreateDto = new PostCreateDto("TEST", "TEST", 1);
		
		int i = postService.postCreate(postCreateDto, account.getAccountSeq());
		
		Assert.assertNotEquals(i, 0);
		
	}
}
