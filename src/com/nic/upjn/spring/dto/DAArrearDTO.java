package com.nic.upjn.spring.dto;

public class DAArrearDTO {
	
	private String employeecode;
	private long ppRegistermasterid;
	private String startDate;
    private String endDate;
    private String financeYear;
	
    public long getPpRegistermasterid() {
		return ppRegistermasterid;
	}
	public void setPpRegistermasterid(long ppRegistermasterid) {
		this.ppRegistermasterid = ppRegistermasterid;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getEmployeecode() {
		return employeecode;
	}
	public void setEmployeecode(String employeecode) {
		this.employeecode = employeecode;
	}
	public String getFinanceYear() {
		return financeYear;
	}
	public void setFinanceYear(String financeYear) {
		this.financeYear = financeYear;
	}
    
	
    
}
