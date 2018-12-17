/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nicupjnentityclasses;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Saumitra-PC
 */
@Entity
@Table(name = "PP_SUSPENSIONDETAIL")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "PpSuspensiondetail.findAll", query = "SELECT p FROM PpSuspensiondetail p"),
		@NamedQuery(name = "PpSuspensiondetail.findByPpSuspensiondetailid", query = "SELECT p FROM PpSuspensiondetail p WHERE p.ppSuspensiondetailid = :ppSuspensiondetailid"),
		@NamedQuery(name = "PpSuspensiondetail.findBySuspensionordno", query = "SELECT p FROM PpSuspensiondetail p WHERE p.suspensionordno = :suspensionordno"),
		@NamedQuery(name = "PpSuspensiondetail.findBySuspensionorddate", query = "SELECT p FROM PpSuspensiondetail p WHERE p.suspensionorddate = :suspensionorddate"),
		@NamedQuery(name = "PpSuspensiondetail.findByOrderauthname", query = "SELECT p FROM PpSuspensiondetail p WHERE p.orderauthname = :orderauthname"),
		@NamedQuery(name = "PpSuspensiondetail.findByOrderauthdesig", query = "SELECT p FROM PpSuspensiondetail p WHERE p.orderauthdesig = :orderauthdesig"),
		@NamedQuery(name = "PpSuspensiondetail.findByEffectivedate", query = "SELECT p FROM PpSuspensiondetail p WHERE p.effectivedate = :effectivedate"),
		@NamedQuery(name = "PpSuspensiondetail.findByIsreinstate", query = "SELECT p FROM PpSuspensiondetail p WHERE p.isreinstate = :isreinstate"),
		@NamedQuery(name = "PpSuspensiondetail.findByReinstateorderdetail", query = "SELECT p FROM PpSuspensiondetail p WHERE p.reinstateorderdetail = :reinstateorderdetail"),
		@NamedQuery(name = "PpSuspensiondetail.findByReinstateeffectdate", query = "SELECT p FROM PpSuspensiondetail p WHERE p.reinstateeffectdate = :reinstateeffectdate"),
		@NamedQuery(name = "PpSuspensiondetail.findByIsterminated", query = "SELECT p FROM PpSuspensiondetail p WHERE p.isterminated = :isterminated"),
		@NamedQuery(name = "PpSuspensiondetail.findByReasonforsuspension", query = "SELECT p FROM PpSuspensiondetail p WHERE p.reasonforsuspension = :reasonforsuspension"),
		@NamedQuery(name = "PpSuspensiondetail.findByRelievingoffice", query = "SELECT p FROM PpSuspensiondetail p WHERE p.relievingoffice = :relievingoffice"),
		@NamedQuery(name = "PpSuspensiondetail.findByReportingdate", query = "SELECT p FROM PpSuspensiondetail p WHERE p.reportingdate = :reportingdate") })
