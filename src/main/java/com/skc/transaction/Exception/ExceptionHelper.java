package com.skc.transaction.Exception;

import javax.servlet.ServletException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.skc.transaction.model.ResponseResultBody;
import com.skc.transaction.utils.Constant;

@ControllerAdvice
public class ExceptionHelper {

	private static final Logger logger = LoggerFactory.getLogger(ExceptionHelper.class);

	@ExceptionHandler(value = { ServiceException.class })
	public @ResponseBody ResponseResultBody serviceException(ServiceException ex) {
		logger.error("Service Exception: ", ex.getMessage());
		return new ResponseResultBody(Constant.FAILED, ex.getCode(), Constant.EMPTY_RESULT, ex.getMessage());
	}

	@ExceptionHandler(value = { javax.servlet.ServletException.class })
	public @ResponseBody ResponseResultBody ServletException(ServletException ex) {
		logger.error("Servlet Exception: ", ex.getMessage());
		return new ResponseResultBody(Constant.FAILED, 500, Constant.EMPTY_RESULT, ex.getMessage());
	}

}
