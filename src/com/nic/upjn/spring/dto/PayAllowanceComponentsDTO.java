package com.nic.upjn.spring.dto;

import java.io.Serializable;

public class PayAllowanceComponentsDTO implements Serializable {

	
	public String pp_EmployeeMasterID;
	public String pp_PayAlw_MasterId;
	public String mas_EmploymentSubTypeID;
 	public String payAlwValue;
 
	public String getPp_EmployeeMasterID(){
		return this.pp_EmployeeMasterID; 
	 }
 	public void setPp_EmployeeMasterID(String pp_EmployeeMasterID){
 		this.pp_EmployeeMasterID = pp_EmployeeMasterID;
 	}

	public String getPp_PayAlw_MasterId(){
		return this.pp_PayAlw_MasterId; 
	 }
 	public void setPp_PayAlw_MasterId(String pp_PayAlw_MasterId){
 		this.pp_PayAlw_MasterId = pp_PayAlw_MasterId;
 	}

	 public String getMas_EmploymentSubTypeID(){
		 return mas_EmploymentSubTypeID; 
	 }
	 public void setMas_EmploymentSubTypeID(String mas_EmploymentSubTypeID){
		 this.mas_EmploymentSubTypeID = mas_EmploymentSubTypeID; 
	 }

	public String getPayAlwValue(){
		return this.payAlwValue; 
	 }
 	public void setPayAlwValue(String payAlwValue){
 		this.payAlwValue = payAlwValue;
 	}

}