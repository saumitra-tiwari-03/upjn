/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nicupjnentityclasses;

import java.io.Serializable;
import java.math.BigDecimal;

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
@Table(name = "LFY_SMM_M1REPORTINFO")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "LfySmmM1reportinfo.findAll", query = "SELECT l FROM LfySmmM1reportinfo l"),
		@NamedQuery(name = "LfySmmM1reportinfo.findByLfySmmM1reportinfoid", query = "SELECT l FROM LfySmmM1reportinfo l WHERE l.lfySmmM1reportinfoid = :lfySmmM1reportinfoid"),
		@NamedQuery(name = "LfySmmM1reportinfo.findBySpSchememasterid", query = "SELECT l FROM LfySmmM1reportinfo l WHERE l.spSchememasterid = :spSchememasterid"),
		@NamedQuery(name = "LfySmmM1reportinfo.findByEstimatedcost", query = "SELECT l FROM LfySmmM1reportinfo l WHERE l.estimatedcost = :estimatedcost"),
		@NamedQuery(name = "LfySmmM1reportinfo.findByYearofpreparation", query = "SELECT l FROM LfySmmM1reportinfo l WHERE l.yearofpreparation = :yearofpreparation"),
		@NamedQuery(name = "LfySmmM1reportinfo.findByTotalexpLfy", query = "SELECT l FROM LfySmmM1reportinfo l WHERE l.totalexpLfy = :totalexpLfy"),
		@NamedQuery(name = "LfySmmM1reportinfo.findByBudgetCfy", query = "SELECT l FROM LfySmmM1reportinfo l WHERE l.budgetCfy = :budgetCfy"),
		@NamedQuery(name = "LfySmmM1reportinfo.findByBankerName", query = "SELECT l FROM LfySmmM1reportinfo l WHERE l.bankerName = :bankerName"),
		@NamedQuery(name = "LfySmmM1reportinfo.findByTotalcostReqMaterial", query = "SELECT l FROM LfySmmM1reportinfo l WHERE l.totalcostReqMaterial = :totalcostReqMaterial"),
		@NamedQuery(name = "LfySmmM1reportinfo.findBySmmM1reportinfoid", query = "SELECT l FROM LfySmmM1reportinfo l WHERE l.smmM1reportinfoid = :smmM1reportinfoid"),
		@NamedQuery(name = "LfySmmM1reportinfo.findByFinancialyear", query = "SELECT l FROM LfySmmM1reportinfo l WHERE l.financialyear = :financialyear") })
public class LfySmmM1reportinfo implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@Column(name = "LFY_SMM_M1REPORTINFOID")
	private Long lfySmmM1reportinfoid;
	@Basic(optional = false)
	@Column(name = "SP_SCHEMEMASTERID")
	private long spSchememasterid;
	// @Max(value=?) @Min(value=?)//if you know range of your decimal fields
	// consider using these annotations to enforce field validation
	@Basic(optional = false)
	@Column(name = "ESTIMATEDCOST")
	private BigDecimal estimatedcost;
	@Basic(optional = false)
	@Column(name = "YEAROFPREPARATION")
	private String yearofpreparation;
	@Basic(optional = false)
	@Column(name = "TOTALEXP_LFY")
	private BigDecimal totalexpLfy;
	@Basic(optional = false)
	@Column(name = "BUDGET_CFY")
	private BigDecimal budgetCfy;
	@Column(name = "BANKER_NAME")
	private String bankerName;
	@Basic(optional = false)
	@Column(name = "TOTALCOST_REQ_MATERIAL")
	private BigDecimal totalcostReqMaterial;
	@Basic(optional = false)
	@Column(name = "SMM_M1REPORTINFOID")
	private long smmM1reportinfoid;
	@Basic(optional = false)
	@Column(name = "FINANCIALYEAR")
	private String financialyear;

	public LfySmmM1reportinfo() {
	}

	public LfySmmM1reportinfo(Long lfySmmM1reportinfoid) {
		this.lfySmmM1reportinfoid = lfySmmM1reportinfoid;
	}

	public LfySmmM1reportinfo(Long lfySmmM1reportinfoid, long spSchememasterid, BigDecimal estimatedcost,
			String yearofpreparation, BigDecimal totalexpLfy, BigDecimal budgetCfy, BigDecimal totalcostReqMaterial,
			long smmM1reportinfoid, String financialyear) {
		this.lfySmmM1reportinfoid = lfySmmM1reportinfoid;
		this.spSchememasterid = spSchememasterid;
		this.estimatedcost = estimatedcost;
		this.yearofpreparation = yearofpreparation;
		this.totalexpLfy = totalexpLfy;
		this.budgetCfy = budgetCfy;
		this.totalcostReqMaterial = totalcostReqMaterial;
		this.smmM1reportinfoid = smmM1reportinfoid;
		this.financialyear = financialyear;
	}

	public Long getLfySmmM1reportinfoid() {
		return lfySmmM1reportinfoid;
	}

	public void setLfySmmM1reportinfoid(Long lfySmmM1reportinfoid) {
		this.lfySmmM1reportinfoid = lfySmmM1reportinfoid;
	}

	public long getSpSchememasterid() {
		return spSchememasterid;
	}

	public void setSpSchememasterid(long spSchememasterid) {
		this.spSchememasterid = spSchememasterid;
	}

	public BigDecimal getEstimatedcost() {
		return estimatedcost;
	}

	public void setEstimatedcost(BigDecimal estimatedcost) {
		this.estimatedcost = estimatedcost;
	}

	public String getYearofpreparation() {
		return yearofpreparation;
	}

	public void setYearofpreparation(String yearofpreparation) {
		this.yearofpreparation = yearofpreparation;
	}

	public BigDecimal getTotalexpLfy() {
		return totalexpLfy;
	}

	public void setTotalexpLfy(BigDecimal totalexpLfy) {
		this.totalexpLfy = totalexpLfy;
	}

	public BigDecimal getBudgetCfy() {
		return budgetCfy;
	}

	public void setBudgetCfy(BigDecimal budgetCfy) {
		this.budgetCfy = budgetCfy;
	}

	public String getBankerName() {
		return bankerName;
	}

	public void setBankerName(String bankerName) {
		this.bankerName = bankerName;
	}

	public BigDecimal getTotalcostReqMaterial() {
		return totalcostReqMaterial;
	}

	public void setTotalcostReqMaterial(BigDecimal totalcostReqMaterial) {
		this.totalcostReqMaterial = totalcostReqMaterial;
	}

	public long getSmmM1reportinfoid() {
		return smmM1reportinfoid;
	}

	public void setSmmM1reportinfoid(long smmM1reportinfoid) {
		this.smmM1reportinfoid = smmM1reportinfoid;
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
		hash += (lfySmmM1reportinfoid != null ? lfySmmM1reportinfoid.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof LfySmmM1reportinfo)) {
			return false;
		}
		LfySmmM1reportinfo other = (LfySmmM1reportinfo) object;
		if ((this.lfySmmM1reportinfoid == null && other.lfySmmM1reportinfoid != null)
				|| (this.lfySmmM1reportinfoid != null
						&& !this.lfySmmM1reportinfoid.equals(other.lfySmmM1reportinfoid))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "nicupjnentityclasses.LfySmmM1reportinfo[ lfySmmM1reportinfoid=" + lfySmmM1reportinfoid + " ]";
	}

}