public class PpSuspensiondetail implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@Column(name = "PP_SUSPENSIONDETAILID")
	private Long ppSuspensiondetailid;
	@Basic(optional = false)
	@Column(name = "SUSPENSIONORDNO")
	private String suspensionordno;
	@Basic(optional = false)
	@Column(name = "SUSPENSIONORDDATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date suspensionorddate;
	@Basic(optional = false)
	@Column(name = "ORDERAUTHNAME")
	private String orderauthname;
	@Basic(optional = false)
	@Column(name = "ORDERAUTHDESIG")
	private String orderauthdesig;
	@Basic(optional = false)
	@Column(name = "EFFECTIVEDATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date effectivedate;
	@Basic(optional = false)
	@Column(name = "ISREINSTATE")
	private String isreinstate;
	@Column(name = "REINSTATEORDERDETAIL")
	private String reinstateorderdetail;
	@Column(name = "REINSTATEEFFECTDATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date reinstateeffectdate;
	@Column(name = "ISTERMINATED")
	private String isterminated;
	@Column(name = "REASONFORSUSPENSION")
	private String reasonforsuspension;
	@Column(name = "RELIEVINGOFFICE")
	private String relievingoffice;
	@Column(name = "REPORTINGDATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date reportingdate;
	@JoinColumn(name = "PP_EMPLOYEEMASTERID", referencedColumnName = "PP_EMPLOYEEMASTERID")
	@ManyToOne(optional = false)
	private PpEmployeemaster ppEmployeemasterid;
	@JoinColumn(name = "EVENTOFFICEID", referencedColumnName = "RM_OFFICEID")
	@ManyToOne(optional = false)
	private RmOffice eventofficeid;
	@OneToMany(mappedBy = "ppSuspensiondetailid")
	private Collection<PpCurrentstatus> ppCurrentstatusCollection;

	public PpSuspensiondetail() {
	}

	public PpSuspensiondetail(Long ppSuspensiondetailid) {
		this.ppSuspensiondetailid = ppSuspensiondetailid;
	}

	public PpSuspensiondetail(Long ppSuspensiondetailid, String suspensionordno, Date suspensionorddate,
			String orderauthname, String orderauthdesig, Date effectivedate, String isreinstate) {
		this.ppSuspensiondetailid = ppSuspensiondetailid;
		this.suspensionordno = suspensionordno;
		this.suspensionorddate = suspensionorddate;
		this.orderauthname = orderauthname;
		this.orderauthdesig = orderauthdesig;
		this.effectivedate = effectivedate;
		this.isreinstate = isreinstate;
	}

	public Long getPpSuspensiondetailid() {
		return ppSuspensiondetailid;
	}

	public void setPpSuspensiondetailid(Long ppSuspensiondetailid) {
		this.ppSuspensiondetailid = ppSuspensiondetailid;
	}

	public String getSuspensionordno() {
		return suspensionordno;
	}

	public void setSuspensionordno(String suspensionordno) {
		this.suspensionordno = suspensionordno;
	}

	public Date getSuspensionorddate() {
		return suspensionorddate;
	}

	public void setSuspensionorddate(Date suspensionorddate) {
		this.suspensionorddate = suspensionorddate;
	}

	public String getOrderauthname() {
		return orderauthname;
	}

	public void setOrderauthname(String orderauthname) {
		this.orderauthname = orderauthname;
	}

	public String getOrderauthdesig() {
		return orderauthdesig;
	}

	public void setOrderauthdesig(String orderauthdesig) {
		this.orderauthdesig = orderauthdesig;
	}

	public Date getEffectivedate() {
		return effectivedate;
	}

	public void setEffectivedate(Date effectivedate) {
		this.effectivedate = effectivedate;
	}

	public String getIsreinstate() {
		return isreinstate;
	}

	public void setIsreinstate(String isreinstate) {
		this.isreinstate = isreinstate;
	}

	public String getReinstateorderdetail() {
		return reinstateorderdetail;
	}

	public void setReinstateorderdetail(String reinstateorderdetail) {
		this.reinstateorderdetail = reinstateorderdetail;
	}

	public Date getReinstateeffectdate() {
		return reinstateeffectdate;
	}

	public void setReinstateeffectdate(Date reinstateeffectdate) {
		this.reinstateeffectdate = reinstateeffectdate;
	}

	public String getIsterminated() {
		return isterminated;
	}

	public void setIsterminated(String isterminated) {
		this.isterminated = isterminated;
	}

	public String getReasonforsuspension() {
		return reasonforsuspension;
	}

	public void setReasonforsuspension(String reasonforsuspension) {
		this.reasonforsuspension = reasonforsuspension;
	}

	public String getRelievingoffice() {
		return relievingoffice;
	}

	public void setRelievingoffice(String relievingoffice) {
		this.relievingoffice = relievingoffice;
	}

	public Date getReportingdate() {
		return reportingdate;
	}

	public void setReportingdate(Date reportingdate) {
		this.reportingdate = reportingdate;
	}

	public PpEmployeemaster getPpEmployeemasterid() {
		return ppEmployeemasterid;
	}

	public void setPpEmployeemasterid(PpEmployeemaster ppEmployeemasterid) {
		this.ppEmployeemasterid = ppEmployeemasterid;
	}

	public RmOffice getEventofficeid() {
		return eventofficeid;
	}

	public void setEventofficeid(RmOffice eventofficeid) {
		this.eventofficeid = eventofficeid;
	}

	@XmlTransient
	public Collection<PpCurrentstatus> getPpCurrentstatusCollection() {
		return ppCurrentstatusCollection;
	}

	public void setPpCurrentstatusCollection(Collection<PpCurrentstatus> ppCurrentstatusCollection) {
		this.ppCurrentstatusCollection = ppCurrentstatusCollection;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (ppSuspensiondetailid != null ? ppSuspensiondetailid.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof PpSuspensiondetail)) {
			return false;
		}
		PpSuspensiondetail other = (PpSuspensiondetail) object;
		if ((this.ppSuspensiondetailid == null && other.ppSuspensiondetailid != null)
				|| (this.ppSuspensiondetailid != null
						&& !this.ppSuspensiondetailid.equals(other.ppSuspensiondetailid))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "nicupjnentityclasses.PpSuspensiondetail[ ppSuspensiondetailid=" + ppSuspensiondetailid + " ]";
	}

}
