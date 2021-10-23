package com.example.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/")
public class HomeController {
	
	@GetMapping(value = "/home")
	public ResponseEntity<?> home(){
		return ResponseEntity
				.status(HttpStatus.OK)
				.body("oauth Homepage");
	}
}
