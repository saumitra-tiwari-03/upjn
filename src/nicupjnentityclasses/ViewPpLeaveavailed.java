/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nicupjnentityclasses;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Saumitra-PC
 */
@Entity
@Table(name = "VIEW_PP_LEAVEAVAILED")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "ViewPpLeaveavailed.findAll", query = "SELECT v FROM ViewPpLeaveavailed v"),
		@NamedQuery(name = "ViewPpLeaveavailed.findByPpEmployeemasterid", query = "SELECT v FROM ViewPpLeaveavailed v WHERE v.ppEmployeemasterid = :ppEmployeemasterid"),
		@NamedQuery(name = "ViewPpLeaveavailed.findByFromdate", query = "SELECT v FROM ViewPpLeaveavailed v WHERE v.fromdate = :fromdate"),
		@NamedQuery(name = "ViewPpLeaveavailed.findByTodate", query = "SELECT v FROM ViewPpLeaveavailed v WHERE v.todate = :todate"),
		@NamedQuery(name = "ViewPpLeaveavailed.findByTotaldays", query = "SELECT v FROM ViewPpLeaveavailed v WHERE v.totaldays = :totaldays"),
		@NamedQuery(name = "ViewPpLeaveavailed.findBySanctionorderdate", query = "SELECT v FROM ViewPpLeaveavailed v WHERE v.sanctionorderdate = :sanctionorderdate"),
		@NamedQuery(name = "ViewPpLeaveavailed.findBySysLeavetypemasterid", query = "SELECT v FROM ViewPpLeaveavailed v WHERE v.sysLeavetypemasterid = :sysLeavetypemasterid"),
		@NamedQuery(name = "ViewPpLeaveavailed.findByPrebalancedate", query = "SELECT v FROM ViewPpLeaveavailed v WHERE v.prebalancedate = :prebalancedate"),
		@NamedQuery(name = "ViewPpLeaveavailed.findByPpAvailedleavedetailid", query = "SELECT v FROM ViewPpLeaveavailed v WHERE v.ppAvailedleavedetailid = :ppAvailedleavedetailid"),
		@NamedQuery(name = "ViewPpLeaveavailed.findByIsadvance", query = "SELECT v FROM ViewPpLeaveavailed v WHERE v.isadvance = :isadvance") })
public class ViewPpLeaveavailed implements Serializable {
	private static final long serialVersionUID = 1L;
	@Basic(optional = false)
	@Column(name = "PP_EMPLOYEEMASTERID")
	private long ppEmployeemasterid;
	@Basic(optional = false)
	@Column(name = "FROMDATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fromdate;
	@Basic(optional = false)
	@Column(name = "TODATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date todate;
	@Basic(optional = false)
	@Column(name = "TOTALDAYS")
	private long totaldays;
	@Basic(optional = false)
	@Column(name = "SANCTIONORDERDATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date sanctionorderdate;
	@Basic(optional = false)
	@Column(name = "SYS_LEAVETYPEMASTERID")
	private long sysLeavetypemasterid;
	@Column(name = "PREBALANCEDATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date prebalancedate;
	@Basic(optional = false)
	@Column(name = "PP_AVAILEDLEAVEDETAILID")
	private long ppAvailedleavedetailid;
	@Basic(optional = false)
	@Column(name = "ISADVANCE")
	private Character isadvance;

	public ViewPpLeaveavailed() {
	}

	public long getPpEmployeemasterid() {
		return ppEmployeemasterid;
	}

	public void setPpEmployeemasterid(long ppEmployeemasterid) {
		this.ppEmployeemasterid = ppEmployeemasterid;
	}

	public Date getFromdate() {
		return fromdate;
	}

	public void setFromdate(Date fromdate) {
		this.fromdate = fromdate;
	}

	public Date getTodate() {
		return todate;
	}

	public void setTodate(Date todate) {
		this.todate = todate;
	}

	public long getTotaldays() {
		return totaldays;
	}

	public void setTotaldays(long totaldays) {
		this.totaldays = totaldays;
	}

	public Date getSanctionorderdate() {
		return sanctionorderdate;
	}

	public void setSanctionorderdate(Date sanctionorderdate) {
		this.sanctionorderdate = sanctionorderdate;
	}

	public long getSysLeavetypemasterid() {
		return sysLeavetypemasterid;
	}

	public void setSysLeavetypemasterid(long sysLeavetypemasterid) {
		this.sysLeavetypemasterid = sysLeavetypemasterid;
	}

	public Date getPrebalancedate() {
		return prebalancedate;
	}

	public void setPrebalancedate(Date prebalancedate) {
		this.prebalancedate = prebalancedate;
	}

	public long getPpAvailedleavedetailid() {
		return ppAvailedleavedetailid;
	}

	public void setPpAvailedleavedetailid(long ppAvailedleavedetailid) {
		this.ppAvailedleavedetailid = ppAvailedleavedetailid;
	}

	public Character getIsadvance() {
		return isadvance;
	}

	public void setIsadvance(Character isadvance) {
		this.isadvance = isadvance;
	}

}
