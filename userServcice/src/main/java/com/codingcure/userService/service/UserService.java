package com.codingcure.userService.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.codingcure.userService.dto.Fund;
import com.codingcure.userService.entity.Account;
import com.codingcure.userService.entity.Investment;
import com.codingcure.userService.entity.User;
import com.codingcure.userService.repositary.UserRepo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class UserService {
	
	@Autowired
	UserRepo userRepo;
	
	@Autowired
	WebClient webClient;
	

	public User saveUserInfo(User user) {
	 User savedUser = userRepo.save(user);
	 return savedUser;
		
	}

	public User createAccount(String userId, Account account) {
		User presentUser = null;
		Optional<User> user = userRepo.findById(Integer.parseInt(userId));
		List<Account> accounts = new ArrayList<>();
		accounts.add(account);
		if (user.isPresent()) {
			presentUser = user.get();
			presentUser.setAccounts(accounts);
		}
		return userRepo.save(presentUser);
		
	}

	public User createAccount(String userId, Investment investment) throws JsonMappingException, JsonProcessingException {
		User presentUser = null;
		List<Investment> listofInvestments = new ArrayList<>();
		listofInvestments.add(investment);
		Optional<User> user = userRepo.findById(Integer.parseInt(userId));
		if (user.isPresent()) {
			
			//call fund service API
			Fund fundInfo = webClient.get()
					.uri("http://localhost:9091/fund/getFundById/"+investment.getFundId())
					.retrieve()
					.bodyToMono(Fund.class)
					.block();
			double unitOfPurchased = investment.getAmount()/fundInfo.getNav();
			investment.setUnitsOfPurchased(unitOfPurchased);
			investment.setCurrentInvestmentValue(unitOfPurchased*fundInfo.getNav());
			presentUser = user.get();
			presentUser.setInvestments(listofInvestments);
		}
		return userRepo.save(presentUser);
	}
	
	

}
