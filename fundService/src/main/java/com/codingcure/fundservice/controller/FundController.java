package com.codingcure.fundservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codingcure.fundservice.entity.Fund;
import com.codingcure.fundservice.service.FundService;

@RestController
@RequestMapping("/fund")
public class FundController {
	
	@Autowired
	FundService fundService;
	
	@PostMapping("/createFund")
	public ResponseEntity<Fund> createFund(@RequestBody Fund fund) {
		Fund savedFund = fundService.createFund(fund);
		return new ResponseEntity<>(savedFund, HttpStatus.OK);
	}
	
	@GetMapping("/getFundById/{fundId}")
	public ResponseEntity<Fund> getFund(@PathVariable String fundId) {
		Fund savedFund = fundService.getFund(fundId);
		return new ResponseEntity<>(savedFund, HttpStatus.OK);
	}

}
