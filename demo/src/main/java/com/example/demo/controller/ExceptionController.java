package com.example.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.demo.controller.exception.NoEntityException;

// 모든 곳에서 이 Handler를 타게 된다.
@ControllerAdvice
public class ExceptionController {
	
//	@ExceptionHandler(NoEntityException.class)
//	public String noEntityHandler() {
//		return "404.html";
//	}
	// or
	@ExceptionHandler(NoEntityException.class)
	public ResponseEntity<Void> noEntityHandler() {
		System.out.println("NOEntity Exception!");
		return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
	}
}
