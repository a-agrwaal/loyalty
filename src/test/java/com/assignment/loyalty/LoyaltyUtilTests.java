package com.assignment.loyalty;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.assignment.loyalty.model.LoyaltyInput;
import com.assignment.loyalty.util.LoyaltyUtil;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LoyaltyUtilTests {

	@Test
	public void fetchLoyaltyInput() {

		// All
		LoyaltyInput input = LoyaltyUtil
				.createInputFromString("Abhay,abhay@demo.com,11001,7402,22-06-2012 11:23,2348723");
		Assert.assertEquals("Abhay", input.getName());
		Assert.assertEquals("abhay@demo.com", input.getEmail());
		Assert.assertEquals((Long) 11001l, input.getLoyaltyId());
		Assert.assertEquals(7402, input.getPurchaseAmt());
		Assert.assertEquals("22-06-2012 11:23", input.getPurchaseTime().format(LoyaltyUtil.formatter));
		Assert.assertEquals(2348723, input.getTxnId());

		// Partial
		input = LoyaltyUtil
				.createInputFromString("11001,7402,22-06-2012 11:23,2348723");
		Assert.assertNull(input.getName());
		Assert.assertNull(input.getEmail());
		Assert.assertEquals((Long) 11001l, input.getLoyaltyId());
		Assert.assertEquals(7402, input.getPurchaseAmt());
		Assert.assertEquals("22-06-2012 11:23", input.getPurchaseTime().format(LoyaltyUtil.formatter));
		Assert.assertEquals(2348723, input.getTxnId());

	}

}
