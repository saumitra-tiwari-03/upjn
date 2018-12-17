package com.nic.upjn.spring.dto;

import java.util.Date;

public class GPFArrearDTO {
	
	private long emp_code;
	private long PP_EMPLOYEEMASTERID;
	private long amount;
	private long month; 
	private long year;
	private Date dateofentry;
	private Date arrearfrom;  
	private Date arrearto;
	private String billnumber; 
	private String arreartype;
	
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
	public long getAmount() {
		return amount;
	}
	public void setAmount(long amount) {
		this.amount = amount;
	}
	public long getMonth() {
		return month;
	}
	public void setMonth(long month) {
		this.month = month;
	}
	public long getYear() {
		return year;
	}
	public void setYear(long year) {
		this.year = year;
	}
	public Date getDateofentry() {
		return dateofentry;
	}
	public void setDateofentry(Date dateofentry) {
		this.dateofentry = dateofentry;
	}
	public Date getArrearfrom() {
		return arrearfrom;
	}
	public void setArrearfrom(Date arrearfrom) {
		this.arrearfrom = arrearfrom;
	}
	public Date getArrearto() {
		return arrearto;
	}
	public void setArrearto(Date arrearto) {
		this.arrearto = arrearto;
	}
	public String getBillnumber() {
		return billnumber;
	}
	public void setBillnumber(String billnumber) {
		this.billnumber = billnumber;
	}
	public String getArreartype() {
		return arreartype;
	}
	public void setArreartype(String arreartype) {
		this.arreartype = arreartype;
	}
	
	
	
	

}
