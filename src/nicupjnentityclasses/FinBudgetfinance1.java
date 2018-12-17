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
@Table(name = "FIN_BUDGETFINANCE1")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "FinBudgetfinance1.findAll", query = "SELECT f FROM FinBudgetfinance1 f"),
		@NamedQuery(name = "FinBudgetfinance1.findByFinBudgetfinanceid1", query = "SELECT f FROM FinBudgetfinance1 f WHERE f.finBudgetfinanceid1 = :finBudgetfinanceid1"),
		@NamedQuery(name = "FinBudgetfinance1.findByOpeningbalance", query = "SELECT f FROM FinBudgetfinance1 f WHERE f.openingbalance = :openingbalance"),
		@NamedQuery(name = "FinBudgetfinance1.findByAnticipatedreceipts", query = "SELECT f FROM FinBudgetfinance1 f WHERE f.anticipatedreceipts = :anticipatedreceipts"),
		@NamedQuery(name = "FinBudgetfinance1.findByFromhq", query = "SELECT f FROM FinBudgetfinance1 f WHERE f.fromhq = :fromhq"),
		@NamedQuery(name = "FinBudgetfinance1.findByDirect", query = "SELECT f FROM FinBudgetfinance1 f WHERE f.direct = :direct"),
		@NamedQuery(name = "FinBudgetfinance1.findByTotalavailability", query = "SELECT f FROM FinBudgetfinance1 f WHERE f.totalavailability = :totalavailability"),
		@NamedQuery(name = "FinBudgetfinance1.findByProgramwork", query = "SELECT f FROM FinBudgetfinance1 f WHERE f.programwork = :programwork"),
		@NamedQuery(name = "FinBudgetfinance1.findByCentage", query = "SELECT f FROM FinBudgetfinance1 f WHERE f.centage = :centage"),
		@NamedQuery(name = "FinBudgetfinance1.findByTotal", query = "SELECT f FROM FinBudgetfinance1 f WHERE f.total = :total"),
		@NamedQuery(name = "FinBudgetfinance1.findByFinProgramid", query = "SELECT f FROM FinBudgetfinance1 f WHERE f.finProgramid = :finProgramid"),
		@NamedQuery(name = "FinBudgetfinance1.findByFinanceyear", query = "SELECT f FROM FinBudgetfinance1 f WHERE f.financeyear = :financeyear"),
		@NamedQuery(name = "FinBudgetfinance1.findByFinancemonth", query = "SELECT f FROM FinBudgetfinance1 f WHERE f.financemonth = :financemonth"),
		@NamedQuery(name = "FinBudgetfinance1.findByPlace", query = "SELECT f FROM FinBudgetfinance1 f WHERE f.place = :place"),
		@NamedQuery(name = "FinBudgetfinance1.findByWce", query = "SELECT f FROM FinBudgetfinance1 f WHERE f.wce = :wce"),
		@NamedQuery(name = "FinBudgetfinance1.findByRmOfficeid", query = "SELECT f FROM FinBudgetfinance1 f WHERE f.rmOfficeid = :rmOfficeid"),
		@NamedQuery(name = "FinBudgetfinance1.findByFinancialyear", query = "SELECT f FROM FinBudgetfinance1 f WHERE f.financialyear = :financialyear"),
		@NamedQuery(name = "FinBudgetfinance1.findByTransfertoother", query = "SELECT f FROM FinBudgetfinance1 f WHERE f.transfertoother = :transfertoother"),
		@NamedQuery(name = "FinBudgetfinance1.findByTransherredhqfromwc", query = "SELECT f FROM FinBudgetfinance1 f WHERE f.transherredhqfromwc = :transherredhqfromwc"),
		@NamedQuery(name = "FinBudgetfinance1.findByHqfromcentage", query = "SELECT f FROM FinBudgetfinance1 f WHERE f.hqfromcentage = :hqfromcentage"),
		@NamedQuery(name = "FinBudgetfinance1.findByClosingbalance", query = "SELECT f FROM FinBudgetfinance1 f WHERE f.closingbalance = :closingbalance"),
		@NamedQuery(name = "FinBudgetfinance1.findByIslocked", query = "SELECT f FROM FinBudgetfinance1 f WHERE f.islocked = :islocked"),
		@NamedQuery(name = "FinBudgetfinance1.findByProgramwotkmat", query = "SELECT f FROM FinBudgetfinance1 f WHERE f.programwotkmat = :programwotkmat") })
