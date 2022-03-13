package com.poc.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.poc.service.WelcomeService;

@RestController
public class WelcomeResource {

	@Autowired
	private WelcomeService welcomeService;
	
	@GetMapping("/welcome")
	public ResponseEntity<String> welcomeMsg() {
		return new ResponseEntity<String>("good morning", HttpStatus.ACCEPTED);

	}
	
	@GetMapping("/greet/{msg}")
	public ResponseEntity<String> greetMsg(@PathVariable String str){
		return new ResponseEntity<String>(welcomeService.welcome(),HttpStatus.ACCEPTED);
	}

}
