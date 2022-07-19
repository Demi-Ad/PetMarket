package kiti.buy.pmk.service;

import kiti.buy.pmk.component.EncryptPasswordComponent;
import kiti.buy.pmk.component.MultipartImageUploadComponent;
import kiti.buy.pmk.mapper.AccountMapper;
import kiti.buy.pmk.vo.SessionDetail;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;

@Service
@RequiredArgsConstructor
@Transactional
public class AccountInfoChangeService {
    private final AccountMapper accountMapper;
    private final MultipartImageUploadComponent multipartImageUploadComponent;

    private final EncryptPasswordComponent encryptPasswordComponent;

    public String changeAccountProfile(MultipartFile profile, SessionDetail account) {
        String path = multipartImageUploadComponent.saveImageAndGetPath(profile, MultipartImageUploadComponent.SaveType.PROFILE);
        HashMap<String,String> param = new HashMap<>();

        param.put("profile",path);
        param.put("accountId",account.getAccountId());

        accountMapper.changeProfile(param);

        return path;
    }

    public void changeAccountPassword(String password, SessionDetail sessionDetail) {
        String accountId = sessionDetail.getAccountId();
        HashMap<String,String> param = new HashMap<>();
        password = encryptPasswordComponent.encryptPassword(password);
        param.put("accountId",accountId);
        param.put("password",password);
        accountMapper.changePassword(param);
    }
}
