package com.codingcure.userService.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codingcure.userService.entity.Account;
import com.codingcure.userService.entity.Investment;
import com.codingcure.userService.entity.User;
import com.codingcure.userService.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;


@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserService userService;
	
	
	@GetMapping("/getUserName")
	public String getUserName() {
		return "Hello world";
	}
	
	@PostMapping("/saveUser")
	public ResponseEntity<User> saveUserInfo(@RequestBody User user) {
		 User saveUserInfo = userService.saveUserInfo(user);
		 return new ResponseEntity<>(saveUserInfo, HttpStatus.OK);
	}
	
	@PostMapping("/createAccount/{userId}")
	public ResponseEntity<User> createAccount(@PathVariable String userId, @RequestBody Account account) {
		User user = userService.createAccount(userId, account);
		 return new ResponseEntity<>(user, HttpStatus.OK);
	}
	
	@PostMapping("/createInvestment/{userId}")
	public ResponseEntity<User> createInvestment(@PathVariable String userId, @RequestBody Investment investment) throws JsonMappingException, JsonProcessingException {
		User user = userService.createAccount(userId, investment);
		 return new ResponseEntity<>(user, HttpStatus.OK);
	}


}
