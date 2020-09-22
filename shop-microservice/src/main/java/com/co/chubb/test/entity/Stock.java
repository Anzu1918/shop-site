package com.co.chubb.test.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Entity

@Data
public class Stock implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private long id;
	private String code;
	private long unitsSold;
	private long unitsAvailable;
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getCode() {
		return code;
	}
	
	public void setCode(String code) {
		this.code = code;
	}
	
	public long getUnitsSold() {
		return unitsSold;
	}
	
	public void setUnitsSold(long unitsSold) {
		this.unitsSold = unitsSold;
	}
	
	public long getUnitsAvailable() {
		return unitsAvailable;
	}
	
	public void setUnitsAvailable(long unitsAvailable) {
		this.unitsAvailable = unitsAvailable;
	}
	
}
