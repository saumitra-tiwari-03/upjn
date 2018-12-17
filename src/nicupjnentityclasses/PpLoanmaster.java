/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nicupjnentityclasses;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Saumitra-PC
 */
@Entity
@Table(name = "PP_LOANMASTER")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "PpLoanmaster.findAll", query = "SELECT p FROM PpLoanmaster p"),
		@NamedQuery(name = "PpLoanmaster.findByPpLoanmasterid", query = "SELECT p FROM PpLoanmaster p WHERE p.ppLoanmasterid = :ppLoanmasterid"),
		@NamedQuery(name = "PpLoanmaster.findByLoanname", query = "SELECT p FROM PpLoanmaster p WHERE p.loanname = :loanname"),
		@NamedQuery(name = "PpLoanmaster.findByLoanshortname", query = "SELECT p FROM PpLoanmaster p WHERE p.loanshortname = :loanshortname"),
		@NamedQuery(name = "PpLoanmaster.findByPrintOrder", query = "SELECT p FROM PpLoanmaster p WHERE p.printOrder = :printOrder"),
		@NamedQuery(name = "PpLoanmaster.findByMaxInstallmentno", query = "SELECT p FROM PpLoanmaster p WHERE p.maxInstallmentno = :maxInstallmentno") })
public class PpLoanmaster implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@Column(name = "PP_LOANMASTERID")
	private Short ppLoanmasterid;
	@Basic(optional = false)
	@Column(name = "LOANNAME")
	private String loanname;
	@Basic(optional = false)
	@Column(name = "LOANSHORTNAME")
	private String loanshortname;
	@Basic(optional = false)
	@Column(name = "PRINT_ORDER")
	private short printOrder;
	@Basic(optional = false)
	@Column(name = "MAX_INSTALLMENTNO")
	private short maxInstallmentno;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "ppLoanmasterid")
	private Collection<PpLoandetail> ppLoandetailCollection;
	@JoinColumn(name = "AC_CODE", referencedColumnName = "FWA_AC_CODE_MASTERID")
	@ManyToOne
	private FwaAcCodeMaster acCode;
	@JoinColumn(name = "PP_SCHEDULEMASTERID", referencedColumnName = "PP_SCHEDULEMASTERID")
	@ManyToOne(optional = false)
	private PpSchedulemaster ppSchedulemasterid;

	public PpLoanmaster() {
	}

	public PpLoanmaster(Short ppLoanmasterid) {
		this.ppLoanmasterid = ppLoanmasterid;
	}

	public PpLoanmaster(Short ppLoanmasterid, String loanname, String loanshortname, short printOrder,
			short maxInstallmentno) {
		this.ppLoanmasterid = ppLoanmasterid;
		this.loanname = loanname;
		this.loanshortname = loanshortname;
		this.printOrder = printOrder;
		this.maxInstallmentno = maxInstallmentno;
	}

	public Short getPpLoanmasterid() {
		return ppLoanmasterid;
	}

	public void setPpLoanmasterid(Short ppLoanmasterid) {
		this.ppLoanmasterid = ppLoanmasterid;
	}

	public String getLoanname() {
		return loanname;
	}

	public void setLoanname(String loanname) {
		this.loanname = loanname;
	}

	public String getLoanshortname() {
		return loanshortname;
	}

	public void setLoanshortname(String loanshortname) {
		this.loanshortname = loanshortname;
	}

	public short getPrintOrder() {
		return printOrder;
	}

	public void setPrintOrder(short printOrder) {
		this.printOrder = printOrder;
	}

	public short getMaxInstallmentno() {
		return maxInstallmentno;
	}

	public void setMaxInstallmentno(short maxInstallmentno) {
		this.maxInstallmentno = maxInstallmentno;
	}

	@XmlTransient
	public Collection<PpLoandetail> getPpLoandetailCollection() {
		return ppLoandetailCollection;
	}

	public void setPpLoandetailCollection(Collection<PpLoandetail> ppLoandetailCollection) {
		this.ppLoandetailCollection = ppLoandetailCollection;
	}

	public FwaAcCodeMaster getAcCode() {
		return acCode;
	}

	public void setAcCode(FwaAcCodeMaster acCode) {
		this.acCode = acCode;
	}

	public PpSchedulemaster getPpSchedulemasterid() {
		return ppSchedulemasterid;
	}

	public void setPpSchedulemasterid(PpSchedulemaster ppSchedulemasterid) {
		this.ppSchedulemasterid = ppSchedulemasterid;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (ppLoanmasterid != null ? ppLoanmasterid.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof PpLoanmaster)) {
			return false;
		}
		PpLoanmaster other = (PpLoanmaster) object;
		if ((this.ppLoanmasterid == null && other.ppLoanmasterid != null)
				|| (this.ppLoanmasterid != null && !this.ppLoanmasterid.equals(other.ppLoanmasterid))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "nicupjnentityclasses.PpLoanmaster[ ppLoanmasterid=" + ppLoanmasterid + " ]";
	}

}
