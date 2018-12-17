/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

/**
 *
 * @author Saumitra-PC
 */
@Entity
@Table(name = "VIEW_PP_EMPALWLIST")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "ViewPpEmpalwlist.findAll", query = "SELECT v FROM ViewPpEmpalwlist v"),
		@NamedQuery(name = "ViewPpEmpalwlist.findByAlwname", query = "SELECT v FROM ViewPpEmpalwlist v WHERE v.alwname = :alwname"),
		@NamedQuery(name = "ViewPpEmpalwlist.findByAlwcategory", query = "SELECT v FROM ViewPpEmpalwlist v WHERE v.alwcategory = :alwcategory"),
		@NamedQuery(name = "ViewPpEmpalwlist.findByPpPayalwmasterid", query = "SELECT v FROM ViewPpEmpalwlist v WHERE v.ppPayalwmasterid = :ppPayalwmasterid"),
		@NamedQuery(name = "ViewPpEmpalwlist.findByPpEmployeemasterid", query = "SELECT v FROM ViewPpEmpalwlist v WHERE v.ppEmployeemasterid = :ppEmployeemasterid"),
		@NamedQuery(name = "ViewPpEmpalwlist.findBySysPaycategoryid", query = "SELECT v FROM ViewPpEmpalwlist v WHERE v.sysPaycategoryid = :sysPaycategoryid"),
		@NamedQuery(name = "ViewPpEmpalwlist.findByAmount", query = "SELECT v FROM ViewPpEmpalwlist v WHERE v.amount = :amount"),
		@NamedQuery(name = "ViewPpEmpalwlist.findByStopAlwFlag", query = "SELECT v FROM ViewPpEmpalwlist v WHERE v.stopAlwFlag = :stopAlwFlag") })
public class ViewPpEmpalwlist implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "ALWNAME")
	private String alwname;
	@Column(name = "ALWCATEGORY")
	private String alwcategory;
	@Basic(optional = false)
	@Column(name = "PP_PAYALWMASTERID")
	private int ppPayalwmasterid;
	@Basic(optional = false)
	@Column(name = "PP_EMPLOYEEMASTERID")
	private long ppEmployeemasterid;
	@Basic(optional = false)
	@Column(name = "SYS_PAYCATEGORYID")
	private short sysPaycategoryid;
	@Basic(optional = false)
	@Column(name = "AMOUNT")
	private long amount;
	@Basic(optional = false)
	@Column(name = "STOP_ALW_FLAG")
	private Character stopAlwFlag;

	public ViewPpEmpalwlist() {
	}

	public String getAlwname() {
		return alwname;
	}

	public void setAlwname(String alwname) {
		this.alwname = alwname;
	}

	public String getAlwcategory() {
		return alwcategory;
	}

	public void setAlwcategory(String alwcategory) {
		this.alwcategory = alwcategory;
	}

	public int getPpPayalwmasterid() {
		return ppPayalwmasterid;
	}

	public void setPpPayalwmasterid(int ppPayalwmasterid) {
		this.ppPayalwmasterid = ppPayalwmasterid;
	}

	public long getPpEmployeemasterid() {
		return ppEmployeemasterid;
	}

	public void setPpEmployeemasterid(long ppEmployeemasterid) {
		this.ppEmployeemasterid = ppEmployeemasterid;
	}

	public short getSysPaycategoryid() {
		return sysPaycategoryid;
	}

	public void setSysPaycategoryid(short sysPaycategoryid) {
		this.sysPaycategoryid = sysPaycategoryid;
	}

	public long getAmount() {
		return amount;
	}

	public void setAmount(long amount) {
		this.amount = amount;
	}

	public Character getStopAlwFlag() {
		return stopAlwFlag;
	}

	public void setStopAlwFlag(Character stopAlwFlag) {
		this.stopAlwFlag = stopAlwFlag;
	}

}