public class FinBudgetfinance1 implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@Column(name = "FIN_BUDGETFINANCEID1")
	private Long finBudgetfinanceid1;
	@Column(name = "OPENINGBALANCE")
	private String openingbalance;
	@Column(name = "ANTICIPATEDRECEIPTS")
	private String anticipatedreceipts;
	@Column(name = "FROMHQ")
	private String fromhq;
	@Column(name = "DIRECT")
	private String direct;
	@Column(name = "TOTALAVAILABILITY")
	private String totalavailability;
	@Column(name = "PROGRAMWORK")
	private String programwork;
	@Column(name = "CENTAGE")
	private String centage;
	@Column(name = "TOTAL")
	private String total;
	@Basic(optional = false)
	@Column(name = "FIN_PROGRAMID")
	private long finProgramid;
	@Column(name = "FINANCEYEAR")
	private Long financeyear;
	@Column(name = "FINANCEMONTH")
	private String financemonth;
	@Column(name = "PLACE")
	private String place;
	@Column(name = "WCE")
	private String wce;
	@Column(name = "RM_OFFICEID")
	private String rmOfficeid;
	@Column(name = "FINANCIALYEAR")
	private String financialyear;
	@Column(name = "TRANSFERTOOTHER")
	private String transfertoother;
	@Column(name = "TRANSHERREDHQFROMWC")
	private String transherredhqfromwc;
	@Column(name = "HQFROMCENTAGE")
	private String hqfromcentage;
	@Column(name = "CLOSINGBALANCE")
	private String closingbalance;
	@Column(name = "ISLOCKED")
	private String islocked;
	@Column(name = "PROGRAMWOTKMAT")
	private String programwotkmat;

	public FinBudgetfinance1() {
	}

	public FinBudgetfinance1(Long finBudgetfinanceid1) {
		this.finBudgetfinanceid1 = finBudgetfinanceid1;
	}

	public FinBudgetfinance1(Long finBudgetfinanceid1, long finProgramid) {
		this.finBudgetfinanceid1 = finBudgetfinanceid1;
		this.finProgramid = finProgramid;
	}

	public Long getFinBudgetfinanceid1() {
		return finBudgetfinanceid1;
	}

	public void setFinBudgetfinanceid1(Long finBudgetfinanceid1) {
		this.finBudgetfinanceid1 = finBudgetfinanceid1;
	}

	public String getOpeningbalance() {
		return openingbalance;
	}

	public void setOpeningbalance(String openingbalance) {
		this.openingbalance = openingbalance;
	}

	public String getAnticipatedreceipts() {
		return anticipatedreceipts;
	}

	public void setAnticipatedreceipts(String anticipatedreceipts) {
		this.anticipatedreceipts = anticipatedreceipts;
	}

	public String getFromhq() {
		return fromhq;
	}

	public void setFromhq(String fromhq) {
		this.fromhq = fromhq;
	}

	public String getDirect() {
		return direct;
	}

	public void setDirect(String direct) {
		this.direct = direct;
	}

	public String getTotalavailability() {
		return totalavailability;
	}

	public void setTotalavailability(String totalavailability) {
		this.totalavailability = totalavailability;
	}

	public String getProgramwork() {
		return programwork;
	}

	public void setProgramwork(String programwork) {
		this.programwork = programwork;
	}

	public String getCentage() {
		return centage;
	}

	public void setCentage(String centage) {
		this.centage = centage;
	}

	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}

	public long getFinProgramid() {
		return finProgramid;
	}

	public void setFinProgramid(long finProgramid) {
		this.finProgramid = finProgramid;
	}

	public Long getFinanceyear() {
		return financeyear;
	}

	public void setFinanceyear(Long financeyear) {
		this.financeyear = financeyear;
	}

	public String getFinancemonth() {
		return financemonth;
	}

	public void setFinancemonth(String financemonth) {
		this.financemonth = financemonth;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getWce() {
		return wce;
	}

	public void setWce(String wce) {
		this.wce = wce;
	}

	public String getRmOfficeid() {
		return rmOfficeid;
	}

	public void setRmOfficeid(String rmOfficeid) {
		this.rmOfficeid = rmOfficeid;
	}

	public String getFinancialyear() {
		return financialyear;
	}

	public void setFinancialyear(String financialyear) {
		this.financialyear = financialyear;
	}

	public String getTransfertoother() {
		return transfertoother;
	}

	public void setTransfertoother(String transfertoother) {
		this.transfertoother = transfertoother;
	}

	public String getTransherredhqfromwc() {
		return transherredhqfromwc;
	}

	public void setTransherredhqfromwc(String transherredhqfromwc) {
		this.transherredhqfromwc = transherredhqfromwc;
	}

	public String getHqfromcentage() {
		return hqfromcentage;
	}

	public void setHqfromcentage(String hqfromcentage) {
		this.hqfromcentage = hqfromcentage;
	}

	public String getClosingbalance() {
		return closingbalance;
	}

	public void setClosingbalance(String closingbalance) {
		this.closingbalance = closingbalance;
	}

	public String getIslocked() {
		return islocked;
	}

	public void setIslocked(String islocked) {
		this.islocked = islocked;
	}

	public String getProgramwotkmat() {
		return programwotkmat;
	}

	public void setProgramwotkmat(String programwotkmat) {
		this.programwotkmat = programwotkmat;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (finBudgetfinanceid1 != null ? finBudgetfinanceid1.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof FinBudgetfinance1)) {
			return false;
		}
		FinBudgetfinance1 other = (FinBudgetfinance1) object;
		if ((this.finBudgetfinanceid1 == null && other.finBudgetfinanceid1 != null)
				|| (this.finBudgetfinanceid1 != null && !this.finBudgetfinanceid1.equals(other.finBudgetfinanceid1))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "nicupjnentityclasses.FinBudgetfinance1[ finBudgetfinanceid1=" + finBudgetfinanceid1 + " ]";
	}

}
