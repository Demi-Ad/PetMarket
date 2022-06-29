package kiti.buy.pmk.component;

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

import kiti.buy.pmk.component.MultipartImageUploadComponent.SaveType;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class MultipartImageUploadComponentTest {
	
	@Autowired
	MultipartImageUploadComponent multipartImageUploadComponent;
	
	
	@Test
	public void uploadTest() throws IOException {
		MockMultipartFile mock = getMockMultipartFile("333333", "png", "src/main/webapp/resources/333333.png");
		
		String path = multipartImageUploadComponent.saveImageAndGetPath(mock, SaveType.PROFILE);
		System.out.println(path);
		Assert.assertNotNull(path);
	
		
	}
	
	
	
	private MockMultipartFile getMockMultipartFile(String fileName, String contentType, String path) throws IOException {
	      FileInputStream fileInputStream = new FileInputStream(new File(path));
	      return new MockMultipartFile(fileName, fileName + "." + contentType, "image/" + contentType, fileInputStream);
	  }
}
