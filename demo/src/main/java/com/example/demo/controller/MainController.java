package com.example.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.JsonTestRequest;

@RestController
public class MainController {
	
	@PostMapping("/test/json")
	public String testMethod(@RequestBody JsonTestRequest req) {
		
		
		return "test success";
	}
	
	@GetMapping("throw")
	public ResponseEntity<Void> noEntityHandler() {
	      System.out.println("NoEntityHandler");
	      return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
	   }
}
