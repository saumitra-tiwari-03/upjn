package com.nic.upjn.spring.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ViewLocCode implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	private Integer LOC_CODE;

	public Integer getLOC_CODE() {
		return LOC_CODE;
	}

	public void setLOC_CODE(Integer lOC_CODE) {
		LOC_CODE = lOC_CODE;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
