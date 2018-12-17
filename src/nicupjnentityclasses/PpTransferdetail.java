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
@Table(name = "PP_TRANSFERDETAIL")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "PpTransferdetail.findAll", query = "SELECT p FROM PpTransferdetail p"),
		@NamedQuery(name = "PpTransferdetail.findByPpTransferdetailid", query = "SELECT p FROM PpTransferdetail p WHERE p.ppTransferdetailid = :ppTransferdetailid"),
		@NamedQuery(name = "PpTransferdetail.findByOfficefromid", query = "SELECT p FROM PpTransferdetail p WHERE p.officefromid = :officefromid"),
		@NamedQuery(name = "PpTransferdetail.findByRelieveorderdate", query = "SELECT p FROM PpTransferdetail p WHERE p.relieveorderdate = :relieveorderdate"),
		@NamedQuery(name = "PpTransferdetail.findByRelieveorderno", query = "SELECT p FROM PpTransferdetail p WHERE p.relieveorderno = :relieveorderno"),
		@NamedQuery(name = "PpTransferdetail.findByPpNoduesdetailid", query = "SELECT p FROM PpTransferdetail p WHERE p.ppNoduesdetailid = :ppNoduesdetailid"),
		@NamedQuery(name = "PpTransferdetail.findByTransferorderno", query = "SELECT p FROM PpTransferdetail p WHERE p.transferorderno = :transferorderno"),
		@NamedQuery(name = "PpTransferdetail.findByTransferorderdate", query = "SELECT p FROM PpTransferdetail p WHERE p.transferorderdate = :transferorderdate"),
		@NamedQuery(name = "PpTransferdetail.findByRelievedate", query = "SELECT p FROM PpTransferdetail p WHERE p.relievedate = :relievedate"),
		@NamedQuery(name = "PpTransferdetail.findByRelieveanfn", query = "SELECT p FROM PpTransferdetail p WHERE p.relieveanfn = :relieveanfn"),
		@NamedQuery(name = "PpTransferdetail.findByIsjoined", query = "SELECT p FROM PpTransferdetail p WHERE p.isjoined = :isjoined"),
		@NamedQuery(name = "PpTransferdetail.findByJoiningdate", query = "SELECT p FROM PpTransferdetail p WHERE p.joiningdate = :joiningdate"),
		@NamedQuery(name = "PpTransferdetail.findByJoininganfn", query = "SELECT p FROM PpTransferdetail p WHERE p.joininganfn = :joininganfn"),
		@NamedQuery(name = "PpTransferdetail.findByPpLpcdetailid", query = "SELECT p FROM PpTransferdetail p WHERE p.ppLpcdetailid = :ppLpcdetailid"),
		@NamedQuery(name = "PpTransferdetail.findByJoiningorder", query = "SELECT p FROM PpTransferdetail p WHERE p.joiningorder = :joiningorder"),
		@NamedQuery(name = "PpTransferdetail.findByJoiningorddate", query = "SELECT p FROM PpTransferdetail p WHERE p.joiningorddate = :joiningorddate"),
		@NamedQuery(name = "PpTransferdetail.findByIsonel", query = "SELECT p FROM PpTransferdetail p WHERE p.isonel = :isonel") })
