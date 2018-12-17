package com.nic.upjn.spring.dto;

public class PayScaleMasterDTO {
	
	private String payCategory;
	private short sysPaycategoryid;
	private String payscale;
	private String pp_PayScaleMasterID;
	private int defaultincrement;
	private int minamt;
	private int maxamt;

	
	public String getPayCategory() {
		return payCategory;
	}
	public void setPayCategory(String payCategory) {
		this.payCategory = payCategory;
	}	
	public short getSysPaycategoryid() {
		return sysPaycategoryid;
	}
	public void setSysPaycategoryid(short sysPaycategoryid) {
		this.sysPaycategoryid = sysPaycategoryid;
	}
	public String getPayscale() {
		return payscale;
	}
	public void setPayscale(String payscale) {
		this.payscale = payscale;
	}
	
	public String getPp_PayScaleMasterID() {
		return pp_PayScaleMasterID;
	}
	public void setPp_PayScaleMasterID(String pp_PayScaleMasterID) {
		this.pp_PayScaleMasterID = pp_PayScaleMasterID;
	}
	public int getDefaultincrement() {
		return defaultincrement;
	}
	public void setDefaultincrement(int defaultincrement) {
		this.defaultincrement = defaultincrement;
	}
	public int getMinamt() {
		return minamt;
	}
	public void setMinamt(int minamt) {
		this.minamt = minamt;
	}
	public int getMaxamt() {
		return maxamt;
	}
	public void setMaxamt(int maxamt) {
		this.maxamt = maxamt;
	}

	
	
}
