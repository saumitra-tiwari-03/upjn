package com.nic.upjn.spring.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class OfficeSummaryGroupEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	private String LOC_CODE;
	private String OFFICENAME;

	public String getLOC_CODE() {
		return LOC_CODE;
	}
	public void setLOC_CODE(String lOC_CODE) {
		LOC_CODE = lOC_CODE;
	}
	public String getOFFICENAME() {
		return OFFICENAME;
	}
	public void setOFFICENAME(String oFFICENAME) {
		OFFICENAME = oFFICENAME;
	}
	
	
	

}
