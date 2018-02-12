package com.assignment.loyalty;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.assignment.loyalty.converter.InputOutputConverter;
import com.assignment.loyalty.enums.LoyaltyType;
import com.assignment.loyalty.model.LoyaltyInput;
import com.assignment.loyalty.model.LoyaltyOutput;
import com.assignment.loyalty.util.LoyaltyUtil;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InputOutputConverterTests {

	@Autowired
	private InputOutputConverter converter;

	@Test
	public void convertInputToOutputRecordAbsentCase() {

		LoyaltyInput input = LoyaltyUtil
				.createInputFromString("Abhay,abhay@demo.com,11001,7402,22-06-2012 11:23,2348723");

		// NEW
		LoyaltyOutput output = converter.convertInputToOutput(input);
		Assert.assertEquals(174, output.getPoints());
		Assert.assertEquals(LoyaltyType.NORMAL, output.getType());
		Assert.assertEquals("Abhay", output.getName());
		Assert.assertEquals("abhay@demo.com", output.getEmail());

		Assert.assertEquals(1, output.getTxnList().size());
		Assert.assertEquals("22-06-2012 11:23", output.getTxnList().get(0).getTime().format(LoyaltyUtil.formatter));
		Assert.assertEquals(2348723, output.getTxnList().get(0).getTxnId());
		Assert.assertEquals(74, output.getTxnList().get(0).getPoints());
		Assert.assertEquals(7402, output.getTxnList().get(0).getTxnAMt());

	}

	@Test
	public void convertInputToOutputRecordPresentCase() {

		LoyaltyInput input = LoyaltyUtil
				.createInputFromString("Abhay,abhay@demo.com,11001,7402,22-06-2012 11:23,2348723");

		LoyaltyOutput output = converter.convertInputToOutput(input);

		// NORMAL
		input = LoyaltyUtil.createInputFromString("Anant,anant@example.com,11002,20000,22-06-2012 15:39,2939303");
		output = converter.convertInputToOutput(output, input);
		Assert.assertEquals(374, output.getPoints());
		Assert.assertEquals(LoyaltyType.SILVER, output.getType());
		Assert.assertEquals("Anant", output.getName());
		Assert.assertEquals("anant@example.com", output.getEmail());

		Assert.assertEquals(2, output.getTxnList().size());
		Assert.assertEquals("22-06-2012 15:39", output.getTxnList().get(1).getTime().format(LoyaltyUtil.formatter));
		Assert.assertEquals(2939303, output.getTxnList().get(1).getTxnId());
		Assert.assertEquals(200, output.getTxnList().get(1).getPoints());
		Assert.assertEquals(20000, output.getTxnList().get(1).getTxnAMt());

		// SILVER
		input = LoyaltyUtil.createInputFromString("11002,25000,22-06-2012 15:39,2939303");
		output = converter.convertInputToOutput(output, input);
		Assert.assertEquals(874, output.getPoints());
		Assert.assertEquals(LoyaltyType.GOLD, output.getType());
		Assert.assertEquals("Anant", output.getName());
		Assert.assertEquals("anant@example.com", output.getEmail());

		Assert.assertEquals(3, output.getTxnList().size());
		Assert.assertEquals("22-06-2012 15:39", output.getTxnList().get(2).getTime().format(LoyaltyUtil.formatter));
		Assert.assertEquals(2939303, output.getTxnList().get(2).getTxnId());
		Assert.assertEquals(500, output.getTxnList().get(2).getPoints());
		Assert.assertEquals(25000, output.getTxnList().get(2).getTxnAMt());

		// GOLD
		input = LoyaltyUtil.createInputFromString("Anant,anant@example.com,11002,1000,22-06-2012 15:39,2939303");
		output = converter.convertInputToOutput(output, input);
		Assert.assertEquals(924, output.getPoints());
		Assert.assertEquals(LoyaltyType.GOLD, output.getType());
		Assert.assertEquals("Anant", output.getName());
		Assert.assertEquals("anant@example.com", output.getEmail());

		Assert.assertEquals(4, output.getTxnList().size());
		Assert.assertEquals("22-06-2012 15:39", output.getTxnList().get(3).getTime().format(LoyaltyUtil.formatter));
		Assert.assertEquals(2939303, output.getTxnList().get(3).getTxnId());
		Assert.assertEquals(50, output.getTxnList().get(3).getPoints());
		Assert.assertEquals(1000, output.getTxnList().get(3).getTxnAMt());
		
		//

	}

}
