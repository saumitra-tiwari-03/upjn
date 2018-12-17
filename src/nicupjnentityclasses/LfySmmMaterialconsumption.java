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
@Table(name = "LFY_SMM_MATERIALCONSUMPTION")
@XmlRootElement
@NamedQueries({
		@NamedQuery(name = "LfySmmMaterialconsumption.findAll", query = "SELECT l FROM LfySmmMaterialconsumption l"),
		@NamedQuery(name = "LfySmmMaterialconsumption.findByLfySmmMaterialconsumptionid", query = "SELECT l FROM LfySmmMaterialconsumption l WHERE l.lfySmmMaterialconsumptionid = :lfySmmMaterialconsumptionid"),
		@NamedQuery(name = "LfySmmMaterialconsumption.findBySmmItemmasterid", query = "SELECT l FROM LfySmmMaterialconsumption l WHERE l.smmItemmasterid = :smmItemmasterid"),
		@NamedQuery(name = "LfySmmMaterialconsumption.findBySpSchememasterid", query = "SELECT l FROM LfySmmMaterialconsumption l WHERE l.spSchememasterid = :spSchememasterid"),
		@NamedQuery(name = "LfySmmMaterialconsumption.findByRmOfficeid", query = "SELECT l FROM LfySmmMaterialconsumption l WHERE l.rmOfficeid = :rmOfficeid"),
		@NamedQuery(name = "LfySmmMaterialconsumption.findByQuantityconsumped", query = "SELECT l FROM LfySmmMaterialconsumption l WHERE l.quantityconsumped = :quantityconsumped"),
		@NamedQuery(name = "LfySmmMaterialconsumption.findByAsondate", query = "SELECT l FROM LfySmmMaterialconsumption l WHERE l.asondate = :asondate"),
		@NamedQuery(name = "LfySmmMaterialconsumption.findByDtrNo", query = "SELECT l FROM LfySmmMaterialconsumption l WHERE l.dtrNo = :dtrNo"),
		@NamedQuery(name = "LfySmmMaterialconsumption.findByIstransfered", query = "SELECT l FROM LfySmmMaterialconsumption l WHERE l.istransfered = :istransfered"),
		@NamedQuery(name = "LfySmmMaterialconsumption.findBySmmStockXferTransactionid", query = "SELECT l FROM LfySmmMaterialconsumption l WHERE l.smmStockXferTransactionid = :smmStockXferTransactionid"),
		@NamedQuery(name = "LfySmmMaterialconsumption.findByPageNo", query = "SELECT l FROM LfySmmMaterialconsumption l WHERE l.pageNo = :pageNo"),
		@NamedQuery(name = "LfySmmMaterialconsumption.findByMbNo", query = "SELECT l FROM LfySmmMaterialconsumption l WHERE l.mbNo = :mbNo"),
		@NamedQuery(name = "LfySmmMaterialconsumption.findByJeName", query = "SELECT l FROM LfySmmMaterialconsumption l WHERE l.jeName = :jeName"),
		@NamedQuery(name = "LfySmmMaterialconsumption.findByMeasurementDate", query = "SELECT l FROM LfySmmMaterialconsumption l WHERE l.measurementDate = :measurementDate"),
		@NamedQuery(name = "LfySmmMaterialconsumption.findBySmmMaterialconsumptionid", query = "SELECT l FROM LfySmmMaterialconsumption l WHERE l.smmMaterialconsumptionid = :smmMaterialconsumptionid"),
		@NamedQuery(name = "LfySmmMaterialconsumption.findByFinancialyear", query = "SELECT l FROM LfySmmMaterialconsumption l WHERE l.financialyear = :financialyear") })
