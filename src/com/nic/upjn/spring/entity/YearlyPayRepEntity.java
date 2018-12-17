package com.nic.upjn.spring.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class YearlyPayRepEntity implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	private String PP_PAYBILLDETAILID;
	private String WEIGHT;
	
	public String getPP_PAYBILLDETAILID() {
		return PP_PAYBILLDETAILID;
	}
	public void setPP_PAYBILLDETAILID(String pP_PAYBILLDETAILID) {
		PP_PAYBILLDETAILID = pP_PAYBILLDETAILID;
	}
	public String getWEIGHT() {
		return WEIGHT;
	}
	public void setWEIGHT(String wEIGHT) {
		WEIGHT = wEIGHT;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	

}
