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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Saumitra-PC
 */
@Entity
@Table(name = "FPR403_ENTRY_TABLE")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "Fpr403EntryTable.findAll", query = "SELECT f FROM Fpr403EntryTable f"),
		@NamedQuery(name = "Fpr403EntryTable.findByFpr403EntryTableid", query = "SELECT f FROM Fpr403EntryTable f WHERE f.fpr403EntryTableid = :fpr403EntryTableid"),
		@NamedQuery(name = "Fpr403EntryTable.findBySpProgramCode", query = "SELECT f FROM Fpr403EntryTable f WHERE f.spProgramCode = :spProgramCode"),
		@NamedQuery(name = "Fpr403EntryTable.findBySpCategoryCode", query = "SELECT f FROM Fpr403EntryTable f WHERE f.spCategoryCode = :spCategoryCode"),
		@NamedQuery(name = "Fpr403EntryTable.findByMonth", query = "SELECT f FROM Fpr403EntryTable f WHERE f.month = :month"),
		@NamedQuery(name = "Fpr403EntryTable.findByYear", query = "SELECT f FROM Fpr403EntryTable f WHERE f.year = :year"),
		@NamedQuery(name = "Fpr403EntryTable.findByUnspentBalance", query = "SELECT f FROM Fpr403EntryTable f WHERE f.unspentBalance = :unspentBalance"),
		@NamedQuery(name = "Fpr403EntryTable.findByAnticipatedReceipt", query = "SELECT f FROM Fpr403EntryTable f WHERE f.anticipatedReceipt = :anticipatedReceipt"),
		@NamedQuery(name = "Fpr403EntryTable.findByReceiptGrant", query = "SELECT f FROM Fpr403EntryTable f WHERE f.receiptGrant = :receiptGrant"),
		@NamedQuery(name = "Fpr403EntryTable.findByContribution", query = "SELECT f FROM Fpr403EntryTable f WHERE f.contribution = :contribution"),
		@NamedQuery(name = "Fpr403EntryTable.findByExpendAmount", query = "SELECT f FROM Fpr403EntryTable f WHERE f.expendAmount = :expendAmount") })
public class Fpr403EntryTable implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@Column(name = "FPR403_ENTRY_TABLEID")
	private Long fpr403EntryTableid;
	@Basic(optional = false)
	@Column(name = "SP_PROGRAM_CODE")
	private String spProgramCode;
	@Basic(optional = false)
	@Column(name = "SP_CATEGORY_CODE")
	private String spCategoryCode;
	@Basic(optional = false)
	@Column(name = "MONTH")
	private short month;
	@Basic(optional = false)
	@Column(name = "YEAR")
	private short year;
	// @Max(value=?) @Min(value=?)//if you know range of your decimal fields
	// consider using these annotations to enforce field validation
	@Basic(optional = false)
	@Column(name = "UNSPENT_BALANCE")
	private BigDecimal unspentBalance;
	@Basic(optional = false)
	@Column(name = "ANTICIPATED_RECEIPT")
	private BigDecimal anticipatedReceipt;
	@Basic(optional = false)
	@Column(name = "RECEIPT_GRANT")
	private BigDecimal receiptGrant;
	@Basic(optional = false)
	@Column(name = "CONTRIBUTION")
	private BigDecimal contribution;
	@Basic(optional = false)
	@Column(name = "EXPEND_AMOUNT")
	private BigDecimal expendAmount;
	@JoinColumn(name = "MAS_DISTRICTID", referencedColumnName = "MAS_DISTRICTID")
	@ManyToOne(optional = false)
	private MasDistrict masDistrictid;
	@JoinColumn(name = "RM_OFFICEID", referencedColumnName = "RM_OFFICEID")
	@ManyToOne(optional = false)
	private RmOffice rmOfficeid;

	public Fpr403EntryTable() {
	}

	public Fpr403EntryTable(Long fpr403EntryTableid) {
		this.fpr403EntryTableid = fpr403EntryTableid;
	}

	public Fpr403EntryTable(Long fpr403EntryTableid, String spProgramCode, String spCategoryCode, short month,
			short year, BigDecimal unspentBalance, BigDecimal anticipatedReceipt, BigDecimal receiptGrant,
			BigDecimal contribution, BigDecimal expendAmount) {
		this.fpr403EntryTableid = fpr403EntryTableid;
		this.spProgramCode = spProgramCode;
		this.spCategoryCode = spCategoryCode;
		this.month = month;
		this.year = year;
		this.unspentBalance = unspentBalance;
		this.anticipatedReceipt = anticipatedReceipt;
		this.receiptGrant = receiptGrant;
		this.contribution = contribution;
		this.expendAmount = expendAmount;
	}

	public Long getFpr403EntryTableid() {
		return fpr403EntryTableid;
	}

	public void setFpr403EntryTableid(Long fpr403EntryTableid) {
		this.fpr403EntryTableid = fpr403EntryTableid;
	}

	public String getSpProgramCode() {
		return spProgramCode;
	}

	public void setSpProgramCode(String spProgramCode) {
		this.spProgramCode = spProgramCode;
	}

	public String getSpCategoryCode() {
		return spCategoryCode;
	}

	public void setSpCategoryCode(String spCategoryCode) {
		this.spCategoryCode = spCategoryCode;
	}

	public short getMonth() {
		return month;
	}

	public void setMonth(short month) {
		this.month = month;
	}

	public short getYear() {
		return year;
	}

	public void setYear(short year) {
		this.year = year;
	}

	public BigDecimal getUnspentBalance() {
		return unspentBalance;
	}

	public void setUnspentBalance(BigDecimal unspentBalance) {
		this.unspentBalance = unspentBalance;
	}

	public BigDecimal getAnticipatedReceipt() {
		return anticipatedReceipt;
	}

	public void setAnticipatedReceipt(BigDecimal anticipatedReceipt) {
		this.anticipatedReceipt = anticipatedReceipt;
	}

	public BigDecimal getReceiptGrant() {
		return receiptGrant;
	}

	public void setReceiptGrant(BigDecimal receiptGrant) {
		this.receiptGrant = receiptGrant;
	}

	public BigDecimal getContribution() {
		return contribution;
	}

	public void setContribution(BigDecimal contribution) {
		this.contribution = contribution;
	}

	public BigDecimal getExpendAmount() {
		return expendAmount;
	}

	public void setExpendAmount(BigDecimal expendAmount) {
		this.expendAmount = expendAmount;
	}

	public MasDistrict getMasDistrictid() {
		return masDistrictid;
	}

	public void setMasDistrictid(MasDistrict masDistrictid) {
		this.masDistrictid = masDistrictid;
	}

	public RmOffice getRmOfficeid() {
		return rmOfficeid;
	}

	public void setRmOfficeid(RmOffice rmOfficeid) {
		this.rmOfficeid = rmOfficeid;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (fpr403EntryTableid != null ? fpr403EntryTableid.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof Fpr403EntryTable)) {
			return false;
		}
		Fpr403EntryTable other = (Fpr403EntryTable) object;
		if ((this.fpr403EntryTableid == null && other.fpr403EntryTableid != null)
				|| (this.fpr403EntryTableid != null && !this.fpr403EntryTableid.equals(other.fpr403EntryTableid))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "nicupjnentityclasses.Fpr403EntryTable[ fpr403EntryTableid=" + fpr403EntryTableid + " ]";
	}

}
