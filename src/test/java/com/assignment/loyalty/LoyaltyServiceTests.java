package com.assignment.loyalty;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.assignment.loyalty.model.LoyaltyInput;
import com.assignment.loyalty.model.LoyaltyOutput;
import com.assignment.loyalty.service.LoyaltyService;
import com.assignment.loyalty.util.LoyaltyUtil;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LoyaltyServiceTests {

	@Autowired
	private LoyaltyService loyaltyService;
	
	@Test
	public void fetchLoyaltyInput() {
		List<LoyaltyInput> inputList=loyaltyService.fetchLoyaltyInput(0, 1);
		Assert.assertNotNull(inputList);
		Assert.assertTrue(inputList.size()==1);
		
		inputList=loyaltyService.fetchLoyaltyInput(0, 100);
		Assert.assertNotNull(inputList);
		
	}
	
	@Test
	public void addLoyaltyInput() {
		//scenario-1 : persist loyalty
		LoyaltyInput input=LoyaltyUtil.createInputFromString("Abhay,abhay@demo.com,11001,7402,22-06-2012 11:23,2348723");
		loyaltyService.addLoyaltyInput(input);
		LoyaltyOutput output=loyaltyService.fetchExistingUserRecord(11001l);
		Assert.assertNotNull(output);
		Assert.assertTrue(output.getName().equals("Abhay"));
		
		//scenario-2: update loyalty
		input=LoyaltyUtil.createInputFromString("Vinod,abhay@demo.com,11001,7402,22-06-2012 11:23,2348723");
		loyaltyService.addLoyaltyInput(input);
		output=loyaltyService.fetchExistingUserRecord(11001l);
		Assert.assertNotNull(output);
		Assert.assertTrue(output.getName().equals("Vinod"));
		
	}
	
	@Test
	public void fetchExistingUserRecord() {
		LoyaltyOutput output=loyaltyService.fetchExistingUserRecord(11001l);
		Assert.assertNotNull(output);
		
		
	}
	
	@Test
	public void fetchLoyaltyOutput() {
		List<LoyaltyOutput> outputList=loyaltyService.fetchLoyaltyOutput();
		Assert.assertNotNull(outputList);
		
		
	}
	

}
