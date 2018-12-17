package com.nic.upjn.spring.dto;

import java.util.Date;

public class GPFWithdrawalDTO {
	
	private long emp_code;
	private long PP_EMPLOYEEMASTERID;
	private long AMOUNT;
	private long MONTH; 
	private long YEAR;
	private Date DATE_OF_ENTRY;
	private Date ORDERDATE;  
	private Date EFFECTIVEDATE;
	private String BILL_NUMBER; 
	private String ORDERNUMBER;

	public long getEmp_code() {
		return emp_code;
	}
	public void setEmp_code(long emp_code) {
		this.emp_code = emp_code;
	}
	public long getPP_EMPLOYEEMASTERID() {
		return PP_EMPLOYEEMASTERID;
	}
	public void setPP_EMPLOYEEMASTERID(long pP_EMPLOYEEMASTERID) {
		PP_EMPLOYEEMASTERID = pP_EMPLOYEEMASTERID;
	}
	public long getAMOUNT() {
		return AMOUNT;
	}
	public void setAMOUNT(long aMOUNT) {
		AMOUNT = aMOUNT;
	}
	public long getMONTH() {
		return MONTH;
	}
	public void setMONTH(long mONTH) {
		MONTH = mONTH;
	}
	public long getYEAR() {
		return YEAR;
	}
	public void setYEAR(long yEAR) {
		YEAR = yEAR;
	}
	public Date getDATE_OF_ENTRY() {
		return DATE_OF_ENTRY;
	}
	public void setDATE_OF_ENTRY(Date dATE_OF_ENTRY) {
		DATE_OF_ENTRY = dATE_OF_ENTRY;
	}
	public Date getORDERDATE() {
		return ORDERDATE;
	}
	public void setORDERDATE(Date oRDERDATE) {
		ORDERDATE = oRDERDATE;
	}
	public Date getEFFECTIVEDATE() {
		return EFFECTIVEDATE;
	}
	public void setEFFECTIVEDATE(Date eFFECTIVEDATE) {
		EFFECTIVEDATE = eFFECTIVEDATE;
	}
	public String getBILL_NUMBER() {
		return BILL_NUMBER;
	}
	public void setBILL_NUMBER(String bILL_NUMBER) {
		BILL_NUMBER = bILL_NUMBER;
	}
	public String getORDERNUMBER() {
		return ORDERNUMBER;
	}
	public void setORDERNUMBER(String oRDERNUMBER) {
		ORDERNUMBER = oRDERNUMBER;
	}
	
	
	

}
