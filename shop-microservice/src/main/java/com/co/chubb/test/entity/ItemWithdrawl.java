package com.co.chubb.test.entity;

import java.io.Serializable;

import lombok.Data;

@Data
public class ItemWithdrawl implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String itemCode;
	private long withdrawlQuantity;
	
	public String getItemCode() {
		return itemCode;
	}
	
	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	public long getWithdrawlQuantity() {
		return withdrawlQuantity;
	}

	public void setWithdrawlQuantity(long withdrawlQuantity) {
		this.withdrawlQuantity = withdrawlQuantity;
	}

}
