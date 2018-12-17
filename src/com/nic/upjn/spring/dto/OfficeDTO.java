package com.nic.upjn.spring.dto;

public class OfficeDTO {

	private Long masDistrictid;

	public Long getEntryOfficeid() {
		return entryOfficeid;
	}

	public void setEntryOfficeid(Long entryOfficeid) {
		this.entryOfficeid = entryOfficeid;
	}

	private String districtname;
	private int masOfficelevelid;
	private String officelevel;
	private int rmOfficeid;
	private Long entryOfficeid;

	public Long getMasDistrictid() {
		return masDistrictid;
	}

	public void setMasDistrictid(Long masDistrictid) {
		this.masDistrictid = masDistrictid;
	}

	public String getDistrictname() {
		return districtname;
	}

	public void setDistrictname(String districtname) {
		this.districtname = districtname;
	}

	public int getMasOfficelevelid() {
		return masOfficelevelid;
	}

	public void setMasOfficelevelid(int masOfficelevelid) {
		this.masOfficelevelid = masOfficelevelid;
	}

	public String getOfficelevel() {
		return officelevel;
	}

	public void setOfficelevel(String officelevel) {
		this.officelevel = officelevel;
	}

	public int getRmOfficeid() {
		return rmOfficeid;
	}

	public void setRmOfficeid(int rmOfficeid) {
		this.rmOfficeid = rmOfficeid;
	}

	public String getOfficename() {
		return officename;
	}

	public void setOfficename(String officename) {
		this.officename = officename;
	}

	private String officename;
}
