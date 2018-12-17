package com.nic.upjn.spring.dto;

import java.io.Serializable;

public class EmployeeDedDetailDTO implements Serializable {

	private Long ppEmployeededcontrollerid;
	private long ppEmployeemasterid;

	private int ppDeductionmasterid;
	protected String deductionName;
	private int amount;
	private String stopdeduction;

	public Long getPpEmployeededcontrollerid() {
		return ppEmployeededcontrollerid;
	}

	public void setPpEmployeededcontrollerid(Long ppEmployeededcontrollerid) {
		this.ppEmployeededcontrollerid = ppEmployeededcontrollerid;
	}

	public long getPpEmployeemasterid() {
		return ppEmployeemasterid;
	}

	public void setPpEmployeemasterid(long ppEmployeemasterid) {
		this.ppEmployeemasterid = ppEmployeemasterid;
	}

	public int getPpDeductionmasterid() {
		return ppDeductionmasterid;
	}

	public void setPpDeductionmasterid(int ppDeductionmasterid) {
		this.ppDeductionmasterid = ppDeductionmasterid;
	}

	public String getDeductionName() {
		return deductionName;
	}

	public void setDeductionName(String deductionName) {
		this.deductionName = deductionName;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getStopdeduction() {
		return stopdeduction;
	}

	public void setStopdeduction(String stopdeduction) {
		this.stopdeduction = stopdeduction;
	}

	public String[] getParam() {
		String[] param = new String[3];
		param[0] = this.ppEmployeemasterid + "";
		param[1] = this.ppDeductionmasterid + "";
		param[2] = this.amount + "";
		return param;
	}

}
