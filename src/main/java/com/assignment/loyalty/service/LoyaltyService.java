package com.assignment.loyalty.service;

import java.util.List;

import com.assignment.loyalty.model.LoyaltyInput;
import com.assignment.loyalty.model.LoyaltyOutput;

public interface LoyaltyService {
	
	/**
	 * fetch existing loyalty user detail.
	 * @param loyaltyId
	 * @return
	 */
	public LoyaltyOutput fetchExistingUserRecord(Long loyaltyId);

	/**
	 * adds provided user txn details into loyalty data.
	 * @param input
	 */
	public void addLoyaltyInput(LoyaltyInput input);

	/**
	 * fetch user txn input.
	 * @param offset
	 * @param size
	 * @return
	 */
	public List<LoyaltyInput> fetchLoyaltyInput(int offset, int size);
	
	/**
	 * fetch all loyalty output.
	 * @return
	 */
	public List<LoyaltyOutput> fetchLoyaltyOutput();

}
