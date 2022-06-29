package kiti.buy.pmk.mapper;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class AccountMapperTest {
	
	@Autowired
	AccountMapper accountMapper;
	
	@Test
	public void duplicateIdTest() {
		int i = accountMapper.idInUse("abca");
		Assert.assertEquals(i, 1);
	}

}
