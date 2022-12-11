package com.BikkadIt.PhoneBookApplication.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobleException {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ApiResponse> handleResourceNotFoundException(ResourceNotFoundException e){
	ApiResponse api=new ApiResponse();
	api.setMessage("This Id NotFound in DataBase");
	api.setSuccess(false);
		
	return new ResponseEntity<ApiResponse>(api,HttpStatus.CREATED);
		
	}

}
