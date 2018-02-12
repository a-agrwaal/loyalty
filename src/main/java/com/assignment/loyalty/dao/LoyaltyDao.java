package com.assignment.loyalty.dao;

import java.util.List;

import com.assignment.loyalty.model.LoyaltyInput;
import com.assignment.loyalty.model.LoyaltyOutput;

/**
 * DAO interface for Loyalty Prgoram.
 * @author Arjun Agarwal
 *
 * 03-Dec-2017
 */
public interface LoyaltyDao {
	/**
	 * fetch user txn input as a list.
	 * @param offset
	 * @param size
	 * @return
	 */
	public List<LoyaltyInput> fetchLoyaltyInput(int offset, int size);

	/**
	 * persist new loyalty record.
	 * @param loyaltyId
	 * @param output
	 */
	public void persistLoyaltyOutput(Long loyaltyId, LoyaltyOutput output);

	/**
	 * update existing loyalty record.
	 * @param loyaltyId
	 * @param output
	 */
	public void updateLoyaltyOutput(Long loyaltyId, LoyaltyOutput output);

	/**
	 * pull loyalty record
	 * @param loyaltyId
	 * @return
	 */
	public LoyaltyOutput fetchLoyaltyOutput(Long loyaltyId);
	
	/**
	 * fetch all loyalty output.
	 * @return
	 */
	public List<LoyaltyOutput> fetchLoyaltyOutput();

}
