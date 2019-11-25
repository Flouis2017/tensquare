package com.tensquare.base.exception;

import entity.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class BaseExceptionHandler {

	@ExceptionHandler(Exception.class)
	public Result exception(Exception e){
		return Result.fail(e.getMessage());
	}

}
