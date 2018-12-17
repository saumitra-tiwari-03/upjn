/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nicupjnentityclasses;

import java.io.Serializable;

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
@Table(name = "LFY_PP_MONTHLYPAY")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "LfyPpMonthlypay.findAll", query = "SELECT l FROM LfyPpMonthlypay l"),
		@NamedQuery(name = "LfyPpMonthlypay.findByLfyPpMonthlypayid", query = "SELECT l FROM LfyPpMonthlypay l WHERE l.lfyPpMonthlypayid = :lfyPpMonthlypayid"),
		@NamedQuery(name = "LfyPpMonthlypay.findByPpEmployeemasterid", query = "SELECT l FROM LfyPpMonthlypay l WHERE l.ppEmployeemasterid = :ppEmployeemasterid"),
		@NamedQuery(name = "LfyPpMonthlypay.findByPayscale", query = "SELECT l FROM LfyPpMonthlypay l WHERE l.payscale = :payscale"),
		@NamedQuery(name = "LfyPpMonthlypay.findByNoofdays", query = "SELECT l FROM LfyPpMonthlypay l WHERE l.noofdays = :noofdays"),
		@NamedQuery(name = "LfyPpMonthlypay.findByPayyear", query = "SELECT l FROM LfyPpMonthlypay l WHERE l.payyear = :payyear"),
		@NamedQuery(name = "LfyPpMonthlypay.findByPaymonth", query = "SELECT l FROM LfyPpMonthlypay l WHERE l.paymonth = :paymonth"),
		@NamedQuery(name = "LfyPpMonthlypay.findByPpRegistermasterid", query = "SELECT l FROM LfyPpMonthlypay l WHERE l.ppRegistermasterid = :ppRegistermasterid"),
		@NamedQuery(name = "LfyPpMonthlypay.findByPpPaybilldetailid", query = "SELECT l FROM LfyPpMonthlypay l WHERE l.ppPaybilldetailid = :ppPaybilldetailid"),
		@NamedQuery(name = "LfyPpMonthlypay.findByPpNetpay", query = "SELECT l FROM LfyPpMonthlypay l WHERE l.ppNetpay = :ppNetpay"),
		@NamedQuery(name = "LfyPpMonthlypay.findByPpMonthlypayid", query = "SELECT l FROM LfyPpMonthlypay l WHERE l.ppMonthlypayid = :ppMonthlypayid"),
		@NamedQuery(name = "LfyPpMonthlypay.findByFinancialyear", query = "SELECT l FROM LfyPpMonthlypay l WHERE l.financialyear = :financialyear") })
public class LfyPpMonthlypay implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@Column(name = "LFY_PP_MONTHLYPAYID")
	private Long lfyPpMonthlypayid;
	@Basic(optional = false)
	@Column(name = "PP_EMPLOYEEMASTERID")
	private long ppEmployeemasterid;
	@Column(name = "PAYSCALE")
	private String payscale;
	@Column(name = "NOOFDAYS")
	private Long noofdays;
	@Basic(optional = false)
	@Column(name = "PAYYEAR")
	private long payyear;
	@Basic(optional = false)
	@Column(name = "PAYMONTH")
	private long paymonth;
	@Basic(optional = false)
	@Column(name = "PP_REGISTERMASTERID")
	private long ppRegistermasterid;
	@Basic(optional = false)
	@Column(name = "PP_PAYBILLDETAILID")
	private int ppPaybilldetailid;
	@Basic(optional = false)
	@Column(name = "PP_NETPAY")
	private int ppNetpay;
	@Basic(optional = false)
	@Column(name = "PP_MONTHLYPAYID")
	private long ppMonthlypayid;
	@Basic(optional = false)
	@Column(name = "FINANCIALYEAR")
	private String financialyear;

	public LfyPpMonthlypay() {
	}

	public LfyPpMonthlypay(Long lfyPpMonthlypayid) {
		this.lfyPpMonthlypayid = lfyPpMonthlypayid;
	}

	public LfyPpMonthlypay(Long lfyPpMonthlypayid, long ppEmployeemasterid, long payyear, long paymonth,
			long ppRegistermasterid, int ppPaybilldetailid, int ppNetpay, long ppMonthlypayid, String financialyear) {
		this.lfyPpMonthlypayid = lfyPpMonthlypayid;
		this.ppEmployeemasterid = ppEmployeemasterid;
		this.payyear = payyear;
		this.paymonth = paymonth;
		this.ppRegistermasterid = ppRegistermasterid;
		this.ppPaybilldetailid = ppPaybilldetailid;
		this.ppNetpay = ppNetpay;
		this.ppMonthlypayid = ppMonthlypayid;
		this.financialyear = financialyear;
	}

	public Long getLfyPpMonthlypayid() {
		return lfyPpMonthlypayid;
	}

	public void setLfyPpMonthlypayid(Long lfyPpMonthlypayid) {
		this.lfyPpMonthlypayid = lfyPpMonthlypayid;
	}

	public long getPpEmployeemasterid() {
		return ppEmployeemasterid;
	}

	public void setPpEmployeemasterid(long ppEmployeemasterid) {
		this.ppEmployeemasterid = ppEmployeemasterid;
	}

	public String getPayscale() {
		return payscale;
	}

	public void setPayscale(String payscale) {
		this.payscale = payscale;
	}

	public Long getNoofdays() {
		return noofdays;
	}

	public void setNoofdays(Long noofdays) {
		this.noofdays = noofdays;
	}

	public long getPayyear() {
		return payyear;
	}

	public void setPayyear(long payyear) {
		this.payyear = payyear;
	}

	public long getPaymonth() {
		return paymonth;
	}

	public void setPaymonth(long paymonth) {
		this.paymonth = paymonth;
	}

	public long getPpRegistermasterid() {
		return ppRegistermasterid;
	}

	public void setPpRegistermasterid(long ppRegistermasterid) {
		this.ppRegistermasterid = ppRegistermasterid;
	}

	public int getPpPaybilldetailid() {
		return ppPaybilldetailid;
	}

	public void setPpPaybilldetailid(int ppPaybilldetailid) {
		this.ppPaybilldetailid = ppPaybilldetailid;
	}

	public int getPpNetpay() {
		return ppNetpay;
	}

	public void setPpNetpay(int ppNetpay) {
		this.ppNetpay = ppNetpay;
	}

	public long getPpMonthlypayid() {
		return ppMonthlypayid;
	}

	public void setPpMonthlypayid(long ppMonthlypayid) {
		this.ppMonthlypayid = ppMonthlypayid;
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
		hash += (lfyPpMonthlypayid != null ? lfyPpMonthlypayid.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof LfyPpMonthlypay)) {
			return false;
		}
		LfyPpMonthlypay other = (LfyPpMonthlypay) object;
		if ((this.lfyPpMonthlypayid == null && other.lfyPpMonthlypayid != null)
				|| (this.lfyPpMonthlypayid != null && !this.lfyPpMonthlypayid.equals(other.lfyPpMonthlypayid))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "nicupjnentityclasses.LfyPpMonthlypay[ lfyPpMonthlypayid=" + lfyPpMonthlypayid + " ]";
	}

}
