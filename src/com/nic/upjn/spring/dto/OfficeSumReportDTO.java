package com.nic.upjn.spring.dto;

public class OfficeSumReportDTO {
	
	private String group;
	private String type;
	private String month;
	private String year;
	private String isArrear;
	private String isBoth;
	private String isLocked;
	private String isUnlocked;
	
	public String getGroup() {
		return group;
	}
	public void setGroup(String group) {
		this.group = group;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getIsArrear() {
		return isArrear;
	}
	public void setIsArrear(String isArrear) {
		this.isArrear = isArrear;
	}
	public String getIsBoth() {
		return isBoth;
	}
	public void setIsBoth(String isBoth) {
		this.isBoth = isBoth;
	}
	public String getIsLocked() {
		return isLocked;
	}
	public void setIsLocked(String isLocked) {
		this.isLocked = isLocked;
	}
	public String getIsUnlocked() {
		return isUnlocked;
	}
	public void setIsUnlocked(String isUnlocked) {
		this.isUnlocked = isUnlocked;
	}

	
	
}
