package com.nic.upjn.spring.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "BillAdviceReportEntity")
@Entity
public class BillAdviceReportEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	private String PP_EMPLOYEEMASTERID;
	private String EMPLOYEECODE;
	private String EMPLOYEENAME;
	private String RM_OFFICEID;
	private String SYS_PAYMENTMODEID;
	private String BANKACCNO;
	private String PAYMONTH;
	private String PAYYEAR;
	private String PP_NETPAY;
	private String BILLDATE;
	private String BRANCHNAME;
	private String BANKNAME;

	public String getPP_EMPLOYEEMASTERID() {
		return PP_EMPLOYEEMASTERID;
	}

	public void setPP_EMPLOYEEMASTERID(String pP_EMPLOYEEMASTERID) {
		PP_EMPLOYEEMASTERID = pP_EMPLOYEEMASTERID;
	}

	public String getEMPLOYEECODE() {
		return EMPLOYEECODE;
	}

	public void setEMPLOYEECODE(String eMPLOYEECODE) {
		EMPLOYEECODE = eMPLOYEECODE;
	}

	public String getEMPLOYEENAME() {
		return EMPLOYEENAME;
	}

	public void setEMPLOYEENAME(String eMPLOYEENAME) {
		EMPLOYEENAME = eMPLOYEENAME;
	}

	public String getRM_OFFICEID() {
		return RM_OFFICEID;
	}

	public void setRM_OFFICEID(String rM_OFFICEID) {
		RM_OFFICEID = rM_OFFICEID;
	}

	public String getSYS_PAYMENTMODEID() {
		return SYS_PAYMENTMODEID;
	}

	public void setSYS_PAYMENTMODEID(String sYS_PAYMENTMODEID) {
		SYS_PAYMENTMODEID = sYS_PAYMENTMODEID;
	}

	public String getBANKACCNO() {
		return BANKACCNO;
	}

	public void setBANKACCNO(String bANKACCNO) {
		BANKACCNO = bANKACCNO;
	}

	public String getPAYMONTH() {
		return PAYMONTH;
	}

	public void setPAYMONTH(String pAYMONTH) {
		PAYMONTH = pAYMONTH;
	}

	public String getPAYYEAR() {
		return PAYYEAR;
	}

	public void setPAYYEAR(String pAYYEAR) {
		PAYYEAR = pAYYEAR;
	}

	public String getPP_NETPAY() {
		return PP_NETPAY;
	}

	public void setPP_NETPAY(String pP_NETPAY) {
		PP_NETPAY = pP_NETPAY;
	}

	public String getBILLDATE() {
		return BILLDATE;
	}

	public void setBILLDATE(String bILLDATE) {
		BILLDATE = bILLDATE;
	}

	public String getBRANCHNAME() {
		return BRANCHNAME;
	}

	public void setBRANCHNAME(String bRANCHNAME) {
		BRANCHNAME = bRANCHNAME;
	}

	public String getBANKNAME() {
		return BANKNAME;
	}

	public void setBANKNAME(String bANKNAME) {
		BANKNAME = bANKNAME;
	}

}
