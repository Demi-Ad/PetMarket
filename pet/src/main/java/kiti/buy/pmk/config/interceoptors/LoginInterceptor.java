package kiti.buy.pmk.config.interceoptors;

import kiti.buy.pmk.vo.SessionDetail;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Component
public class LoginInterceptor implements HandlerInterceptor {
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

		String requestURI = request.getRequestURI();

		String substring = requestURI.substring(requestURI.lastIndexOf("/") + 1);

		if (substring.matches("^\\d$")) {
			return true;
		}

		HttpSession session = request.getSession(false);
		if (session != null && session.getAttribute("sessionDetail") instanceof SessionDetail)
			return true;
		else {
			response.sendRedirect("/login");
			return false;
		}
	}

}
