package com.nic.upjn.spring.dto;

import java.math.BigInteger;

public class EmployeePostingDTO {

	private Long ppEmployeemasterid;

	private String employeecode;
	private String employeename;
	private String designation;
	private String employmenttype;
	private String employmentsubtype;
	private String postingagainst;
	private Long ppPostingdetailid;
	private BigInteger entryOfficeid;
	private String officename;
	private String postingorderno;
	private String districtname;
	private int masOfficelevelid;
	private String officelevel;
	private int rmOfficeid;
	private BigInteger flagid;
	private String subphasename;
	private String ppDesignationmasterid;
	private String effectivedate;
	private String orderdate;
	private String SYS_SUBSERVICEPHASEMASTERID;
	private String joiningagainst;
	private String masDistrictid;
	private String effectivedatjoin;
	private String joinANFN_in;
	private String joining_time;
	private String datejoining;

	public String getDatejoining() {
		return datejoining;
	}

	public void setDatejoining(String datejoining) {
		this.datejoining = datejoining;
	}

	public String getJoining_time() {
		return joining_time;
	}

	public void setJoining_time(String joining_time) {
		this.joining_time = joining_time;
	}

	public String getJoinANFN_in() {
		return joinANFN_in;
	}

	public void setJoinANFN_in(String joinANFN_in) {
		this.joinANFN_in = joinANFN_in;
	}

	public String getEffectivedatjoin() {
		return effectivedatjoin;
	}

	public void setEffectivedatjoin(String effectivedatjoin) {
		this.effectivedatjoin = effectivedatjoin;
	}

	public String getMasDistrictid() {
		return masDistrictid;
	}

	public void setMasDistrictid(String masDistrictid) {
		this.masDistrictid = masDistrictid;
	}

	public String getJoiningagainst() {
		return joiningagainst;
	}

	public void setJoiningagainst(String joiningagainst) {
		this.joiningagainst = joiningagainst;
	}

	public long getPpPostingdetailid() {
		return ppPostingdetailid;
	}

	public void setPpPostingdetailid(long ppPostingdetailid) {
		this.ppPostingdetailid = ppPostingdetailid;
	}

	public String getSYS_SUBSERVICEPHASEMASTERID() {
		return SYS_SUBSERVICEPHASEMASTERID;
	}

	public void setSYS_SUBSERVICEPHASEMASTERID(
			String sYS_SUBSERVICEPHASEMASTERID) {
		SYS_SUBSERVICEPHASEMASTERID = sYS_SUBSERVICEPHASEMASTERID;
	}

	public String getEffectivedate() {
		return effectivedate;
	}

	public void setEffectivedate(String effectivedate) {
		this.effectivedate = effectivedate;
	}

	public String getOrderdate() {
		return orderdate;
	}

	public void setOrderdate(String orderdate) {
		this.orderdate = orderdate;
	}

	public String getPostingorderno() {
		return postingorderno;
	}

	public void setPostingorderno(String postingorderno) {
		this.postingorderno = postingorderno;
	}

	public String getPpDesignationmasterid() {
		return ppDesignationmasterid;
	}

	public void setPpDesignationmasterid(String ppDesignationmasterid) {
		this.ppDesignationmasterid = ppDesignationmasterid;
	}

	public String getSubphasename() {
		return subphasename;
	}

	public void setSubphasename(String subphasename) {
		this.subphasename = subphasename;
	}

	public String getOfficename() {
		return officename;
	}

	public void setOfficename(String officename) {
		this.officename = officename;
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

	public Long getPpEmployeemasterid() {
		return ppEmployeemasterid;
	}

	public void setPpEmployeemasterid(Long ppEmployeemasterid) {
		this.ppEmployeemasterid = ppEmployeemasterid;
	}

	public String getEmployeecode() {
		return employeecode;
	}

	public void setEmployeecode(String employeecode) {
		this.employeecode = employeecode;
	}

	public String getEmployeename() {
		return employeename;
	}

	public void setEmployeename(String employeename) {
		this.employeename = employeename;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getEmploymenttype() {
		return employmenttype;
	}

	public void setEmploymenttype(String employmenttype) {
		this.employmenttype = employmenttype;
	}

	public String getEmploymentsubtype() {
		return employmentsubtype;
	}

	public void setEmploymentsubtype(String employmentsubtype) {
		this.employmentsubtype = employmentsubtype;
	}

	public String getPostingagainst() {
		return postingagainst;
	}

	public void setPostingagainst(String postingagainst) {
		this.postingagainst = postingagainst;
	}

	public BigInteger getEntryOfficeid() {
		return entryOfficeid;
	}

	public void setEntryOfficeid(BigInteger entryOfficeid) {
		this.entryOfficeid = entryOfficeid;
	}

	public BigInteger getFlagid() {
		return flagid;
	}

	public void setFlagid(BigInteger flagid) {
		this.flagid = flagid;
	}

}
