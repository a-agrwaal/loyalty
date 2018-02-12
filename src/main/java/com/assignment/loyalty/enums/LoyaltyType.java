package com.assignment.loyalty.enums;

/**
 * Loyalty category of users.
 * @author Arjun Agarwal
 *
 * 03-Dec-2017
 */
public enum LoyaltyType {
	NORMAL("Normal"),GOLD("Gold"),SILVER("Silver");
	private String name;

	private LoyaltyType(String type) {
		this.setName(type);
	}

	public String getName() {
		return name;
	}

	public void setName(String type) {
		this.name = type;
	}
	
}
