package com.zby.config;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MyExceptionHandler {
	@ExceptionHandler
	public void resolveException(Exception ex) {

	}

}
