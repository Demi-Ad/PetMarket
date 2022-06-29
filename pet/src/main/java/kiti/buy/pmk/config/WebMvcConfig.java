package kiti.buy.pmk.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import kiti.buy.pmk.config.interceoptors.LoginInterceptor;
import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class WebMvcConfig extends WebMvcConfigurationSupport {
	
	private final LoginInterceptor loginInterceptor;
	
	@Override
	protected void addInterceptors(InterceptorRegistry registry) {
		
		super.addInterceptors(registry);
	}
	

}
