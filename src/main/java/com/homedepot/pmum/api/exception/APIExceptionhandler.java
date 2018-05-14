package com.homedepot.pmum.api.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
//[@RestController]
public class APIExceptionhandler {

	//[@ResponseStatus(value = HttpStatus.SERVICE_UNAVAILABLE, reason = "Server encountered problem")]
	@ExceptionHandler(value = FatalException.class)
	public String handleFatalException(FatalException e) {
		return e.getMessage();
	}

	//[@ResponseStatus(value = HttpStatus.UNPROCESSABLE_ENTITY, reason = "Cannot proccess the request")]
	@ExceptionHandler(value = ValidationException.class)
	public String handleValidationException(ValidationException e) {
		return e.getMessage();
	}

	//[@ResponseStatus(value = HttpStatus.UNPROCESSABLE_ENTITY, reason = "Cannot proccess the request")]
	@ExceptionHandler(value = Exception.class)
	public String handleException(Exception e) {
		return e.getMessage();
	}
}
