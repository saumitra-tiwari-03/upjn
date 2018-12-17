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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "PP_AVAILEDLEAVEDETAIL")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "PpAvailedleavedetail.findAll", query = "SELECT p FROM PpAvailedleavedetail p"),
		@NamedQuery(name = "PpAvailedleavedetail.findByPpAvailedleavedetailid", query = "SELECT p FROM PpAvailedleavedetail p WHERE p.ppAvailedleavedetailid = :ppAvailedleavedetailid"),
		@NamedQuery(name = "PpAvailedleavedetail.findByFromdate", query = "SELECT p FROM PpAvailedleavedetail p WHERE p.fromdate = :fromdate"),
		@NamedQuery(name = "PpAvailedleavedetail.findByTodate", query = "SELECT p FROM PpAvailedleavedetail p WHERE p.todate = :todate"),
		@NamedQuery(name = "PpAvailedleavedetail.findByTotaldays", query = "SELECT p FROM PpAvailedleavedetail p WHERE p.totaldays = :totaldays"),
		@NamedQuery(name = "PpAvailedleavedetail.findByGroundforleave", query = "SELECT p FROM PpAvailedleavedetail p WHERE p.groundforleave = :groundforleave"),
		@NamedQuery(name = "PpAvailedleavedetail.findByIsdebited", query = "SELECT p FROM PpAvailedleavedetail p WHERE p.isdebited = :isdebited"),
		@NamedQuery(name = "PpAvailedleavedetail.findByIsadvance", query = "SELECT p FROM PpAvailedleavedetail p WHERE p.isadvance = :isadvance"),
		@NamedQuery(name = "PpAvailedleavedetail.findByIsfullpayapplicable", query = "SELECT p FROM PpAvailedleavedetail p WHERE p.isfullpayapplicable = :isfullpayapplicable") })
public class PpAvailedleavedetail implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@Column(name = "PP_AVAILEDLEAVEDETAILID")
	private Long ppAvailedleavedetailid;
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
	@Column(name = "GROUNDFORLEAVE")
	private String groundforleave;
	@Basic(optional = false)
	@Column(name = "ISDEBITED")
	private Character isdebited;
	@Basic(optional = false)
	@Column(name = "ISADVANCE")
	private Character isadvance;
	@Column(name = "ISFULLPAYAPPLICABLE")
	private Character isfullpayapplicable;
	@JoinColumn(name = "PP_EMPLOYEEMASTERID", referencedColumnName = "PP_EMPLOYEEMASTERID")
	@ManyToOne(optional = false)
	private PpEmployeemaster ppEmployeemasterid;
	@JoinColumn(name = "PP_LEAVESANCTIONORDERID", referencedColumnName = "PP_LEAVESANCTIONORDERID")
	@ManyToOne(optional = false)
	private PpLeavesanctionorder ppLeavesanctionorderid;
	@JoinColumn(name = "SYS_LEAVETYPEMASTERID", referencedColumnName = "SYS_LEAVETYPEMASTERID")
	@ManyToOne(optional = false)
	private SysLeavetypemaster sysLeavetypemasterid;

	public PpAvailedleavedetail() {
	}

	public PpAvailedleavedetail(Long ppAvailedleavedetailid) {
		this.ppAvailedleavedetailid = ppAvailedleavedetailid;
	}

	public PpAvailedleavedetail(Long ppAvailedleavedetailid, Date fromdate, Date todate, long totaldays,
			String groundforleave, Character isdebited, Character isadvance) {
		this.ppAvailedleavedetailid = ppAvailedleavedetailid;
		this.fromdate = fromdate;
		this.todate = todate;
		this.totaldays = totaldays;
		this.groundforleave = groundforleave;
		this.isdebited = isdebited;
		this.isadvance = isadvance;
	}

	public Long getPpAvailedleavedetailid() {
		return ppAvailedleavedetailid;
	}

	public void setPpAvailedleavedetailid(Long ppAvailedleavedetailid) {
		this.ppAvailedleavedetailid = ppAvailedleavedetailid;
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

	public String getGroundforleave() {
		return groundforleave;
	}

	public void setGroundforleave(String groundforleave) {
		this.groundforleave = groundforleave;
	}

	public Character getIsdebited() {
		return isdebited;
	}

	public void setIsdebited(Character isdebited) {
		this.isdebited = isdebited;
	}

	public Character getIsadvance() {
		return isadvance;
	}

	public void setIsadvance(Character isadvance) {
		this.isadvance = isadvance;
	}

	public Character getIsfullpayapplicable() {
		return isfullpayapplicable;
	}

	public void setIsfullpayapplicable(Character isfullpayapplicable) {
		this.isfullpayapplicable = isfullpayapplicable;
	}

	public PpEmployeemaster getPpEmployeemasterid() {
		return ppEmployeemasterid;
	}

	public void setPpEmployeemasterid(PpEmployeemaster ppEmployeemasterid) {
		this.ppEmployeemasterid = ppEmployeemasterid;
	}

	public PpLeavesanctionorder getPpLeavesanctionorderid() {
		return ppLeavesanctionorderid;
	}

	public void setPpLeavesanctionorderid(PpLeavesanctionorder ppLeavesanctionorderid) {
		this.ppLeavesanctionorderid = ppLeavesanctionorderid;
	}

	public SysLeavetypemaster getSysLeavetypemasterid() {
		return sysLeavetypemasterid;
	}

	public void setSysLeavetypemasterid(SysLeavetypemaster sysLeavetypemasterid) {
		this.sysLeavetypemasterid = sysLeavetypemasterid;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (ppAvailedleavedetailid != null ? ppAvailedleavedetailid.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof PpAvailedleavedetail)) {
			return false;
		}
		PpAvailedleavedetail other = (PpAvailedleavedetail) object;
		if ((this.ppAvailedleavedetailid == null && other.ppAvailedleavedetailid != null)
				|| (this.ppAvailedleavedetailid != null
						&& !this.ppAvailedleavedetailid.equals(other.ppAvailedleavedetailid))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "nicupjnentityclasses.PpAvailedleavedetail[ ppAvailedleavedetailid=" + ppAvailedleavedetailid + " ]";
	}

}
