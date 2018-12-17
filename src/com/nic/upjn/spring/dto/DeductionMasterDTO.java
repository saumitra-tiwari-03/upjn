package com.nic.upjn.spring.dto;

public class DeductionMasterDTO {
	
	 private String[] mas_EmploymentTypeID;
	 private String pp_DeductionMasterID;
	 private String deductionName;
	 private String dedShortName;
	 private String[] pp_Ded_RulesDetailID;
	 private String[] defaultValue;
	
	 public String[] getMas_EmploymentTypeID() {
		return mas_EmploymentTypeID;
	}
	public void setMas_EmploymentTypeID(String[] mas_EmploymentTypeID) {
		this.mas_EmploymentTypeID = mas_EmploymentTypeID;
	}
	public String getPp_DeductionMasterID() {
		return pp_DeductionMasterID;
	}
	public void setPp_DeductionMasterID(String pp_DeductionMasterID) {
		this.pp_DeductionMasterID = pp_DeductionMasterID;
	}
	public String getDeductionName() {
		return deductionName;
	}
	public void setDeductionName(String deductionName) {
		this.deductionName = deductionName;
	}
	public String getDedShortName() {
		return dedShortName;
	}
	public void setDedShortName(String dedShortName) {
		this.dedShortName = dedShortName;
	}
	public String[] getPp_Ded_RulesDetailID() {
		return pp_Ded_RulesDetailID;
	}
	public void setPp_Ded_RulesDetailID(String[] pp_Ded_RulesDetailID) {
		this.pp_Ded_RulesDetailID = pp_Ded_RulesDetailID;
	}
	public String[] getDefaultValue() {
		return defaultValue;
	}
	public void setDefaultValue(String[] defaultValue) {
		this.defaultValue = defaultValue;
	}

	 
	 
}
