package com.nic.upjn.spring.entity;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class PaySlipHeadEntity implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "HEADNAME")
	private String headName;
	@Column(name = "HEADTYPE")
	private String headType;
	@Column(name = "PRINT_ORDER")
	private long printorder;

	public String getHeadName() {
		return headName;
	}
	public void setHeadName(String headName) {
		this.headName = headName;
	}
	public String getHeadType() {
		return headType;
	}
	public void setHeadType(String headType) {
		this.headType = headType;
	}
	public long getPrintorder() {
		return printorder;
	}
	public void setPrintorder(long printorder) {
		this.printorder = printorder;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	
}
