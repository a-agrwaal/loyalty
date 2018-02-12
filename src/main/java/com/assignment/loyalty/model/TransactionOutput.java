package com.assignment.loyalty.model;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Transaction Records in Loyalty Program POJO.
 * @author Arjun Agarwal
 *
 * 03-Dec-2017
 */
public class TransactionOutput implements Serializable {

	private static final long serialVersionUID = -3610368542264790426L;
	
	private LocalDateTime time;
	private long txnId;
	private int txnAMt;
	private int points;
	public LocalDateTime getTime() {
		return time;
	}
	public void setTime(LocalDateTime time) {
		this.time = time;
	}
	public long getTxnId() {
		return txnId;
	}
	public void setTxnId(long txnId) {
		this.txnId = txnId;
	}
	public int getTxnAMt() {
		return txnAMt;
	}
	public void setTxnAMt(int txnAMt) {
		this.txnAMt = txnAMt;
	}
	public int getPoints() {
		return points;
	}
	public void setPoints(int points) {
		this.points = points;
	}
	
	

}
