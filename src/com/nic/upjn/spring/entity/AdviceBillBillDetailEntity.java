package com.nic.upjn.spring.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "AdviceBillBillDetailEntity")
@XmlRootElement
@NamedQueries({})
public class AdviceBillBillDetailEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	protected String PP_PAYBILLDETAILID;

	protected String BILLCLERKNAME;

	protected String BILLNO;

	protected String MONTH;

	protected String YEAR;

	protected String BILLDATE;

	protected String BILLAMOUNT;

	protected String BILLTYPE_FLAG;

	protected String PP_REGISTERMASTERID;

	protected String REGISTERNAME;

	public String getPP_PAYBILLDETAILID() {
		return PP_PAYBILLDETAILID;
	}

	public void setPP_PAYBILLDETAILID(String pP_PAYBILLDETAILID) {
		PP_PAYBILLDETAILID = pP_PAYBILLDETAILID;
	}

	public String getBILLCLERKNAME() {
		return BILLCLERKNAME;
	}

	public void setBILLCLERKNAME(String bILLCLERKNAME) {
		BILLCLERKNAME = bILLCLERKNAME;
	}

	public String getBILLNO() {
		return BILLNO;
	}

	public void setBILLNO(String bILLNO) {
		BILLNO = bILLNO;
	}

	public String getMONTH() {
		return MONTH;
	}

	public void setMONTH(String mONTH) {
		MONTH = mONTH;
	}

	public String getYEAR() {
		return YEAR;
	}

	public void setYEAR(String yEAR) {
		YEAR = yEAR;
	}

	public String getBILLDATE() {
		return BILLDATE;
	}

	public void setBILLDATE(String bILLDATE) {
		BILLDATE = bILLDATE;
	}

	public String getBILLAMOUNT() {
		return BILLAMOUNT;
	}

	public void setBILLAMOUNT(String bILLAMOUNT) {
		BILLAMOUNT = bILLAMOUNT;
	}

	public String getBILLTYPE_FLAG() {
		return BILLTYPE_FLAG;
	}

	public void setBILLTYPE_FLAG(String bILLTYPE_FLAG) {
		BILLTYPE_FLAG = bILLTYPE_FLAG;
	}

	public String getPP_REGISTERMASTERID() {
		return PP_REGISTERMASTERID;
	}

	public void setPP_REGISTERMASTERID(String pP_REGISTERMASTERID) {
		PP_REGISTERMASTERID = pP_REGISTERMASTERID;
	}

	public String getREGISTERNAME() {
		return REGISTERNAME;
	}

	public void setREGISTERNAME(String rEGISTERNAME) {
		REGISTERNAME = rEGISTERNAME;
	}
	
	
	

}
