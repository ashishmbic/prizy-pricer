package com.AppDirect.jBilling.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidCommandException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	}
