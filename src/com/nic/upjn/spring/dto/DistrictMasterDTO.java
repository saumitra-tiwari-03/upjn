package com.nic.upjn.spring.dto;

public class DistrictMasterDTO {
	
	
	/** MAS_DistrictID property */ 
	 private Integer mas_DistrictID;

	/** districtName property */ 
	 private String districtName;

	/** censusDistrictCode property */ 
	 private String censusDistrictCode;

	/** MAS_StateID property */ 
	 private Integer mas_StateID;



	public Integer getMas_DistrictID() {
		return mas_DistrictID;
	}

	public void setMas_DistrictID(Integer mas_DistrictID) {
		this.mas_DistrictID = mas_DistrictID;
	}

	public Integer getMas_StateID() {
		return mas_StateID;
	}

	public void setMas_StateID(Integer mas_StateID) {
		this.mas_StateID = mas_StateID;
	}

	public String getDistrictName() {
		return districtName;
	}

	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}

	public String getCensusDistrictCode() {
		return censusDistrictCode;
	}

	public void setCensusDistrictCode(String censusDistrictCode) {
		this.censusDistrictCode = censusDistrictCode;
	}

	
}