public class LfySmmMaterialconsumption implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@Column(name = "LFY_SMM_MATERIALCONSUMPTIONID")
	private Long lfySmmMaterialconsumptionid;
	@Basic(optional = false)
	@Column(name = "SMM_ITEMMASTERID")
	private long smmItemmasterid;
	@Basic(optional = false)
	@Column(name = "SP_SCHEMEMASTERID")
	private long spSchememasterid;
	@Basic(optional = false)
	@Column(name = "RM_OFFICEID")
	private long rmOfficeid;
	@Basic(optional = false)
	@Column(name = "QUANTITYCONSUMPED")
	private long quantityconsumped;
	@Column(name = "ASONDATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date asondate;
	@Basic(optional = false)
	@Column(name = "DTR_NO")
	private String dtrNo;
	@Basic(optional = false)
	@Column(name = "ISTRANSFERED")
	private Character istransfered;
	@Column(name = "SMM_STOCK_XFER_TRANSACTIONID")
	private Long smmStockXferTransactionid;
	@Column(name = "PAGE_NO")
	private String pageNo;
	@Column(name = "MB_NO")
	private String mbNo;
	@Column(name = "JE_NAME")
	private String jeName;
	@Column(name = "MEASUREMENT_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date measurementDate;
	@Basic(optional = false)
	@Column(name = "SMM_MATERIALCONSUMPTIONID")
	private long smmMaterialconsumptionid;
	@Basic(optional = false)
	@Column(name = "FINANCIALYEAR")
	private String financialyear;

	public LfySmmMaterialconsumption() {
	}

	public LfySmmMaterialconsumption(Long lfySmmMaterialconsumptionid) {
		this.lfySmmMaterialconsumptionid = lfySmmMaterialconsumptionid;
	}

	public LfySmmMaterialconsumption(Long lfySmmMaterialconsumptionid, long smmItemmasterid, long spSchememasterid,
			long rmOfficeid, long quantityconsumped, String dtrNo, Character istransfered,
			long smmMaterialconsumptionid, String financialyear) {
		this.lfySmmMaterialconsumptionid = lfySmmMaterialconsumptionid;
		this.smmItemmasterid = smmItemmasterid;
		this.spSchememasterid = spSchememasterid;
		this.rmOfficeid = rmOfficeid;
		this.quantityconsumped = quantityconsumped;
		this.dtrNo = dtrNo;
		this.istransfered = istransfered;
		this.smmMaterialconsumptionid = smmMaterialconsumptionid;
		this.financialyear = financialyear;
	}

	public Long getLfySmmMaterialconsumptionid() {
		return lfySmmMaterialconsumptionid;
	}

	public void setLfySmmMaterialconsumptionid(Long lfySmmMaterialconsumptionid) {
		this.lfySmmMaterialconsumptionid = lfySmmMaterialconsumptionid;
	}

	public long getSmmItemmasterid() {
		return smmItemmasterid;
	}

	public void setSmmItemmasterid(long smmItemmasterid) {
		this.smmItemmasterid = smmItemmasterid;
	}

	public long getSpSchememasterid() {
		return spSchememasterid;
	}

	public void setSpSchememasterid(long spSchememasterid) {
		this.spSchememasterid = spSchememasterid;
	}

	public long getRmOfficeid() {
		return rmOfficeid;
	}

	public void setRmOfficeid(long rmOfficeid) {
		this.rmOfficeid = rmOfficeid;
	}

	public long getQuantityconsumped() {
		return quantityconsumped;
	}

	public void setQuantityconsumped(long quantityconsumped) {
		this.quantityconsumped = quantityconsumped;
	}

	public Date getAsondate() {
		return asondate;
	}

	public void setAsondate(Date asondate) {
		this.asondate = asondate;
	}

	public String getDtrNo() {
		return dtrNo;
	}

	public void setDtrNo(String dtrNo) {
		this.dtrNo = dtrNo;
	}

	public Character getIstransfered() {
		return istransfered;
	}

	public void setIstransfered(Character istransfered) {
		this.istransfered = istransfered;
	}

	public Long getSmmStockXferTransactionid() {
		return smmStockXferTransactionid;
	}

	public void setSmmStockXferTransactionid(Long smmStockXferTransactionid) {
		this.smmStockXferTransactionid = smmStockXferTransactionid;
	}

	public String getPageNo() {
		return pageNo;
	}

	public void setPageNo(String pageNo) {
		this.pageNo = pageNo;
	}

	public String getMbNo() {
		return mbNo;
	}

	public void setMbNo(String mbNo) {
		this.mbNo = mbNo;
	}

	public String getJeName() {
		return jeName;
	}

	public void setJeName(String jeName) {
		this.jeName = jeName;
	}

	public Date getMeasurementDate() {
		return measurementDate;
	}

	public void setMeasurementDate(Date measurementDate) {
		this.measurementDate = measurementDate;
	}

	public long getSmmMaterialconsumptionid() {
		return smmMaterialconsumptionid;
	}

	public void setSmmMaterialconsumptionid(long smmMaterialconsumptionid) {
		this.smmMaterialconsumptionid = smmMaterialconsumptionid;
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
		hash += (lfySmmMaterialconsumptionid != null ? lfySmmMaterialconsumptionid.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof LfySmmMaterialconsumption)) {
			return false;
		}
		LfySmmMaterialconsumption other = (LfySmmMaterialconsumption) object;
		if ((this.lfySmmMaterialconsumptionid == null && other.lfySmmMaterialconsumptionid != null)
				|| (this.lfySmmMaterialconsumptionid != null
						&& !this.lfySmmMaterialconsumptionid.equals(other.lfySmmMaterialconsumptionid))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "nicupjnentityclasses.LfySmmMaterialconsumption[ lfySmmMaterialconsumptionid="
				+ lfySmmMaterialconsumptionid + " ]";
	}

}
