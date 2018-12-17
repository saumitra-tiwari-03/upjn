package com.nic.upjn.spring.dto;

public class QualificationTrainingMasterDTO {
	
	private String category;
	private String name;
	private String selectedtype;
	private Integer masterid;
	
	public String getCategory(){
		return category;
	}
	public void setCategory(String category){
		this.category = category;
	}
	public String getName(){
		return name;
	}
	public void setName(String name){
		this.name = name;
	}
	public String getSelectedtype(){
		return selectedtype;
	}
	public void setSelectedtype(String selectedtype){
		this.selectedtype = selectedtype;
	}
	public Integer getMasterid(){
		return masterid;
	}
	public void setMasterid(Integer masterid){
		this.masterid = masterid;
	}
	
	
	

}
