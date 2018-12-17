package com.nic.upjn.spring.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class DADEntity {

	protected String sys_paycategoryid;
	protected String paycategory;
	@Id
	private long rownum;
	protected String PP_PAYALWMASTERID;
	protected String RULEORDERNO;
	protected String DATEOFEFFECT;
	protected String DUEDATE;
	protected String GPFDATE;
	protected String CASHDATE;
	protected String PERCENTVALUE;
	protected String RULEORDERDATE;

	public String getSys_paycategoryid() {
		return sys_paycategoryid;
	}

	public void setSys_paycategoryid(String sys_paycategoryid) {
		this.sys_paycategoryid = sys_paycategoryid;
	}

	public String getPaycategory() {
		return paycategory;
	}

	public void setPaycategory(String paycategory) {
		this.paycategory = paycategory;
	}

	public String getPP_PAYALWMASTERID() {
		return PP_PAYALWMASTERID;
	}

	public void setPP_PAYALWMASTERID(String pP_PAYALWMASTERID) {
		PP_PAYALWMASTERID = pP_PAYALWMASTERID;
	}

	public String getRULEORDERNO() {
		return RULEORDERNO;
	}

	public void setRULEORDERNO(String rULEORDERNO) {
		RULEORDERNO = rULEORDERNO;
	}

	public String getDATEOFEFFECT() {
		return DATEOFEFFECT;
	}

	public void setDATEOFEFFECT(String dATEOFEFFECT) {
		DATEOFEFFECT = dATEOFEFFECT;
	}

	public String getDUEDATE() {
		return DUEDATE;
	}

	public void setDUEDATE(String dUEDATE) {
		DUEDATE = dUEDATE;
	}

	public String getGPFDATE() {
		return GPFDATE;
	}

	public void setGPFDATE(String gPFDATE) {
		GPFDATE = gPFDATE;
	}

	public String getCASHDATE() {
		return CASHDATE;
	}

	public void setCASHDATE(String cASHDATE) {
		CASHDATE = cASHDATE;
	}

	public String getPERCENTVALUE() {
		return PERCENTVALUE;
	}

	public void setPERCENTVALUE(String pERCENTVALUE) {
		PERCENTVALUE = pERCENTVALUE;
	}

	public String getRULEORDERDATE() {
		return RULEORDERDATE;
	}

	public void setRULEORDERDATE(String rULEORDERDATE) {
		RULEORDERDATE = rULEORDERDATE;
	}

}
