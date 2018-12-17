/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nic.upjn.spring.entity;

import java.io.Serializable;
import java.math.BigInteger;

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
@Table(name = "VIEW_PP_NPS_VALID")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "ViewPpNpsValid.findAll", query = "SELECT v FROM ViewPpNpsValid v"),
		@NamedQuery(name = "ViewPpNpsValid.findByPpEmployeemasterid", query = "FROM ViewPpNpsValid WHERE ppEmployeemasterid = ?"),
		@NamedQuery(name = "ViewPpNpsValid.findByIsnpsvalid", query = "SELECT v FROM ViewPpNpsValid v WHERE v.isnpsvalid = :isnpsvalid") })
public class ViewPpNpsValid implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@Column(name = "PP_EMPLOYEEMASTERID")
	private long ppEmployeemasterid;
	@Column(name = "ISNPSVALID")
	private BigInteger isnpsvalid;

	public ViewPpNpsValid() {
	}

	public long getPpEmployeemasterid() {
		return ppEmployeemasterid;
	}

	public void setPpEmployeemasterid(long ppEmployeemasterid) {
		this.ppEmployeemasterid = ppEmployeemasterid;
	}

	public BigInteger getIsnpsvalid() {
		return isnpsvalid;
	}

	public void setIsnpsvalid(BigInteger isnpsvalid) {
		this.isnpsvalid = isnpsvalid;
	}

}
