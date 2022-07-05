package kiti.buy.pmk.mapper;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import kiti.buy.pmk.vo.AccountVO;
import kiti.buy.pmk.vo.PostVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Transactional
public class PostMapperTest {
	
	@Autowired
	PostMapper postMapper;
	
	@Autowired
	AccountMapper accountMapper;
	
	@Test
	public void postInsertTest() {
		AccountVO account = new AccountVO();
		String id = "CCC";
		account.setAccountId(id);
		account.setAccountPassword("AAA");
		account.setAccountEmail("CCC");
		account.setAccountLocation("ASDASD");
		account.setAccountQuestions("QQQ");
		account.setAccountAnswer("QQQ");
		account.setAccountProfilePath(null);
		accountMapper.register(account);
		
		PostVO post = PostVO.builder()
		.postTitle("TEST")
		.postContent("test")
		.postCategory(1)
		.postAuthor(account.getAccountSeq())
		.build();
		
		postMapper.writePost(post);
		Assert.assertNotEquals(post.getPostSeq(), 0);
		
	}

}
