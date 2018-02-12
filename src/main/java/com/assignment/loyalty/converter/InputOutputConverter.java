package com.assignment.loyalty.converter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.assignment.loyalty.enums.LoyaltyType;
import com.assignment.loyalty.model.LoyaltyInput;
import com.assignment.loyalty.model.LoyaltyOutput;
import com.assignment.loyalty.model.TransactionOutput;

/**
 * convert input data to output dto. this converter calculates loyalty points as well.
 * @author Arjun Agarwal
 *
 * 02-Dec-2017
 */
@Component
public class InputOutputConverter {

	@Value("${new.customer.points:100}")
	private int newCustomerPoint;

	@Value("${gold.customer.points:25}")
	private int goldCustomerPoiint;

	@Value("${gold.customer.spend.for.point:500}")
	private int goldCustomerSpend;

	@Value("${gold.customer.limit:50000}")
	private int goldCustomerLimit;

	@Value("${silver.customer.points:2}")
	private int silverCustomerPoiint;

	@Value("${silver.customer.spend.for.point:100}")
	private int silverCustomerSpend;

	@Value("${silver.customer.limit:25000}")
	private int silverCustomerLimit;

	@Value("${normal.customer.points:1}")
	private int normalCustomerPoiint;

	@Value("${normal.customer.spend.for.point:100}")
	private int normalCustomerSpend;

	@Value("${normal.customer.limit:0}")
	private int normalCustomerLimit;

	/**
	 * convert input to output when record exist.
	 * 
	 * @param output
	 * @param input
	 * @return
	 */
	public LoyaltyOutput convertInputToOutput(LoyaltyOutput output, LoyaltyInput input) {
		if(!StringUtils.isEmpty(input.getName())) {
			output.setName(input.getName());
		}
		
		if(!StringUtils.isEmpty(input.getEmail())) {
			output.setEmail(input.getEmail());
		}
		
		TransactionOutput tOut=new TransactionOutput();
		tOut.setTime(input.getPurchaseTime());
		tOut.setTxnId(input.getTxnId());
		tOut.setTxnAMt(input.getPurchaseAmt());
		
		if (input.getLoyaltyId() != null) {
			// first time user and is enrolled
			tOut.setPoints(calculatePoint(output.getType(), input.getPurchaseAmt()));
			
			int points = output.getPoints() + tOut.getPoints();
			output.setPoints(points);
		}else {
			System.out.println("input loyalty id can't be null : "+input.toString());
			return null;
		}
		
		output.setTotalAmt(output.getTotalAmt()+input.getPurchaseAmt());
		output.setType(findCategory(output.getTotalAmt()));
		output.addTxn(tOut);
		return output;
	}

	/**
	 * convert input to output when record does not exist.
	 * 
	 * @param input
	 * @return
	 */
	public LoyaltyOutput convertInputToOutput(LoyaltyInput input) {
		LoyaltyOutput output = new LoyaltyOutput();
		output.setName(input.getName());
		output.setEmail(input.getEmail());
		output.setType(LoyaltyType.NORMAL);
		output.setTotalAmt(input.getPurchaseAmt());
		
		TransactionOutput tOut=new TransactionOutput();
		tOut.setTime(input.getPurchaseTime());
		tOut.setTxnId(input.getTxnId());
		tOut.setTxnAMt(input.getPurchaseAmt());
		
		if (input.getLoyaltyId() != null) {
			// first time user and is enrolled
			tOut.setPoints(calculatePoint(output.getType(), input.getPurchaseAmt()));
			
			int points = newCustomerPoint + tOut.getPoints();
			output.setPoints(points);
		}
		
		output.addTxn(tOut);
		return output;
	}

	private LoyaltyType findCategory(int amount) {
		if (amount > goldCustomerLimit) {
			return LoyaltyType.GOLD;
		} else if (amount > silverCustomerLimit) {
			return LoyaltyType.SILVER;
		} else {
			return LoyaltyType.NORMAL;
		}
	}

	private int calculatePoint(LoyaltyType type, int amount) {
		switch (type) {
		case GOLD:
			return (amount * goldCustomerPoiint) / goldCustomerSpend;
		case SILVER:
			return (amount * silverCustomerPoiint) / silverCustomerSpend;
		case NORMAL:
			return (amount * normalCustomerPoiint) / normalCustomerSpend;
		default:
			return 0;
		}
	}
}
