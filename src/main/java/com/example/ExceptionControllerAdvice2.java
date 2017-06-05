package com.example;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.stereotype.Controller;

@ControllerAdvice(annotations=Controller.class)
public class ExceptionControllerAdvice2 {
	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> getSQLError(Exception exception){
		HttpHeaders headers = new HttpHeaders();
		headers.set("HeaderKey","HeaderDetails");
		return new ResponseEntity<String>("Manual Exception Thrown for @Controller @@@@@@@",headers,HttpStatus.ACCEPTED);
	}
}