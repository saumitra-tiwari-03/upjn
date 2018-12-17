package com.nic.upjn.spring.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class TransferEmployeeDTO {

	private Long ppEmployeemasterid;
	private String employeecode;
	private String employeename;
	private String rmOfficeid;
	private String designation;
	private String ppNoduesdetailid;
	private String noduesordno;	
	@DateTimeFormat(pattern="dd/MM/yyyy")
	private Date noduesorddate;
	private Character ison;
	private String ppDesignationmasterid;
	private String masEmploymentsubtypeid;
	private String employmentsubtype;
	private String masEmploymenttypeid;
	private String ppemploymentmasterid;
	private String gpfacno;
	private String ppTransferdetailid;
	private String transferorderno;
	private String transferorderdate;
	private String officefromid;
	private String officetoid;
	private String relieveorderno;
	private String relieveorderdate;
	private String relievedate;
	private String relieveanfn;
	private String masOfficelevelid;
	private String isJoined;

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

	public String getRmOfficeid() {
		return rmOfficeid;
	}

	public void setRmOfficeid(String rmOfficeid) {
		this.rmOfficeid = rmOfficeid;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getPpNoduesdetailid() {
		return ppNoduesdetailid;
	}

	public void setPpNoduesdetailid(String ppNoduesdetailid) {
		this.ppNoduesdetailid = ppNoduesdetailid;
	}

	public String getNoduesordno() {
		return noduesordno;
	}

	public void setNoduesordno(String noduesordno) {
		this.noduesordno = noduesordno;
	}

	public Date getNoduesorddate() {
		return noduesorddate;
	}

	public void setNoduesorddate(Date noduesorddate) {
		this.noduesorddate = noduesorddate;
	}

	public Character getIson() {
		return ison;
	}

	public void setIson(Character ison) {
		this.ison = ison;
	}

	public String getPpDesignationmasterid() {
		return ppDesignationmasterid;
	}

	public void setPpDesignationmasterid(String ppDesignationmasterid) {
		this.ppDesignationmasterid = ppDesignationmasterid;
	}

	public String getMasEmploymentsubtypeid() {
		return masEmploymentsubtypeid;
	}

	public void setMasEmploymentsubtypeid(String masEmploymentsubtypeid) {
		this.masEmploymentsubtypeid = masEmploymentsubtypeid;
	}

	public String getEmploymentsubtype() {
		return employmentsubtype;
	}

	public void setEmploymentsubtype(String employmentsubtype) {
		this.employmentsubtype = employmentsubtype;
	}

	public String getMasEmploymenttypeid() {
		return masEmploymenttypeid;
	}

	public void setMasEmploymenttypeid(String masEmploymenttypeid) {
		this.masEmploymenttypeid = masEmploymenttypeid;
	}

	public String getPpemploymentmasterid() {
		return ppemploymentmasterid;
	}

	public void setPpemploymentmasterid(String ppemploymentmasterid) {
		this.ppemploymentmasterid = ppemploymentmasterid;
	}

	public String getGpfacno() {
		return gpfacno;
	}

	public void setGpfacno(String gpfacno) {
		this.gpfacno = gpfacno;
	}

	public String getPpTransferdetailid() {
		return ppTransferdetailid;
	}

	public void setPpTransferdetailid(String ppTransferdetailid) {
		this.ppTransferdetailid = ppTransferdetailid;
	}

	public String getTransferorderno() {
		return transferorderno;
	}

	public void setTransferorderno(String transferorderno) {
		this.transferorderno = transferorderno;
	}

	public String getTransferorderdate() {
		return transferorderdate;
	}

	public void setTransferorderdate(String transferorderdate) {
		this.transferorderdate = transferorderdate;
	}

	public String getOfficefromid() {
		return officefromid;
	}

	public void setOfficefromid(String officefromid) {
		this.officefromid = officefromid;
	}

	public String getOfficetoid() {
		return officetoid;
	}

	public void setOfficetoid(String officetoid) {
		this.officetoid = officetoid;
	}

	public String getRelieveorderno() {
		return relieveorderno;
	}

	public void setRelieveorderno(String relieveorderno) {
		this.relieveorderno = relieveorderno;
	}

	public String getRelieveorderdate() {
		return relieveorderdate;
	}

	public void setRelieveorderdate(String relieveorderdate) {
		this.relieveorderdate = relieveorderdate;
	}

	public String getRelievedate() {
		return relievedate;
	}

	public void setRelievedate(String relievedate) {
		this.relievedate = relievedate;
	}

	public String getRelieveanfn() {
		return relieveanfn;
	}

	public void setRelieveanfn(String relieveanfn) {
		this.relieveanfn = relieveanfn;
	}

	public String getMasOfficelevelid() {
		return masOfficelevelid;
	}

	public void setMasOfficelevelid(String masOfficelevelid) {
		this.masOfficelevelid = masOfficelevelid;
	}

	public String getIsJoined() {
		return isJoined;
	}

	public void setIsJoined(String isJoined) {
		this.isJoined = isJoined;
	}

}