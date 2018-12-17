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
@Table(name = "LFY_SMM_STOCK_XFER_TRAN")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "LfySmmStockXferTran.findAll", query = "SELECT l FROM LfySmmStockXferTran l"),
		@NamedQuery(name = "LfySmmStockXferTran.findByLfySmmStockXferTranid", query = "SELECT l FROM LfySmmStockXferTran l WHERE l.lfySmmStockXferTranid = :lfySmmStockXferTranid"),
		@NamedQuery(name = "LfySmmStockXferTran.findBySmmStockTranReqid", query = "SELECT l FROM LfySmmStockXferTran l WHERE l.smmStockTranReqid = :smmStockTranReqid"),
		@NamedQuery(name = "LfySmmStockXferTran.findByQuantity", query = "SELECT l FROM LfySmmStockXferTran l WHERE l.quantity = :quantity"),
		@NamedQuery(name = "LfySmmStockXferTran.findByRate", query = "SELECT l FROM LfySmmStockXferTran l WHERE l.rate = :rate"),
		@NamedQuery(name = "LfySmmStockXferTran.findByCost", query = "SELECT l FROM LfySmmStockXferTran l WHERE l.cost = :cost"),
		@NamedQuery(name = "LfySmmStockXferTran.findByDtrNo", query = "SELECT l FROM LfySmmStockXferTran l WHERE l.dtrNo = :dtrNo"),
		@NamedQuery(name = "LfySmmStockXferTran.findByMbNo", query = "SELECT l FROM LfySmmStockXferTran l WHERE l.mbNo = :mbNo"),
		@NamedQuery(name = "LfySmmStockXferTran.findByPageNo", query = "SELECT l FROM LfySmmStockXferTran l WHERE l.pageNo = :pageNo"),
		@NamedQuery(name = "LfySmmStockXferTran.findByMesurementDate", query = "SELECT l FROM LfySmmStockXferTran l WHERE l.mesurementDate = :mesurementDate"),
		@NamedQuery(name = "LfySmmStockXferTran.findByJeName", query = "SELECT l FROM LfySmmStockXferTran l WHERE l.jeName = :jeName"),
		@NamedQuery(name = "LfySmmStockXferTran.findBySmmStockXferTransactionid", query = "SELECT l FROM LfySmmStockXferTran l WHERE l.smmStockXferTransactionid = :smmStockXferTransactionid"),
		@NamedQuery(name = "LfySmmStockXferTran.findByFinancialyear", query = "SELECT l FROM LfySmmStockXferTran l WHERE l.financialyear = :financialyear") })
public class LfySmmStockXferTran implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@Column(name = "LFY_SMM_STOCK_XFER_TRANID")
	private Long lfySmmStockXferTranid;
	@Basic(optional = false)
	@Column(name = "SMM_STOCK_TRAN_REQID")
	private long smmStockTranReqid;
	@Basic(optional = false)
	@Column(name = "QUANTITY")
	private long quantity;
	// @Max(value=?) @Min(value=?)//if you know range of your decimal fields
	// consider using these annotations to enforce field validation
	@Basic(optional = false)
	@Column(name = "RATE")
	private BigDecimal rate;
	@Basic(optional = false)
	@Column(name = "COST")
	private BigDecimal cost;
	@Column(name = "DTR_NO")
	private String dtrNo;
	@Column(name = "MB_NO")
	private String mbNo;
	@Column(name = "PAGE_NO")
	private String pageNo;
	@Column(name = "MESUREMENT_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date mesurementDate;
	@Column(name = "JE_NAME")
	private String jeName;
	@Basic(optional = false)
	@Column(name = "SMM_STOCK_XFER_TRANSACTIONID")
	private long smmStockXferTransactionid;
	@Basic(optional = false)
	@Column(name = "FINANCIALYEAR")
	private String financialyear;

	public LfySmmStockXferTran() {
	}

	public LfySmmStockXferTran(Long lfySmmStockXferTranid) {
		this.lfySmmStockXferTranid = lfySmmStockXferTranid;
	}

	public LfySmmStockXferTran(Long lfySmmStockXferTranid, long smmStockTranReqid, long quantity, BigDecimal rate,
			BigDecimal cost, long smmStockXferTransactionid, String financialyear) {
		this.lfySmmStockXferTranid = lfySmmStockXferTranid;
		this.smmStockTranReqid = smmStockTranReqid;
		this.quantity = quantity;
		this.rate = rate;
		this.cost = cost;
		this.smmStockXferTransactionid = smmStockXferTransactionid;
		this.financialyear = financialyear;
	}

	public Long getLfySmmStockXferTranid() {
		return lfySmmStockXferTranid;
	}

	public void setLfySmmStockXferTranid(Long lfySmmStockXferTranid) {
		this.lfySmmStockXferTranid = lfySmmStockXferTranid;
	}

	public long getSmmStockTranReqid() {
		return smmStockTranReqid;
	}

	public void setSmmStockTranReqid(long smmStockTranReqid) {
		this.smmStockTranReqid = smmStockTranReqid;
	}

	public long getQuantity() {
		return quantity;
	}

	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getRate() {
		return rate;
	}

	public void setRate(BigDecimal rate) {
		this.rate = rate;
	}

	public BigDecimal getCost() {
		return cost;
	}

	public void setCost(BigDecimal cost) {
		this.cost = cost;
	}

	public String getDtrNo() {
		return dtrNo;
	}

	public void setDtrNo(String dtrNo) {
		this.dtrNo = dtrNo;
	}

	public String getMbNo() {
		return mbNo;
	}

	public void setMbNo(String mbNo) {
		this.mbNo = mbNo;
	}

	public String getPageNo() {
		return pageNo;
	}

	public void setPageNo(String pageNo) {
		this.pageNo = pageNo;
	}

	public Date getMesurementDate() {
		return mesurementDate;
	}

	public void setMesurementDate(Date mesurementDate) {
		this.mesurementDate = mesurementDate;
	}

	public String getJeName() {
		return jeName;
	}

	public void setJeName(String jeName) {
		this.jeName = jeName;
	}

	public long getSmmStockXferTransactionid() {
		return smmStockXferTransactionid;
	}

	public void setSmmStockXferTransactionid(long smmStockXferTransactionid) {
		this.smmStockXferTransactionid = smmStockXferTransactionid;
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
		hash += (lfySmmStockXferTranid != null ? lfySmmStockXferTranid.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof LfySmmStockXferTran)) {
			return false;
		}
		LfySmmStockXferTran other = (LfySmmStockXferTran) object;
		if ((this.lfySmmStockXferTranid == null && other.lfySmmStockXferTranid != null)
				|| (this.lfySmmStockXferTranid != null
						&& !this.lfySmmStockXferTranid.equals(other.lfySmmStockXferTranid))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "nicupjnentityclasses.LfySmmStockXferTran[ lfySmmStockXferTranid=" + lfySmmStockXferTranid + " ]";
	}

}