public class PpTransferdetail implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@Column(name = "PP_TRANSFERDETAILID")
	private Long ppTransferdetailid;
	@Basic(optional = false)
	@Column(name = "OFFICEFROMID")
	private int officefromid;
	@Basic(optional = false)
	@Column(name = "RELIEVEORDERDATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date relieveorderdate;
	@Basic(optional = false)
	@Column(name = "RELIEVEORDERNO")
	private String relieveorderno;
	@Basic(optional = false)
	@Column(name = "PP_NODUESDETAILID")
	private long ppNoduesdetailid;
	@Basic(optional = false)
	@Column(name = "TRANSFERORDERNO")
	private String transferorderno;
	@Basic(optional = false)
	@Column(name = "TRANSFERORDERDATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date transferorderdate;
	@Basic(optional = false)
	@Column(name = "RELIEVEDATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date relievedate;
	@Basic(optional = false)
	@Column(name = "RELIEVEANFN")
	private String relieveanfn;
	@Basic(optional = false)
	@Column(name = "ISJOINED")
	private String isjoined;
	@Column(name = "JOININGDATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date joiningdate;
	@Column(name = "JOININGANFN")
	private String joininganfn;
	@Column(name = "PP_LPCDETAILID")
	private String ppLpcdetailid;
	@Column(name = "JOININGORDER")
	private String joiningorder;
	@Column(name = "JOININGORDDATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date joiningorddate;
	@Column(name = "ISONEL")
	private String isonel;
	@JoinColumn(name = "PP_EMPLOYEEMASTERID", referencedColumnName = "PP_EMPLOYEEMASTERID")
	@ManyToOne(optional = false)
	private PpEmployeemaster ppEmployeemasterid;
	@JoinColumn(name = "OFFICETOID", referencedColumnName = "RM_OFFICEID")
	@ManyToOne(optional = false)
	private RmOffice officetoid;

	public PpTransferdetail() {
	}

	public PpTransferdetail(Long ppTransferdetailid) {
		this.ppTransferdetailid = ppTransferdetailid;
	}

	public PpTransferdetail(Long ppTransferdetailid, int officefromid, Date relieveorderdate, String relieveorderno,
			long ppNoduesdetailid, String transferorderno, Date transferorderdate, Date relievedate, String relieveanfn,
			String isjoined) {
		this.ppTransferdetailid = ppTransferdetailid;
		this.officefromid = officefromid;
		this.relieveorderdate = relieveorderdate;
		this.relieveorderno = relieveorderno;
		this.ppNoduesdetailid = ppNoduesdetailid;
		this.transferorderno = transferorderno;
		this.transferorderdate = transferorderdate;
		this.relievedate = relievedate;
		this.relieveanfn = relieveanfn;
		this.isjoined = isjoined;
	}

	public Long getPpTransferdetailid() {
		return ppTransferdetailid;
	}

	public void setPpTransferdetailid(Long ppTransferdetailid) {
		this.ppTransferdetailid = ppTransferdetailid;
	}

	public int getOfficefromid() {
		return officefromid;
	}

	public void setOfficefromid(int officefromid) {
		this.officefromid = officefromid;
	}

	public Date getRelieveorderdate() {
		return relieveorderdate;
	}

	public void setRelieveorderdate(Date relieveorderdate) {
		this.relieveorderdate = relieveorderdate;
	}

	public String getRelieveorderno() {
		return relieveorderno;
	}

	public void setRelieveorderno(String relieveorderno) {
		this.relieveorderno = relieveorderno;
	}

	public long getPpNoduesdetailid() {
		return ppNoduesdetailid;
	}

	public void setPpNoduesdetailid(long ppNoduesdetailid) {
		this.ppNoduesdetailid = ppNoduesdetailid;
	}

	public String getTransferorderno() {
		return transferorderno;
	}

	public void setTransferorderno(String transferorderno) {
		this.transferorderno = transferorderno;
	}

	public Date getTransferorderdate() {
		return transferorderdate;
	}

	public void setTransferorderdate(Date transferorderdate) {
		this.transferorderdate = transferorderdate;
	}

	public Date getRelievedate() {
		return relievedate;
	}

	public void setRelievedate(Date relievedate) {
		this.relievedate = relievedate;
	}

	public String getRelieveanfn() {
		return relieveanfn;
	}

	public void setRelieveanfn(String relieveanfn) {
		this.relieveanfn = relieveanfn;
	}

	public String getIsjoined() {
		return isjoined;
	}

	public void setIsjoined(String isjoined) {
		this.isjoined = isjoined;
	}

	public Date getJoiningdate() {
		return joiningdate;
	}

	public void setJoiningdate(Date joiningdate) {
		this.joiningdate = joiningdate;
	}

	public String getJoininganfn() {
		return joininganfn;
	}

	public void setJoininganfn(String joininganfn) {
		this.joininganfn = joininganfn;
	}

	public String getPpLpcdetailid() {
		return ppLpcdetailid;
	}

	public void setPpLpcdetailid(String ppLpcdetailid) {
		this.ppLpcdetailid = ppLpcdetailid;
	}

	public String getJoiningorder() {
		return joiningorder;
	}

	public void setJoiningorder(String joiningorder) {
		this.joiningorder = joiningorder;
	}

	public Date getJoiningorddate() {
		return joiningorddate;
	}

	public void setJoiningorddate(Date joiningorddate) {
		this.joiningorddate = joiningorddate;
	}

	public String getIsonel() {
		return isonel;
	}

	public void setIsonel(String isonel) {
		this.isonel = isonel;
	}

	public PpEmployeemaster getPpEmployeemasterid() {
		return ppEmployeemasterid;
	}

	public void setPpEmployeemasterid(PpEmployeemaster ppEmployeemasterid) {
		this.ppEmployeemasterid = ppEmployeemasterid;
	}

	public RmOffice getOfficetoid() {
		return officetoid;
	}

	public void setOfficetoid(RmOffice officetoid) {
		this.officetoid = officetoid;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (ppTransferdetailid != null ? ppTransferdetailid.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof PpTransferdetail)) {
			return false;
		}
		PpTransferdetail other = (PpTransferdetail) object;
		if ((this.ppTransferdetailid == null && other.ppTransferdetailid != null)
				|| (this.ppTransferdetailid != null && !this.ppTransferdetailid.equals(other.ppTransferdetailid))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "nicupjnentityclasses.PpTransferdetail[ ppTransferdetailid=" + ppTransferdetailid + " ]";
	}

}
