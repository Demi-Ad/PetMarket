package kiti.buy.pmk.config.interceoptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import kiti.buy.pmk.vo.SessionDetail;

@Component
public class LoginInterceptor implements HandlerInterceptor {
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		
		HttpSession session = request.getSession(false);
		if (session != null && session.getAttribute("sessionDetail") instanceof SessionDetail)
			return true;
		else {
			response.sendRedirect("/"); // TODO : 로그인 페이지로 이동
			return false;
		}
	}

}
