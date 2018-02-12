package com.assignment.loyalty.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment.loyalty.converter.InputOutputConverter;
import com.assignment.loyalty.dao.LoyaltyDao;
import com.assignment.loyalty.model.LoyaltyInput;
import com.assignment.loyalty.model.LoyaltyOutput;
import com.assignment.loyalty.service.LoyaltyService;

@Service
public class LoyaltyServiceImpl implements LoyaltyService {
	
	@Autowired
	private LoyaltyDao loyaltyDao;
	
	@Autowired
	private InputOutputConverter converter;


	@Override
	public LoyaltyOutput fetchExistingUserRecord(Long loyaltyId) {
		return loyaltyDao.fetchLoyaltyOutput(loyaltyId);
	}

	@Override
	public void addLoyaltyInput(LoyaltyInput input) {
		if(input==null) {
			return;
		}
		
		LoyaltyOutput output=fetchExistingUserRecord(input.getLoyaltyId());
		if(output==null) {
			output=converter.convertInputToOutput(input);
			loyaltyDao.persistLoyaltyOutput(input.getLoyaltyId(),output);
		}else {
			output=converter.convertInputToOutput(output,input);
			loyaltyDao.updateLoyaltyOutput(input.getLoyaltyId(),output);
		}

	}

	@Override
	public List<LoyaltyInput> fetchLoyaltyInput(int offset, int size) {
		return loyaltyDao.fetchLoyaltyInput(offset, size);
	}

	@Override
	public List<LoyaltyOutput> fetchLoyaltyOutput() {
		return loyaltyDao.fetchLoyaltyOutput();
	}

}
