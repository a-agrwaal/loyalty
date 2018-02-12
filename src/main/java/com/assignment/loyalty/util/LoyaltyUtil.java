package com.assignment.loyalty.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.assignment.loyalty.model.LoyaltyInput;

public class LoyaltyUtil {
	public static int inputColumn=6;
	public static DateTimeFormatter formatter=DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
	
	/**
	 * created {@link LoyaltyInput} from provided String input.
	 * @param input
	 * @return
	 */
	public static LoyaltyInput createInputFromString(String input) {

		String[] splitData = input.split(",");
		int size = splitData.length;
		int offset = inputColumn - size;

		LoyaltyInput input1 = new LoyaltyInput();

		for (int i = offset; i < inputColumn; i++) {
			switch (i) {
			case 0:
				input1.setName(splitData[i - offset]);
				break;
			case 1:
				input1.setEmail(splitData[i - offset]);
				break;
			case 2:
				input1.setLoyaltyId(Long.parseLong(splitData[i - offset]));
				break;
			case 3:
				input1.setPurchaseAmt(Integer.parseInt(splitData[i - offset]));
				break;
			case 4:
				input1.setPurchaseTime(LocalDateTime.parse(splitData[i - offset], formatter));
				break;
			case 5:
				input1.setTxnId(Long.parseLong(splitData[i - offset]));
				break;
			default:
				break;
			}
		}
		return input1;
	}
}
