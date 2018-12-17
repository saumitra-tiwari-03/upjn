package com.nic.upjn.spring.dto;

import java.io.Serializable;

public class RuleMasterDTO implements Serializable {

 	protected String pp_RuleMasterID;
 	protected String sys_RuleCategoryID;
 	protected String ruleOrderNo;
 	protected String ruleOrderDate;
 	protected String dateOfEffect;
	protected String ruleCategory;
	protected String pp_PayAlwMasterID;
 	protected String isTownCatBased;

 	public String getPp_RuleMasterID(){
		return this.pp_RuleMasterID; 
	 }
 	public void setPp_RuleMasterID(String pp_RuleMasterID){
 		this.pp_RuleMasterID = pp_RuleMasterID;
 	}
 	public String getSys_RuleCategoryID(){
		return this.sys_RuleCategoryID; 
	 }
 	public void setSys_RuleCategoryID(String sys_RuleCategoryID){
 		this.sys_RuleCategoryID = sys_RuleCategoryID;
 	}
 	public String getRuleOrderNo(){
		return this.ruleOrderNo; 
	 }
 	public void setRuleOrderNo(String ruleOrderNo){
 		this.ruleOrderNo = ruleOrderNo;
 	}
 	public String getRuleOrderDate(){
		return this.ruleOrderDate; 
	 }
 	public void setRuleOrderDate(String ruleOrderDate){
 		this.ruleOrderDate = ruleOrderDate;
 	}
 	public String getDateOfEffect(){
		return this.dateOfEffect; 
	 }
 	public void setDateOfEffect(String dateOfEffect){
 		this.dateOfEffect = dateOfEffect;
 	}
	public String getRuleCategory(){
		return this.ruleCategory; 
	 }
 	public void setRuleCategory(String ruleCategory){
 		this.ruleCategory = ruleCategory;
 	}
	public String getPp_PayAlwMasterID(){
		return this.pp_PayAlwMasterID; 
	 }
 	public void setPp_PayAlwMasterID(String pp_PayAlwMasterID){
 		this.pp_PayAlwMasterID = pp_PayAlwMasterID;
 	}
 	public String getIsTownCatBased(){
		return this.isTownCatBased; 
	 }
 	public void setIsTownCatBased(String isTownCatBased){
 		this.isTownCatBased = isTownCatBased;
 	}

}