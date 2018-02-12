package com.assignment.loyalty.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Repository;

import com.assignment.loyalty.dao.LoyaltyDao;
import com.assignment.loyalty.model.LoyaltyInput;
import com.assignment.loyalty.model.LoyaltyOutput;
import com.assignment.loyalty.util.LoyaltyUtil;

/**
 * repository implementation for CRUD.
 * @author Arjun Agarwal
 *
 * 03-Dec-2017
 */
@Repository
public class LoyaltyDaoImpl implements LoyaltyDao,InitializingBean {
	private Map<Long,Integer> loyaltyIdToIndexMap=new HashMap<>();
	private List<LoyaltyInput> inputList=new ArrayList<>();
	private List<LoyaltyOutput> outputList=new ArrayList<>();

	@Override
	public List<LoyaltyInput> fetchLoyaltyInput(int offset,int size) {
		if(offset<inputList.size() && inputList.size()>=offset+size) {
			return inputList.subList(offset, size);
		}else if(offset<inputList.size()){
			return inputList.subList(offset, inputList.size());
		}
		return null;
	}

	@Override
	public void persistLoyaltyOutput(Long loyaltyId,LoyaltyOutput output) {
		if(loyaltyId!=null) {
			if(loyaltyIdToIndexMap.get(loyaltyId)!=null) {
				System.out.println("loyalty id :"+loyaltyId+" already exist");
			}else {
				outputList.add(output);
				loyaltyIdToIndexMap.put(loyaltyId, outputList.size()-1);
			}
		}else {
			outputList.add(output);
		}
	}

	@Override
	public void updateLoyaltyOutput(Long loyaltyId,LoyaltyOutput output) {
		if(loyaltyId!=null) {
			if(loyaltyIdToIndexMap.get(loyaltyId)!=null) {
				int index=loyaltyIdToIndexMap.get(loyaltyId);
				outputList.set(index, output);
			}else {
				System.out.println("loyalty id :"+loyaltyId+" does not exist");
			}
		}
		
	}

	@Override
	public LoyaltyOutput fetchLoyaltyOutput(Long loyaltyId) {
		if(loyaltyId==null) {
			return null;
		}
		Integer index=loyaltyIdToIndexMap.get(loyaltyId);
		if(index!=null) {
			return outputList.get(index);
		}
		
		return null;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		
		inputList.add(LoyaltyUtil.createInputFromString("Abhay,abhay@demo.com,11001,7402,22-06-2012 11:23,2348723"));
		inputList.add(LoyaltyUtil.createInputFromString("5000,22-06-2012 13:48,3830283"));
		inputList.add(LoyaltyUtil.createInputFromString("Anant,anant@example.com,11002,3839,22-06-2012 15:39,2939303"));
		inputList.add(LoyaltyUtil.createInputFromString("Ashish,ashish@mettl.com,11003,13890,22-06-2012 17:15,2828939"));
		inputList.add(LoyaltyUtil.createInputFromString("11001,12083,23-06-2012 11:38,3839403"));
		inputList.add(LoyaltyUtil.createInputFromString("Abhimanyu,abhi@mettl.com,11004,33283,23-06-2012 14:18,1384839"));
		inputList.add(LoyaltyUtil.createInputFromString("5984,23-06-2012 19:56,8383939"));
		inputList.add(LoyaltyUtil.createInputFromString("11003,38103,24-06-2012 15:38,9388383"));
		inputList.add(LoyaltyUtil.createInputFromString("Anant,anant@mettl.com,11002,7281,24-06-2012 19:18,2938381"));
		inputList.add(LoyaltyUtil.createInputFromString("1038,24-06-2012 20:00,8383383"));
		inputList.add(LoyaltyUtil.createInputFromString("Abhijeet,abhi@mettl.com,11005,17937,25-06-2012 18:53,3833838"));
		
	}
	
	@Override
	public List<LoyaltyOutput> fetchLoyaltyOutput() {
		return outputList;
	}
	
	

}
