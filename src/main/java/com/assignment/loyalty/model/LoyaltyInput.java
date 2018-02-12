package com.assignment.loyalty.model;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * User txn details POJO.
 * @author Arjun Agarwal
 *
 * 03-Dec-2017
 */
public class LoyaltyInput implements Serializable {

	private static final long serialVersionUID = 1439008868900353804L;
	
	private String name;
	private String email;
	private Long loyaltyId;
	private int purchaseAmt;
	private LocalDateTime purchaseTime;
	private long txnId;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Long getLoyaltyId() {
		return loyaltyId;
	}
	public void setLoyaltyId(Long loyaltyId) {
		this.loyaltyId = loyaltyId;
	}
	public int getPurchaseAmt() {
		return purchaseAmt;
	}
	public void setPurchaseAmt(int purchaseAmt) {
		this.purchaseAmt = purchaseAmt;
	}
	public LocalDateTime getPurchaseTime() {
		return purchaseTime;
	}
	public void setPurchaseTime(LocalDateTime purchaseTime) {
		this.purchaseTime = purchaseTime;
	}
	public long getTxnId() {
		return txnId;
	}
	public void setTxnId(long txnId) {
		this.txnId = txnId;
	}
	

}
