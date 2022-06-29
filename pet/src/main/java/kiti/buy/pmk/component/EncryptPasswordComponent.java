package kiti.buy.pmk.component;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 
 * @author ������
 * @apiNote �ܹ��� ��й�ȣ ��ȣȭ ������Ʈ SHA-256 ����
 * @version 1.0
 */
@Component
public class EncryptPasswordComponent {
	
	
	private String saltKey;

	
	@Autowired
	public EncryptPasswordComponent(@Value("${salt.key}") String saltKey) {
		this.saltKey = saltKey;
	}


	public String encryptPassword(String plainPassword) {
		MessageDigest md;
		try {
			md = MessageDigest.getInstance("SHA-256");
			md.update((plainPassword + saltKey).getBytes());
			return byteToHex(md.digest());
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}
		
	}
	

	public boolean isEncrypt(String plainPassword, String encryptPassword) {
		return encryptPassword(plainPassword).equals(encryptPassword);
	}
	
	
	
	private String byteToHex(byte[] bytes) {
		StringBuilder builder = new StringBuilder();
        for (byte b : bytes) {
            builder.append(String.format("%02x", b));
        }
        return builder.toString();
	}
	
	

}
