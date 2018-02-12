package com.assignment.loyalty;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.assignment.loyalty.model.LoyaltyInput;
import com.assignment.loyalty.model.LoyaltyOutput;
import com.assignment.loyalty.service.LoyaltyService;

/**
 * boot strap spring-boot program.
 * @author Arjun Agarwal
 *
 * 03-Dec-2017
 */
@SpringBootApplication
public class LoyaltyApplication implements CommandLineRunner{

	@Autowired
	private LoyaltyService loyaltyService;
	
	public static void main(String[] args) {
		SpringApplication.run(LoyaltyApplication.class, args);
	}

	/**
	 * business program. This program prints Loyalty User details.
	 */
	@Override
	public void run(String... args) throws Exception {
		int offset=0;
		int size=100;
		List<LoyaltyInput> inputList=loyaltyService.fetchLoyaltyInput(offset, size);
		while(inputList!=null) {
			for (LoyaltyInput loyaltyInput : inputList) {
				loyaltyService.addLoyaltyInput(loyaltyInput);
			}
			offset=offset+size;
			inputList=loyaltyService.fetchLoyaltyInput(offset, size);
		}
		
		List<LoyaltyOutput> outputList=loyaltyService.fetchLoyaltyOutput();
		for (LoyaltyOutput loyaltyOutput : outputList) {
			System.out.println(loyaltyOutput);
		}
		
	}
}
