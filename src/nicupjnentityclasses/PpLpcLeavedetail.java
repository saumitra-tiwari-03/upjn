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
@Table(name = "PP_LPC_LEAVEDETAIL")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "PpLpcLeavedetail.findAll", query = "SELECT p FROM PpLpcLeavedetail p"),
		@NamedQuery(name = "PpLpcLeavedetail.findByPpLpcLeavedetailid", query = "SELECT p FROM PpLpcLeavedetail p WHERE p.ppLpcLeavedetailid = :ppLpcLeavedetailid"),
		@NamedQuery(name = "PpLpcLeavedetail.findByFromdate", query = "SELECT p FROM PpLpcLeavedetail p WHERE p.fromdate = :fromdate"),
		@NamedQuery(name = "PpLpcLeavedetail.findByTodate", query = "SELECT p FROM PpLpcLeavedetail p WHERE p.todate = :todate"),
		@NamedQuery(name = "PpLpcLeavedetail.findByRate", query = "SELECT p FROM PpLpcLeavedetail p WHERE p.rate = :rate"),
		@NamedQuery(name = "PpLpcLeavedetail.findByAmount", query = "SELECT p FROM PpLpcLeavedetail p WHERE p.amount = :amount"),
		@NamedQuery(name = "PpLpcLeavedetail.findByType", query = "SELECT p FROM PpLpcLeavedetail p WHERE p.type = :type"),
		@NamedQuery(name = "PpLpcLeavedetail.findByAccount", query = "SELECT p FROM PpLpcLeavedetail p WHERE p.account = :account") })
public class PpLpcLeavedetail implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@Column(name = "PP_LPC_LEAVEDETAILID")
	private Integer ppLpcLeavedetailid;
	@Basic(optional = false)
	@Column(name = "FROMDATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fromdate;
	@Basic(optional = false)
	@Column(name = "TODATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date todate;
	@Column(name = "RATE")
	private Integer rate;
	@Basic(optional = false)
	@Column(name = "AMOUNT")
	private int amount;
	@Basic(optional = false)
	@Column(name = "TYPE")
	private Character type;
	@Column(name = "ACCOUNT")
	private Long account;
	@JoinColumn(name = "PP_LPCDETAILID", referencedColumnName = "PP_LPCDETAILID")
	@ManyToOne(optional = false)
	private PpLpcdetail ppLpcdetailid;

	public PpLpcLeavedetail() {
	}

	public PpLpcLeavedetail(Integer ppLpcLeavedetailid) {
		this.ppLpcLeavedetailid = ppLpcLeavedetailid;
	}

	public PpLpcLeavedetail(Integer ppLpcLeavedetailid, Date fromdate, Date todate, int amount, Character type) {
		this.ppLpcLeavedetailid = ppLpcLeavedetailid;
		this.fromdate = fromdate;
		this.todate = todate;
		this.amount = amount;
		this.type = type;
	}

	public Integer getPpLpcLeavedetailid() {
		return ppLpcLeavedetailid;
	}

	public void setPpLpcLeavedetailid(Integer ppLpcLeavedetailid) {
		this.ppLpcLeavedetailid = ppLpcLeavedetailid;
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

	public Integer getRate() {
		return rate;
	}

	public void setRate(Integer rate) {
		this.rate = rate;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public Character getType() {
		return type;
	}

	public void setType(Character type) {
		this.type = type;
	}

	public Long getAccount() {
		return account;
	}

	public void setAccount(Long account) {
		this.account = account;
	}

	public PpLpcdetail getPpLpcdetailid() {
		return ppLpcdetailid;
	}

	public void setPpLpcdetailid(PpLpcdetail ppLpcdetailid) {
		this.ppLpcdetailid = ppLpcdetailid;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (ppLpcLeavedetailid != null ? ppLpcLeavedetailid.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof PpLpcLeavedetail)) {
			return false;
		}
		PpLpcLeavedetail other = (PpLpcLeavedetail) object;
		if ((this.ppLpcLeavedetailid == null && other.ppLpcLeavedetailid != null)
				|| (this.ppLpcLeavedetailid != null && !this.ppLpcLeavedetailid.equals(other.ppLpcLeavedetailid))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "nicupjnentityclasses.PpLpcLeavedetail[ ppLpcLeavedetailid=" + ppLpcLeavedetailid + " ]";
	}

}
