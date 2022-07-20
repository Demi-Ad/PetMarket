package kiti.buy.pmk.config.interceoptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.HandlerInterceptor;

import com.mysql.cj.Session;

import kiti.buy.pmk.service.IPCacheService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Transactional
public class IPInterceptor implements HandlerInterceptor{
	
	private final IPCacheService ipCacheService;
	
	
	private int id;
	private String ip;
	private float time;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		String clientIp = request.getRemoteAddr();
		if(!ipCacheService.isCacheing(clientIp)) {
			HttpSession Session = request.getSession();// DB ÀÛ¾÷
			ipCacheService.putIp(clientIp);
		}
		
		return true;
	}
}
