package com.banking_App.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ResourcesNotFoundException.class)
	public ResponseEntity<String> HandleResourcesNotFoundException(ResourcesNotFoundException  ex){
		return new ResponseEntity<String>(ex.getMessage(),HttpStatus.NOT_FOUND);
	}
	
}
