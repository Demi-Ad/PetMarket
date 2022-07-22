package kiti.buy.pmk.advice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
@Slf4j
public class ErrorPageAdvice {
	
	@ExceptionHandler(NoHandlerFoundException.class)
	public ModelAndView notFoundPage(NoHandlerFoundException e) {
		ModelAndView mv = new ModelAndView("error/error404");
		mv.setStatus(HttpStatus.NOT_FOUND);
		return mv;
	}
	
	@ExceptionHandler(Exception.class)
	public ModelAndView errorPage(Exception e) {
		String message = e.getMessage();
		ModelAndView mv =  new ModelAndView("error/error400");
		mv.addObject("error", message);
		mv.setStatus(HttpStatus.BAD_REQUEST);
		log.error("exception = {} error = {}",e.getClass(),message);
		return mv;
	}

}
