package kiti.buy.pmk.component;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import kiti.buy.pmk.exception.MultipartImageUploadException;

/**
 * 
 * @author 박종성
 * @apiNote MultipartFile to Image
 * @version 1.0
 */
@Component
public class MultipartImageUploadComponent {

	private static final String PROFILE_PATH = "D:\\team_upload\\profile";
	private static final String POST_PATH = "D:\\team_upload\\post";
	
	@PostConstruct
	public void init() {
		File root = new File("D:\\team_upload");
		
		if (!root.exists()) {
			root.mkdir();
		}
		
		File profileFolder = new File(PROFILE_PATH);
		if (!profileFolder.exists()) {
			profileFolder.mkdir();
		}
		File postFolder = new File(POST_PATH);
		
		if (!postFolder.exists()) {
			postFolder.mkdir();
		}
	}

	public String saveImageAndGetPath(MultipartFile multipartFile, SaveType saveType) {
		
		if (multipartFile == null || multipartFile.isEmpty()) {
			return null;
		}

		String contentType = multipartFile.getContentType();

		if (contentType.startsWith("image")) {
			String uuid = UUID.randomUUID().toString().replaceAll("-", "");
			String extention = multipartFile.getOriginalFilename().substring(multipartFile.getOriginalFilename().lastIndexOf("."));
			File file = null;
			String imagePath = "";
			StringBuilder sb = new StringBuilder();
			switch (saveType) {
			case PROFILE:
				imagePath = PROFILE_PATH + "\\" + uuid + extention;
				file = new File(imagePath);
				sb.append("profile/").append(uuid).append(extention);
				break;
			case POST:
				imagePath = POST_PATH + "\\" + uuid + extention;
				file = new File(imagePath);
				sb.append("post/").append(uuid).append(extention);
				break;
			}
			try {
				multipartFile.transferTo(file);
				file.deleteOnExit(); // TODO : 추후 삭제 필요
			} catch (IllegalStateException | IOException e) {
				throw new MultipartImageUploadException("IMAGE UPLOAD FAIL",e);
			}
			return sb.toString();

		} else 
			throw new MultipartImageUploadException("This is not Image File");
		
	}
	
	

 	public enum SaveType {
		PROFILE, POST
	}

}
