package com.codingcure.fundservice.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingcure.fundservice.entity.Fund;
import com.codingcure.fundservice.repositary.FundRepo;

@Service
public class FundService {
	
	@Autowired
	FundRepo fundRepo;

	public Fund createFund(Fund fund) {
		return fundRepo.save(fund);
		
	}

	public Fund getFund(String fundId) {
		Fund fundInfo = null;
		 Optional<Fund> fund = fundRepo.findById(Integer.parseInt(fundId));
		 if(fund.isPresent()) {
			fundInfo = fund.get();
		 }
		 return fundInfo;
	}

}
