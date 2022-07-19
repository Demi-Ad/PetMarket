package kiti.buy.pmk.service;

import kiti.buy.pmk.component.MultipartImageUploadComponent;
import kiti.buy.pmk.mapper.AccountMapper;
import kiti.buy.pmk.vo.SessionDetail;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;

@Service
@RequiredArgsConstructor
public class AccountInfoChangeService {
    private final AccountMapper accountMapper;
    private final MultipartImageUploadComponent multipartImageUploadComponent;

    public String changeAccountProfile(MultipartFile profile, SessionDetail account) {
        String path = multipartImageUploadComponent.saveImageAndGetPath(profile, MultipartImageUploadComponent.SaveType.PROFILE);
        HashMap<String,String> param = new HashMap<>();

        param.put("profile",path);
        param.put("accountId",account.getAccountId());

        accountMapper.changeProfile(param);

        return path;
    }

    public String changeAccountPassword(String password, String passwordCheck, SessionDetail sessionDetail) {
        return null;
    }
}
