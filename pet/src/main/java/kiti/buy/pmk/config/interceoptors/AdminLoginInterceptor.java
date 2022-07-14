package kiti.buy.pmk.config.interceoptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import kiti.buy.pmk.vo.AdminVO;
import kiti.buy.pmk.vo.SessionDetail;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AdminLoginInterceptor implements HandlerInterceptor {
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		
		HttpSession session = request.getSession(false);
		if (isAdmin(session)) {
			return true;
		} else {
			response.sendRedirect("/admin/login");
			return false;
		}
	}
	
	private boolean isAdmin(HttpSession session) {
		if (session == null)
			return false;
		
		if (session.getAttribute("session_detail") instanceof AdminVO) {
			return true;
		}
		return false;
	}
}
