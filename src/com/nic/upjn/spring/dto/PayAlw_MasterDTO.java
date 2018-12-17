package com.nic.upjn.spring.dto;

import java.io.Serializable;

public class PayAlw_MasterDTO  implements Serializable{
	
	
	protected String pp_PayAlwMasterID;
 	protected String mas_EmploymentTypeID;
 	protected String sys_PayCommissionID;
 	protected String payAlwName;
	protected String alwName;
	protected String alwCategory;
 	protected String amount;
 	protected String stop_Alw_Flag;
	
	

 	public String getPp_PayAlwMasterID(){
		return this.pp_PayAlwMasterID; 
	 }
 	public void setPp_PayAlwMasterID(String pp_PayAlwMasterID){
 		this.pp_PayAlwMasterID = pp_PayAlwMasterID;
 	}
 	public String getMas_EmploymentTypeID(){
		return this.mas_EmploymentTypeID; 
	 }
 	public void setMas_EmploymentTypeID(String mas_EmploymentTypeID){
 		this.mas_EmploymentTypeID = mas_EmploymentTypeID;
 	}
 	public String getSys_PayCommissionID(){
		return this.sys_PayCommissionID; 
	 }
 	public void setSys_PayCommissionID(String sys_PayCommissionID){
 		this.sys_PayCommissionID = sys_PayCommissionID;
 	}
 	public String getPayAlwName(){
		return this.payAlwName; 
	 }
 	public void setPayAlwName(String payAlwName){
 		this.payAlwName = payAlwName;
 	}

	public String getAlwName(){
		return this.alwName; 
	 }
 	public void setAlwName(String alwName){
 		this.alwName = alwName;
 	}

	public String getAlwCategory(){
		return this.alwCategory; 
	 }
 	public void setAlwCategory(String alwCategory){
 		this.alwCategory = alwCategory;
 	}

	public String getAmount(){
		return this.amount; 
	 }
 	public void setAmount(String amount){
 		this.amount = amount;
 	}	

	public String getStop_Alw_Flag(){
		return this.stop_Alw_Flag; 
	 }
 	public void setStop_Alw_Flag(String stop_Alw_Flag){
 		this.stop_Alw_Flag = stop_Alw_Flag;
 	}	

}

