package com.nic.upjn.spring.entity;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class EmployeeDetailEntity implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@Column(name = "PP_EMPLOYEEMASTERID")
	private String PP_EMPLOYEEMASTERID;
	@Basic(optional = false)
	@Column(name = "EMPLOYEENAME")
	private String EMPLOYEENAME;
	@Basic(optional = false)
	@Column(name = "DESIGNATION")
	private String DESIGNATION;
	@Basic(optional = false)
	@Column(name = "GPFACNO")
	private String GPFACNO;
	@Basic(optional = false)
	@Column(name = "OFFICENAME")
	private String OFFICENAME;
	
	public String getPP_EMPLOYEEMASTERID() {
		return PP_EMPLOYEEMASTERID;
	}
	public void setPP_EMPLOYEEMASTERID(String pP_EMPLOYEEMASTERID) {
		PP_EMPLOYEEMASTERID = pP_EMPLOYEEMASTERID;
	}
	public String getEMPLOYEENAME() {
		return EMPLOYEENAME;
	}
	public void setEMPLOYEENAME(String eMPLOYEENAME) {
		EMPLOYEENAME = eMPLOYEENAME;
	}
	public String getDESIGNATION() {
		return DESIGNATION;
	}
	public void setDESIGNATION(String dESIGNATION) {
		DESIGNATION = dESIGNATION;
	}
	public String getGPFACNO() {
		return GPFACNO;
	}
	public void setGPFACNO(String gPFACNO) {
		GPFACNO = gPFACNO;
	}
	public String getOFFICENAME() {
		return OFFICENAME;
	}
	public void setOFFICENAME(String oFFICENAME) {
		OFFICENAME = oFFICENAME;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	
	

}
