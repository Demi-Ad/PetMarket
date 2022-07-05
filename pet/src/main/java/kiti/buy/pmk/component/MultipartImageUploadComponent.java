package kiti.buy.pmk.component;

import kiti.buy.pmk.exception.MultipartImageUploadException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.PostConstruct;
import javax.servlet.ServletContext;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * 
 * @author 박종성
 * @apiNote MultipartFile to Image
 * @version 1.0
 */
@Component
@RequiredArgsConstructor
public class MultipartImageUploadComponent {

	private static final String PROFILE_PATH = "resources/upload/profile";
	private static final String POST_PATH = "resources/upload/post";

	private final ServletContext context;

	@PostConstruct
	public void init() {
		String realPath = context.getRealPath("resources/upload");
		File root = new File(realPath);
		System.out.println(realPath);
		if (!root.exists()) {
			root.mkdir();
		}
		
		File profileFolder = new File(realPath, "profile");
		if (!profileFolder.exists()) {
			profileFolder.mkdir();
		}
		File postFolder = new File(realPath, "post");
		
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
				imagePath = context.getRealPath(PROFILE_PATH) + "\\" + uuid + extention;
				file = new File(imagePath);
				sb.append("profile/").append(uuid).append(extention);
				break;
			case POST:
				imagePath = context.getRealPath(POST_PATH) + "\\" + uuid + extention;
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
