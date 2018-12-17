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
@Table(name = "PP_RELIEVEFROMSERVICE")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "PpRelievefromservice.findAll", query = "SELECT p FROM PpRelievefromservice p"),
		@NamedQuery(name = "PpRelievefromservice.findByPpRelievefromserviceid", query = "SELECT p FROM PpRelievefromservice p WHERE p.ppRelievefromserviceid = :ppRelievefromserviceid"),
		@NamedQuery(name = "PpRelievefromservice.findByRelieveordno", query = "SELECT p FROM PpRelievefromservice p WHERE p.relieveordno = :relieveordno"),
		@NamedQuery(name = "PpRelievefromservice.findByRelieveorddate", query = "SELECT p FROM PpRelievefromservice p WHERE p.relieveorddate = :relieveorddate"),
		@NamedQuery(name = "PpRelievefromservice.findByDateofeffect", query = "SELECT p FROM PpRelievefromservice p WHERE p.dateofeffect = :dateofeffect"),
		@NamedQuery(name = "PpRelievefromservice.findByRelieveanfn", query = "SELECT p FROM PpRelievefromservice p WHERE p.relieveanfn = :relieveanfn"),
		@NamedQuery(name = "PpRelievefromservice.findByReferenceofrelieve", query = "SELECT p FROM PpRelievefromservice p WHERE p.referenceofrelieve = :referenceofrelieve"),
		@NamedQuery(name = "PpRelievefromservice.findByDateofreference", query = "SELECT p FROM PpRelievefromservice p WHERE p.dateofreference = :dateofreference") })
public class PpRelievefromservice implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@Column(name = "PP_RELIEVEFROMSERVICEID")
	private Long ppRelievefromserviceid;
	@Column(name = "RELIEVEORDNO")
	private String relieveordno;
	@Column(name = "RELIEVEORDDATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date relieveorddate;
	@Basic(optional = false)
	@Column(name = "DATEOFEFFECT")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateofeffect;
	@Column(name = "RELIEVEANFN")
	private String relieveanfn;
	@Column(name = "REFERENCEOFRELIEVE")
	private String referenceofrelieve;
	@Column(name = "DATEOFREFERENCE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateofreference;
	@JoinColumn(name = "PP_EMPLOYEEMASTERID", referencedColumnName = "PP_EMPLOYEEMASTERID")
	@ManyToOne(optional = false)
	private PpEmployeemaster ppEmployeemasterid;
	@JoinColumn(name = "PP_NODUESDETAILID", referencedColumnName = "PP_NODUESDETAILID")
	@ManyToOne
	private PpNoduesdetail ppNoduesdetailid;
	@JoinColumn(name = "RELIEVINGOFFICEID", referencedColumnName = "RM_OFFICEID")
	@ManyToOne(optional = false)
	private RmOffice relievingofficeid;
	@JoinColumn(name = "CAUSEOFRELIEVEID", referencedColumnName = "SYS_SUBSERVICEPHASEMASTERID")
	@ManyToOne(optional = false)
	private SysSubservicephasemaster causeofrelieveid;

	public PpRelievefromservice() {
	}

	public PpRelievefromservice(Long ppRelievefromserviceid) {
		this.ppRelievefromserviceid = ppRelievefromserviceid;
	}

	public PpRelievefromservice(Long ppRelievefromserviceid, Date dateofeffect) {
		this.ppRelievefromserviceid = ppRelievefromserviceid;
		this.dateofeffect = dateofeffect;
	}

	public Long getPpRelievefromserviceid() {
		return ppRelievefromserviceid;
	}

	public void setPpRelievefromserviceid(Long ppRelievefromserviceid) {
		this.ppRelievefromserviceid = ppRelievefromserviceid;
	}

	public String getRelieveordno() {
		return relieveordno;
	}

	public void setRelieveordno(String relieveordno) {
		this.relieveordno = relieveordno;
	}

	public Date getRelieveorddate() {
		return relieveorddate;
	}

	public void setRelieveorddate(Date relieveorddate) {
		this.relieveorddate = relieveorddate;
	}

	public Date getDateofeffect() {
		return dateofeffect;
	}

	public void setDateofeffect(Date dateofeffect) {
		this.dateofeffect = dateofeffect;
	}

	public String getRelieveanfn() {
		return relieveanfn;
	}

	public void setRelieveanfn(String relieveanfn) {
		this.relieveanfn = relieveanfn;
	}

	public String getReferenceofrelieve() {
		return referenceofrelieve;
	}

	public void setReferenceofrelieve(String referenceofrelieve) {
		this.referenceofrelieve = referenceofrelieve;
	}

	public Date getDateofreference() {
		return dateofreference;
	}

	public void setDateofreference(Date dateofreference) {
		this.dateofreference = dateofreference;
	}

	public PpEmployeemaster getPpEmployeemasterid() {
		return ppEmployeemasterid;
	}

	public void setPpEmployeemasterid(PpEmployeemaster ppEmployeemasterid) {
		this.ppEmployeemasterid = ppEmployeemasterid;
	}

	public PpNoduesdetail getPpNoduesdetailid() {
		return ppNoduesdetailid;
	}

	public void setPpNoduesdetailid(PpNoduesdetail ppNoduesdetailid) {
		this.ppNoduesdetailid = ppNoduesdetailid;
	}

	public RmOffice getRelievingofficeid() {
		return relievingofficeid;
	}

	public void setRelievingofficeid(RmOffice relievingofficeid) {
		this.relievingofficeid = relievingofficeid;
	}

	public SysSubservicephasemaster getCauseofrelieveid() {
		return causeofrelieveid;
	}

	public void setCauseofrelieveid(SysSubservicephasemaster causeofrelieveid) {
		this.causeofrelieveid = causeofrelieveid;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (ppRelievefromserviceid != null ? ppRelievefromserviceid.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof PpRelievefromservice)) {
			return false;
		}
		PpRelievefromservice other = (PpRelievefromservice) object;
		if ((this.ppRelievefromserviceid == null && other.ppRelievefromserviceid != null)
				|| (this.ppRelievefromserviceid != null
						&& !this.ppRelievefromserviceid.equals(other.ppRelievefromserviceid))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "nicupjnentityclasses.PpRelievefromservice[ ppRelievefromserviceid=" + ppRelievefromserviceid + " ]";
	}

}
