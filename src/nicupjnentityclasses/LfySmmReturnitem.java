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
@Table(name = "LFY_SMM_RETURNITEM")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "LfySmmReturnitem.findAll", query = "SELECT l FROM LfySmmReturnitem l"),
		@NamedQuery(name = "LfySmmReturnitem.findByLfySmmReturnitemid", query = "SELECT l FROM LfySmmReturnitem l WHERE l.lfySmmReturnitemid = :lfySmmReturnitemid"),
		@NamedQuery(name = "LfySmmReturnitem.findByReturnto", query = "SELECT l FROM LfySmmReturnitem l WHERE l.returnto = :returnto"),
		@NamedQuery(name = "LfySmmReturnitem.findByReason", query = "SELECT l FROM LfySmmReturnitem l WHERE l.reason = :reason"),
		@NamedQuery(name = "LfySmmReturnitem.findByReasondescription", query = "SELECT l FROM LfySmmReturnitem l WHERE l.reasondescription = :reasondescription"),
		@NamedQuery(name = "LfySmmReturnitem.findBySpSchememasterid", query = "SELECT l FROM LfySmmReturnitem l WHERE l.spSchememasterid = :spSchememasterid"),
		@NamedQuery(name = "LfySmmReturnitem.findByReferenceletterno", query = "SELECT l FROM LfySmmReturnitem l WHERE l.referenceletterno = :referenceletterno"),
		@NamedQuery(name = "LfySmmReturnitem.findByDtrno", query = "SELECT l FROM LfySmmReturnitem l WHERE l.dtrno = :dtrno"),
		@NamedQuery(name = "LfySmmReturnitem.findBySmmItemmasterid", query = "SELECT l FROM LfySmmReturnitem l WHERE l.smmItemmasterid = :smmItemmasterid"),
		@NamedQuery(name = "LfySmmReturnitem.findByQuantity", query = "SELECT l FROM LfySmmReturnitem l WHERE l.quantity = :quantity"),
		@NamedQuery(name = "LfySmmReturnitem.findByCost", query = "SELECT l FROM LfySmmReturnitem l WHERE l.cost = :cost"),
		@NamedQuery(name = "LfySmmReturnitem.findByRate", query = "SELECT l FROM LfySmmReturnitem l WHERE l.rate = :rate"),
		@NamedQuery(name = "LfySmmReturnitem.findByVoucherno", query = "SELECT l FROM LfySmmReturnitem l WHERE l.voucherno = :voucherno"),
		@NamedQuery(name = "LfySmmReturnitem.findByReferencedate", query = "SELECT l FROM LfySmmReturnitem l WHERE l.referencedate = :referencedate"),
		@NamedQuery(name = "LfySmmReturnitem.findBySmmReturnitemid", query = "SELECT l FROM LfySmmReturnitem l WHERE l.smmReturnitemid = :smmReturnitemid"),
		@NamedQuery(name = "LfySmmReturnitem.findByFinancialyear", query = "SELECT l FROM LfySmmReturnitem l WHERE l.financialyear = :financialyear") })
public class LfySmmReturnitem implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@Column(name = "LFY_SMM_RETURNITEMID")
	private Long lfySmmReturnitemid;
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
	@Basic(optional = false)
	@Column(name = "SMM_RETURNITEMID")
	private long smmReturnitemid;
	@Basic(optional = false)
	@Column(name = "FINANCIALYEAR")
	private String financialyear;

	public LfySmmReturnitem() {
	}

	public LfySmmReturnitem(Long lfySmmReturnitemid) {
		this.lfySmmReturnitemid = lfySmmReturnitemid;
	}

	public LfySmmReturnitem(Long lfySmmReturnitemid, Character returnto, Character reason, String reasondescription,
			long spSchememasterid, String dtrno, long smmItemmasterid, long quantity, String voucherno,
			long smmReturnitemid, String financialyear) {
		this.lfySmmReturnitemid = lfySmmReturnitemid;
		this.returnto = returnto;
		this.reason = reason;
		this.reasondescription = reasondescription;
		this.spSchememasterid = spSchememasterid;
		this.dtrno = dtrno;
		this.smmItemmasterid = smmItemmasterid;
		this.quantity = quantity;
		this.voucherno = voucherno;
		this.smmReturnitemid = smmReturnitemid;
		this.financialyear = financialyear;
	}

	public Long getLfySmmReturnitemid() {
		return lfySmmReturnitemid;
	}

	public void setLfySmmReturnitemid(Long lfySmmReturnitemid) {
		this.lfySmmReturnitemid = lfySmmReturnitemid;
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

	public long getSmmReturnitemid() {
		return smmReturnitemid;
	}

	public void setSmmReturnitemid(long smmReturnitemid) {
		this.smmReturnitemid = smmReturnitemid;
	}

	public String getFinancialyear() {
		return financialyear;
	}

	public void setFinancialyear(String financialyear) {
		this.financialyear = financialyear;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (lfySmmReturnitemid != null ? lfySmmReturnitemid.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof LfySmmReturnitem)) {
			return false;
		}
		LfySmmReturnitem other = (LfySmmReturnitem) object;
		if ((this.lfySmmReturnitemid == null && other.lfySmmReturnitemid != null)
				|| (this.lfySmmReturnitemid != null && !this.lfySmmReturnitemid.equals(other.lfySmmReturnitemid))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "nicupjnentityclasses.LfySmmReturnitem[ lfySmmReturnitemid=" + lfySmmReturnitemid + " ]";
	}

}
