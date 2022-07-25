package kiti.buy.pmk;

import kiti.buy.pmk.component.EncryptPasswordComponent;
import kiti.buy.pmk.dao.SampleDao;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Transactional
@WebAppConfiguration
public class ContextTest {
	
	@Autowired
	SampleDao dao;
	
	@Autowired
	EncryptPasswordComponent encryptPasswordComponent;
	
	@Test
	public void test() {
		System.out.println(dao.sample());
	}
	
	@Test
	public void StringEncryptTest() {
		String s = "AAAA";
		String encrypt =  encryptPasswordComponent.encryptPassword(s);
		System.out.println(encrypt);
		Assert.assertTrue(encryptPasswordComponent.isEncrypt(s, encrypt));
	
	}
}
