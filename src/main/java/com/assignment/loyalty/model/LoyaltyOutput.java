package com.assignment.loyalty.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.assignment.loyalty.enums.LoyaltyType;
import com.assignment.loyalty.util.LoyaltyUtil;

/**
 * User Loyalty Point Detail POJO.
 * @author Arjun Agarwal
 *
 * 03-Dec-2017
 */
public class LoyaltyOutput implements Serializable {

	private static final long serialVersionUID = 5665105857441838066L;
	
	private String name;
	private String email;
	private int points;
	private LoyaltyType type;
	private int totalAmt;
	private List<TransactionOutput> txnList;

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

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public LoyaltyType getType() {
		return type;
	}

	public void setType(LoyaltyType type) {
		this.type = type;
	}

	public List<TransactionOutput> getTxnList() {
		return txnList;
	}

	public void setTxnList(List<TransactionOutput> txnList) {
		this.txnList = txnList;
	}
	
	public void addTxn(TransactionOutput txn) {
		if(txnList==null) {
			txnList=new ArrayList<>();
		}
		
		txnList.add(txn);
	}

	public int getTotalAmt() {
		return totalAmt;
	}

	public void setTotalAmt(int totalAmt) {
		this.totalAmt = totalAmt;
	}

	@Override
	public String toString() {
		StringBuilder sb=new StringBuilder();
		sb.append("Customer Name:"+name+"\n");
		sb.append("Customer Email:"+email+"\n");
		sb.append("Loyalty Points:"+points+"\n");
		sb.append("Customer Class:"+type.getName()+"\n");
		sb.append("Transactions:\n");
		for (TransactionOutput transactionOutput : txnList) {
			sb.append("\t\t\t"+transactionOutput.getTime().format(LoyaltyUtil.formatter)+"\t"+transactionOutput.getTxnId()+"\t"+transactionOutput.getTxnAMt()+"\t"+transactionOutput.getPoints()+"\n");
		}
		return sb.toString();
	}
	
	
	
}
