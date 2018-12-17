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
@Table(name = "VIEW_PP_ALLALWLIST")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "ViewPpAllalwlist.findAll", query = "SELECT v FROM ViewPpAllalwlist v"),
		@NamedQuery(name = "ViewPpAllalwlist.findByAlwname", query = "SELECT v FROM ViewPpAllalwlist v WHERE v.alwname = :alwname"),
		@NamedQuery(name = "ViewPpAllalwlist.findByAlwcategory", query = "SELECT v FROM ViewPpAllalwlist v WHERE v.alwcategory = :alwcategory"),
		@NamedQuery(name = "ViewPpAllalwlist.findByPpPayalwmasterid", query = "SELECT v FROM ViewPpAllalwlist v WHERE v.ppPayalwmasterid = :ppPayalwmasterid"),
		@NamedQuery(name = "ViewPpAllalwlist.findByPpEmployeemasterid", query = "SELECT v FROM ViewPpAllalwlist v WHERE v.ppEmployeemasterid = :ppEmployeemasterid"),
		@NamedQuery(name = "ViewPpAllalwlist.findBySysPaycategoryid", query = "SELECT v FROM ViewPpAllalwlist v WHERE v.sysPaycategoryid = :sysPaycategoryid") })
public class ViewPpAllalwlist implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "ALWNAME")
	private String alwname;
	@Column(name = "ALWCATEGORY")
	private String alwcategory;
	@Basic(optional = false)
	@Column(name = "PP_PAYALWMASTERID")
	private int ppPayalwmasterid;
	@Column(name = "PP_EMPLOYEEMASTERID")
	private String ppEmployeemasterid;
	@Basic(optional = false)
	@Column(name = "SYS_PAYCATEGORYID")
	private short sysPaycategoryid;
	@Basic(optional = false)
	@Column(name = "AMOUNT")
	private int amount;
	@Basic(optional = false)
	@Column(name = "STOP_ALW_FLAG")
	private char stopalwflag;

	public ViewPpAllalwlist() {
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

	public String getPpEmployeemasterid() {
		return ppEmployeemasterid;
	}

	public void setPpEmployeemasterid(String ppEmployeemasterid) {
		this.ppEmployeemasterid = ppEmployeemasterid;
	}

	public short getSysPaycategoryid() {
		return sysPaycategoryid;
	}

	public void setSysPaycategoryid(short sysPaycategoryid) {
		this.sysPaycategoryid = sysPaycategoryid;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public char getStopalwflag() {
		return stopalwflag;
	}

	public void setStopalwflag(char stopalwflag) {
		this.stopalwflag = stopalwflag;
	}
}
