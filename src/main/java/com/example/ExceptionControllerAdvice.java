package com.example;

import java.sql.SQLException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice(annotations=RestController.class)
public class ExceptionControllerAdvice {
	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> getSQLError(Exception exception){
		HttpHeaders headers = new HttpHeaders();
		headers.set("HeaderKey","HeaderDetails");
		return new ResponseEntity<String>("Manual Exception Thrown",headers,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(SQLException.class)
	public ResponseEntity<String> getSQLError2(Exception exception){
		HttpHeaders headers = new HttpHeaders();
		headers.set("HeaderKey","HeaderDetailsCVM");
		return new ResponseEntity<String>("Manual SQLException Thrown",headers,HttpStatus.INTERNAL_SERVER_ERROR);
	}
}