package com.nic.upjn.spring.entity;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;


@Entity
@Table(name = "PP_EMPLOYEEDEDCONTROLLER")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "PpEmployeededcontroller.findAll", query = "SELECT v FROM PpEmployeededcontroller v"),
	@NamedQuery(name = "PpEmployeededcontroller.findByPpEmployeemasterid", query = "FROM PpEmployeededcontroller WHERE ppEmployeemasterid = ?"),
	@NamedQuery(name = "PpEmployeededcontroller.findByppEmployeecontrollerid", query = "SELECT v FROM PpEmployeededcontroller v WHERE v.ppEmployeecontrollerid = :ppEmployeecontrollerid"),
	@NamedQuery(name = "PpEmployeededcontroller.findBypp_DeductionMasterID", query = "SELECT v FROM PpEmployeededcontroller v WHERE v.pp_DeductionMasterID = :pp_DeductionMasterID"),
	@NamedQuery(name = "PpEmployeededcontroller.findByAmnnt", query = "SELECT v FROM PpEmployeededcontroller v WHERE v.Amnnt = :Amnnt") })
public class PpEmployeededcontroller implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@Column(name = "PP_EMPLOYEEDEDCONTROLLERID")
	private Long ppEmployeecontrollerid;
	@Column(name = "PP_EMPLOYEEMASTERID")
	private Long ppEmployeemasterid;
	@Column(name = "PP_DEDUCTIONMASTERID")
	private Long pp_DeductionMasterID;
	@Column(name = "AMOUNT")
	private Long Amnnt;
	@Column(name = "STOPDEDUCTION")
	private String stopDed;

	public Long getPpEmployeecontrollerid() {
		return ppEmployeecontrollerid;
	}
	public void setPpEmployeecontrollerid(Long ppEmployeecontrollerid) {
		this.ppEmployeecontrollerid = ppEmployeecontrollerid;
	}
	public Long getPpEmployeemasterid() {
		return ppEmployeemasterid;
	}
	public void setPpEmployeemasterid(Long ppEmployeemasterid) {
		this.ppEmployeemasterid = ppEmployeemasterid;
	}
	public Long getPp_DeductionMasterID() {
		return pp_DeductionMasterID;
	}
	public void setPp_DeductionMasterID(Long pp_DeductionMasterID) {
		this.pp_DeductionMasterID = pp_DeductionMasterID;
	}
	public Long getAmnnt() {
		return Amnnt;
	}
	public void setAmnnt(Long amnnt) {
		Amnnt = amnnt;
	}

	public String getStopDed() {
		return stopDed;
	}
	public void setStopDed(String stopDed) {
		this.stopDed = stopDed;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
}
