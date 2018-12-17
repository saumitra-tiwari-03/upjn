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
@Table(name = "SMM_RETURNITEM")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "SmmReturnitem.findAll", query = "SELECT s FROM SmmReturnitem s"),
		@NamedQuery(name = "SmmReturnitem.findBySmmReturnitemid", query = "SELECT s FROM SmmReturnitem s WHERE s.smmReturnitemid = :smmReturnitemid"),
		@NamedQuery(name = "SmmReturnitem.findByReturnto", query = "SELECT s FROM SmmReturnitem s WHERE s.returnto = :returnto"),
		@NamedQuery(name = "SmmReturnitem.findByReason", query = "SELECT s FROM SmmReturnitem s WHERE s.reason = :reason"),
		@NamedQuery(name = "SmmReturnitem.findByReasondescription", query = "SELECT s FROM SmmReturnitem s WHERE s.reasondescription = :reasondescription"),
		@NamedQuery(name = "SmmReturnitem.findBySpSchememasterid", query = "SELECT s FROM SmmReturnitem s WHERE s.spSchememasterid = :spSchememasterid"),
		@NamedQuery(name = "SmmReturnitem.findByReferenceletterno", query = "SELECT s FROM SmmReturnitem s WHERE s.referenceletterno = :referenceletterno"),
		@NamedQuery(name = "SmmReturnitem.findByDtrno", query = "SELECT s FROM SmmReturnitem s WHERE s.dtrno = :dtrno"),
		@NamedQuery(name = "SmmReturnitem.findBySmmItemmasterid", query = "SELECT s FROM SmmReturnitem s WHERE s.smmItemmasterid = :smmItemmasterid"),
		@NamedQuery(name = "SmmReturnitem.findByQuantity", query = "SELECT s FROM SmmReturnitem s WHERE s.quantity = :quantity"),
		@NamedQuery(name = "SmmReturnitem.findByCost", query = "SELECT s FROM SmmReturnitem s WHERE s.cost = :cost"),
		@NamedQuery(name = "SmmReturnitem.findByRate", query = "SELECT s FROM SmmReturnitem s WHERE s.rate = :rate"),
		@NamedQuery(name = "SmmReturnitem.findByVoucherno", query = "SELECT s FROM SmmReturnitem s WHERE s.voucherno = :voucherno"),
		@NamedQuery(name = "SmmReturnitem.findByReferencedate", query = "SELECT s FROM SmmReturnitem s WHERE s.referencedate = :referencedate") })
public class SmmReturnitem implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@Column(name = "SMM_RETURNITEMID")
	private Long smmReturnitemid;
	@Basic(optional = false)
	@Column(name = "RETURNTO")
	private Character returnto;
	@Basic(optional = false)
	@Column(name = "REASON")
	private Character reason;
	@Basic(optional = false)
	@Column(name = "REASONDESCRIPTION")
	private String reasondescription;
	@Basic(optional = false)
	@Column(name = "SP_SCHEMEMASTERID")
	private long spSchememasterid;
	@Column(name = "REFERENCELETTERNO")
	private String referenceletterno;
	@Basic(optional = false)
	@Column(name = "DTRNO")
	private String dtrno;
	@Basic(optional = false)
	@Column(name = "SMM_ITEMMASTERID")
	private long smmItemmasterid;
	@Basic(optional = false)
	@Column(name = "QUANTITY")
	private long quantity;
	// @Max(value=?) @Min(value=?)//if you know range of your decimal fields
	// consider using these annotations to enforce field validation
	@Column(name = "COST")
	private BigDecimal cost;
	@Column(name = "RATE")
	private BigDecimal rate;
	@Basic(optional = false)
	@Column(name = "VOUCHERNO")
	private String voucherno;
	@Column(name = "REFERENCEDATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date referencedate;

	public SmmReturnitem() {
	}

	public SmmReturnitem(Long smmReturnitemid) {
		this.smmReturnitemid = smmReturnitemid;
	}

	public SmmReturnitem(Long smmReturnitemid, Character returnto, Character reason, String reasondescription,
			long spSchememasterid, String dtrno, long smmItemmasterid, long quantity, String voucherno) {
		this.smmReturnitemid = smmReturnitemid;
		this.returnto = returnto;
		this.reason = reason;
		this.reasondescription = reasondescription;
		this.spSchememasterid = spSchememasterid;
		this.dtrno = dtrno;
		this.smmItemmasterid = smmItemmasterid;
		this.quantity = quantity;
		this.voucherno = voucherno;
	}

	public Long getSmmReturnitemid() {
		return smmReturnitemid;
	}

	public void setSmmReturnitemid(Long smmReturnitemid) {
		this.smmReturnitemid = smmReturnitemid;
	}

	public Character getReturnto() {
		return returnto;
	}

	public void setReturnto(Character returnto) {
		this.returnto = returnto;
	}

	public Character getReason() {
		return reason;
	}

	public void setReason(Character reason) {
		this.reason = reason;
	}

	public String getReasondescription() {
		return reasondescription;
	}

	public void setReasondescription(String reasondescription) {
		this.reasondescription = reasondescription;
	}

	public long getSpSchememasterid() {
		return spSchememasterid;
	}

	public void setSpSchememasterid(long spSchememasterid) {
		this.spSchememasterid = spSchememasterid;
	}

	public String getReferenceletterno() {
		return referenceletterno;
	}

	public void setReferenceletterno(String referenceletterno) {
		this.referenceletterno = referenceletterno;
	}

	public String getDtrno() {
		return dtrno;
	}

	public void setDtrno(String dtrno) {
		this.dtrno = dtrno;
	}

	public long getSmmItemmasterid() {
		return smmItemmasterid;
	}

	public void setSmmItemmasterid(long smmItemmasterid) {
		this.smmItemmasterid = smmItemmasterid;
	}

	public long getQuantity() {
		return quantity;
	}

	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getCost() {
		return cost;
	}

	public void setCost(BigDecimal cost) {
		this.cost = cost;
	}

	public BigDecimal getRate() {
		return rate;
	}

	public void setRate(BigDecimal rate) {
		this.rate = rate;
	}

	public String getVoucherno() {
		return voucherno;
	}

	public void setVoucherno(String voucherno) {
		this.voucherno = voucherno;
	}

	public Date getReferencedate() {
		return referencedate;
	}

	public void setReferencedate(Date referencedate) {
		this.referencedate = referencedate;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (smmReturnitemid != null ? smmReturnitemid.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof SmmReturnitem)) {
			return false;
		}
		SmmReturnitem other = (SmmReturnitem) object;
		if ((this.smmReturnitemid == null && other.smmReturnitemid != null)
				|| (this.smmReturnitemid != null && !this.smmReturnitemid.equals(other.smmReturnitemid))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "nicupjnentityclasses.SmmReturnitem[ smmReturnitemid=" + smmReturnitemid + " ]";
	}

}
