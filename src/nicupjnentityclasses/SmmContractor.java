/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nicupjnentityclasses;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "SMM_CONTRACTOR")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "SmmContractor.findAll", query = "SELECT s FROM SmmContractor s"),
		@NamedQuery(name = "SmmContractor.findBySmmContractorid", query = "SELECT s FROM SmmContractor s WHERE s.smmContractorid = :smmContractorid"),
		@NamedQuery(name = "SmmContractor.findByContractor", query = "SELECT s FROM SmmContractor s WHERE s.contractor = :contractor"),
		@NamedQuery(name = "SmmContractor.findByAddress", query = "SELECT s FROM SmmContractor s WHERE s.address = :address"),
		@NamedQuery(name = "SmmContractor.findByPhone", query = "SELECT s FROM SmmContractor s WHERE s.phone = :phone"),
		@NamedQuery(name = "SmmContractor.findByFax", query = "SELECT s FROM SmmContractor s WHERE s.fax = :fax"),
		@NamedQuery(name = "SmmContractor.findByReferenceNo", query = "SELECT s FROM SmmContractor s WHERE s.referenceNo = :referenceNo"),
		@NamedQuery(name = "SmmContractor.findByPassingDate", query = "SELECT s FROM SmmContractor s WHERE s.passingDate = :passingDate"),
		@NamedQuery(name = "SmmContractor.findByPassingAuthority", query = "SELECT s FROM SmmContractor s WHERE s.passingAuthority = :passingAuthority"),
		@NamedQuery(name = "SmmContractor.findByContrClass", query = "SELECT s FROM SmmContractor s WHERE s.contrClass = :contrClass"),
		@NamedQuery(name = "SmmContractor.findByRegDate", query = "SELECT s FROM SmmContractor s WHERE s.regDate = :regDate"),
		@NamedQuery(name = "SmmContractor.findByRegExpDate", query = "SELECT s FROM SmmContractor s WHERE s.regExpDate = :regExpDate"),
		@NamedQuery(name = "SmmContractor.findByWorkArea", query = "SELECT s FROM SmmContractor s WHERE s.workArea = :workArea"),
		@NamedQuery(name = "SmmContractor.findByPermanentEarnMoney", query = "SELECT s FROM SmmContractor s WHERE s.permanentEarnMoney = :permanentEarnMoney") })
public class SmmContractor implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@Column(name = "SMM_CONTRACTORID")
	private Long smmContractorid;
	@Basic(optional = false)
	@Column(name = "CONTRACTOR")
	private String contractor;
	@Column(name = "ADDRESS")
	private String address;
	@Column(name = "PHONE")
	private String phone;
	@Column(name = "FAX")
	private String fax;
	@Column(name = "REFERENCE_NO")
	private String referenceNo;
	@Column(name = "PASSING_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date passingDate;
	@Column(name = "PASSING_AUTHORITY")
	private String passingAuthority;
	@Column(name = "CONTR_CLASS")
	private Character contrClass;
	@Column(name = "REG_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date regDate;
	@Column(name = "REG_EXP_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date regExpDate;
	@Column(name = "WORK_AREA")
	private String workArea;
	// @Max(value=?) @Min(value=?)//if you know range of your decimal fields
	// consider using these annotations to enforce field validation
	@Column(name = "PERMANENT_EARN_MONEY")
	private BigDecimal permanentEarnMoney;

	public SmmContractor() {
	}

	public SmmContractor(Long smmContractorid) {
		this.smmContractorid = smmContractorid;
	}

	public SmmContractor(Long smmContractorid, String contractor) {
		this.smmContractorid = smmContractorid;
		this.contractor = contractor;
	}

	public Long getSmmContractorid() {
		return smmContractorid;
	}

	public void setSmmContractorid(Long smmContractorid) {
		this.smmContractorid = smmContractorid;
	}

	public String getContractor() {
		return contractor;
	}

	public void setContractor(String contractor) {
		this.contractor = contractor;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getReferenceNo() {
		return referenceNo;
	}

	public void setReferenceNo(String referenceNo) {
		this.referenceNo = referenceNo;
	}

	public Date getPassingDate() {
		return passingDate;
	}

	public void setPassingDate(Date passingDate) {
		this.passingDate = passingDate;
	}

	public String getPassingAuthority() {
		return passingAuthority;
	}

	public void setPassingAuthority(String passingAuthority) {
		this.passingAuthority = passingAuthority;
	}

	public Character getContrClass() {
		return contrClass;
	}

	public void setContrClass(Character contrClass) {
		this.contrClass = contrClass;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public Date getRegExpDate() {
		return regExpDate;
	}

	public void setRegExpDate(Date regExpDate) {
		this.regExpDate = regExpDate;
	}

	public String getWorkArea() {
		return workArea;
	}

	public void setWorkArea(String workArea) {
		this.workArea = workArea;
	}

	public BigDecimal getPermanentEarnMoney() {
		return permanentEarnMoney;
	}

	public void setPermanentEarnMoney(BigDecimal permanentEarnMoney) {
		this.permanentEarnMoney = permanentEarnMoney;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (smmContractorid != null ? smmContractorid.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof SmmContractor)) {
			return false;
		}
		SmmContractor other = (SmmContractor) object;
		if ((this.smmContractorid == null && other.smmContractorid != null)
				|| (this.smmContractorid != null && !this.smmContractorid.equals(other.smmContractorid))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "nicupjnentityclasses.SmmContractor[ smmContractorid=" + smmContractorid + " ]";
	}

}
