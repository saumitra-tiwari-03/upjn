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
@Table(name = "LFY_PSN_MONTHLYPAY")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "LfyPsnMonthlypay.findAll", query = "SELECT l FROM LfyPsnMonthlypay l"),
		@NamedQuery(name = "LfyPsnMonthlypay.findByLfyPsnMonthlypayid", query = "SELECT l FROM LfyPsnMonthlypay l WHERE l.lfyPsnMonthlypayid = :lfyPsnMonthlypayid"),
		@NamedQuery(name = "LfyPsnMonthlypay.findByPsnEmployeepensionMasterid", query = "SELECT l FROM LfyPsnMonthlypay l WHERE l.psnEmployeepensionMasterid = :psnEmployeepensionMasterid"),
		@NamedQuery(name = "LfyPsnMonthlypay.findByPayyear", query = "SELECT l FROM LfyPsnMonthlypay l WHERE l.payyear = :payyear"),
		@NamedQuery(name = "LfyPsnMonthlypay.findByPaymonth", query = "SELECT l FROM LfyPsnMonthlypay l WHERE l.paymonth = :paymonth"),
		@NamedQuery(name = "LfyPsnMonthlypay.findByPsnPaybilldetailid", query = "SELECT l FROM LfyPsnMonthlypay l WHERE l.psnPaybilldetailid = :psnPaybilldetailid"),
		@NamedQuery(name = "LfyPsnMonthlypay.findByPpNetpension", query = "SELECT l FROM LfyPsnMonthlypay l WHERE l.ppNetpension = :ppNetpension"),
		@NamedQuery(name = "LfyPsnMonthlypay.findByAcCode", query = "SELECT l FROM LfyPsnMonthlypay l WHERE l.acCode = :acCode"),
		@NamedQuery(name = "LfyPsnMonthlypay.findByPsnMonthlypayid", query = "SELECT l FROM LfyPsnMonthlypay l WHERE l.psnMonthlypayid = :psnMonthlypayid"),
		@NamedQuery(name = "LfyPsnMonthlypay.findByFinancialyear", query = "SELECT l FROM LfyPsnMonthlypay l WHERE l.financialyear = :financialyear") })
public class LfyPsnMonthlypay implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@Column(name = "LFY_PSN_MONTHLYPAYID")
	private Long lfyPsnMonthlypayid;
	@Basic(optional = false)
	@Column(name = "PSN_EMPLOYEEPENSION_MASTERID")
	private long psnEmployeepensionMasterid;
	@Basic(optional = false)
	@Column(name = "PAYYEAR")
	private long payyear;
	@Basic(optional = false)
	@Column(name = "PAYMONTH")
	private long paymonth;
	@Basic(optional = false)
	@Column(name = "PSN_PAYBILLDETAILID")
	private int psnPaybilldetailid;
	@Basic(optional = false)
	@Column(name = "PP_NETPENSION")
	private int ppNetpension;
	@Column(name = "AC_CODE")
	private String acCode;
	@Basic(optional = false)
	@Column(name = "PSN_MONTHLYPAYID")
	private long psnMonthlypayid;
	@Basic(optional = false)
	@Column(name = "FINANCIALYEAR")
	private String financialyear;

	public LfyPsnMonthlypay() {
	}

	public LfyPsnMonthlypay(Long lfyPsnMonthlypayid) {
		this.lfyPsnMonthlypayid = lfyPsnMonthlypayid;
	}

	public LfyPsnMonthlypay(Long lfyPsnMonthlypayid, long psnEmployeepensionMasterid, long payyear, long paymonth,
			int psnPaybilldetailid, int ppNetpension, long psnMonthlypayid, String financialyear) {
		this.lfyPsnMonthlypayid = lfyPsnMonthlypayid;
		this.psnEmployeepensionMasterid = psnEmployeepensionMasterid;
		this.payyear = payyear;
		this.paymonth = paymonth;
		this.psnPaybilldetailid = psnPaybilldetailid;
		this.ppNetpension = ppNetpension;
		this.psnMonthlypayid = psnMonthlypayid;
		this.financialyear = financialyear;
	}

	public Long getLfyPsnMonthlypayid() {
		return lfyPsnMonthlypayid;
	}

	public void setLfyPsnMonthlypayid(Long lfyPsnMonthlypayid) {
		this.lfyPsnMonthlypayid = lfyPsnMonthlypayid;
	}

	public long getPsnEmployeepensionMasterid() {
		return psnEmployeepensionMasterid;
	}

	public void setPsnEmployeepensionMasterid(long psnEmployeepensionMasterid) {
		this.psnEmployeepensionMasterid = psnEmployeepensionMasterid;
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

	public int getPsnPaybilldetailid() {
		return psnPaybilldetailid;
	}

	public void setPsnPaybilldetailid(int psnPaybilldetailid) {
		this.psnPaybilldetailid = psnPaybilldetailid;
	}

	public int getPpNetpension() {
		return ppNetpension;
	}

	public void setPpNetpension(int ppNetpension) {
		this.ppNetpension = ppNetpension;
	}

	public String getAcCode() {
		return acCode;
	}

	public void setAcCode(String acCode) {
		this.acCode = acCode;
	}

	public long getPsnMonthlypayid() {
		return psnMonthlypayid;
	}

	public void setPsnMonthlypayid(long psnMonthlypayid) {
		this.psnMonthlypayid = psnMonthlypayid;
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
		hash += (lfyPsnMonthlypayid != null ? lfyPsnMonthlypayid.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof LfyPsnMonthlypay)) {
			return false;
		}
		LfyPsnMonthlypay other = (LfyPsnMonthlypay) object;
		if ((this.lfyPsnMonthlypayid == null && other.lfyPsnMonthlypayid != null)
				|| (this.lfyPsnMonthlypayid != null && !this.lfyPsnMonthlypayid.equals(other.lfyPsnMonthlypayid))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "nicupjnentityclasses.LfyPsnMonthlypay[ lfyPsnMonthlypayid=" + lfyPsnMonthlypayid + " ]";
	}

}
