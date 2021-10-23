package com.example.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/admin")
public class AdminController {

	@GetMapping(value = "/view")
	public ResponseEntity<?> home(){
		return ResponseEntity
				.status(HttpStatus.OK)
				.body("admin view");
	}
	@GetMapping(value = "/delete")
	public ResponseEntity<?> delete(){
		return ResponseEntity
				.status(HttpStatus.OK)
				.body("admin delete");
	}	
}
