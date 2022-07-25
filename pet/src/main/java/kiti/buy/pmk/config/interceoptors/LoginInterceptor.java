package kiti.buy.pmk.config.interceoptors;

import kiti.buy.pmk.vo.SessionDetail;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Component
@Slf4j
public class LoginInterceptor implements HandlerInterceptor {
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

		String requestURI = request.getRequestURI();
		log.info("uri = {}",requestURI);
		String substring = requestURI.substring(requestURI.lastIndexOf("/") + 1);

		try {
			if (Integer.parseInt(substring) > 0) {
				return true;
			}
		} catch (NumberFormatException ignore) {

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
