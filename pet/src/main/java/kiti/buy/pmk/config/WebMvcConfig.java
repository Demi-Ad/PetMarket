package kiti.buy.pmk.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import kiti.buy.pmk.config.interceoptors.AdminLoginInterceptor;
import kiti.buy.pmk.config.interceoptors.LoginInterceptor;
import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class WebMvcConfig extends WebMvcConfigurationSupport {
	
	private final LoginInterceptor loginInterceptor;
	private final AdminLoginInterceptor adminLoginInterceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		
		registry.addInterceptor(adminLoginInterceptor)
		.excludePathPatterns("/admin/login")
		.addPathPatterns("/admin/**");
	}
	

}
