package com.nic.upjn.spring.dto;

public class HeadQuarterMasterDTO {
	
	private Integer masDistrictid;
	private String place;
	private Integer ppTowncategorymasterid;
	private Long ppPlacemasterid;

	public Integer getMasDistrictid() {
		return masDistrictid;
	}
	public void setMasDistrictid(Integer masDistrictid) {
		this.masDistrictid = masDistrictid;
	}
	
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public Integer getPpTowncategorymasterid() {
		return ppTowncategorymasterid;
	}
	public void setPpTowncategorymasterid(Integer ppTowncategorymasterid) {
		this.ppTowncategorymasterid = ppTowncategorymasterid;
	}
	public Long getPpPlacemasterid() {
		return ppPlacemasterid;
	}
	public void setPpPlacemasterid(Long ppPlacemasterid) {
		this.ppPlacemasterid = ppPlacemasterid;
	}
	
	

}
