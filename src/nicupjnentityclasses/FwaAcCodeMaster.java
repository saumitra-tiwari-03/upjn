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
@Table(name = "FWA_AC_CODE_MASTER")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "FwaAcCodeMaster.findAll", query = "SELECT f FROM FwaAcCodeMaster f"),
		@NamedQuery(name = "FwaAcCodeMaster.findByFwaAcCodeMasterid", query = "SELECT f FROM FwaAcCodeMaster f WHERE f.fwaAcCodeMasterid = :fwaAcCodeMasterid"),
		@NamedQuery(name = "FwaAcCodeMaster.findByAcCode", query = "SELECT f FROM FwaAcCodeMaster f WHERE f.acCode = :acCode"),
		@NamedQuery(name = "FwaAcCodeMaster.findByHeadName", query = "SELECT f FROM FwaAcCodeMaster f WHERE f.headName = :headName"),
		@NamedQuery(name = "FwaAcCodeMaster.findByDescription", query = "SELECT f FROM FwaAcCodeMaster f WHERE f.description = :description"),
		@NamedQuery(name = "FwaAcCodeMaster.findByParentAcCodeid", query = "SELECT f FROM FwaAcCodeMaster f WHERE f.parentAcCodeid = :parentAcCodeid"),
		@NamedQuery(name = "FwaAcCodeMaster.findByAccounttype", query = "SELECT f FROM FwaAcCodeMaster f WHERE f.accounttype = :accounttype"),
		@NamedQuery(name = "FwaAcCodeMaster.findByActiveFlag", query = "SELECT f FROM FwaAcCodeMaster f WHERE f.activeFlag = :activeFlag"),
		@NamedQuery(name = "FwaAcCodeMaster.findByIsoperatedbyho", query = "SELECT f FROM FwaAcCodeMaster f WHERE f.isoperatedbyho = :isoperatedbyho"),
		@NamedQuery(name = "FwaAcCodeMaster.findByDirectpaymentapplicable", query = "SELECT f FROM FwaAcCodeMaster f WHERE f.directpaymentapplicable = :directpaymentapplicable"),
		@NamedQuery(name = "FwaAcCodeMaster.findByIsdeduction", query = "SELECT f FROM FwaAcCodeMaster f WHERE f.isdeduction = :isdeduction") })
public class FwaAcCodeMaster implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@Column(name = "FWA_AC_CODE_MASTERID")
	private Integer fwaAcCodeMasterid;
	@Basic(optional = false)
	@Column(name = "AC_CODE")
	private String acCode;
	@Basic(optional = false)
	@Column(name = "HEAD_NAME")
	private String headName;
	@Basic(optional = false)
	@Column(name = "DESCRIPTION")
	private String description;
	@Column(name = "PARENT_AC_CODEID")
	private Integer parentAcCodeid;
	@Basic(optional = false)
	@Column(name = "ACCOUNTTYPE")
	private int accounttype;
	@Column(name = "ACTIVE_FLAG")
	private Character activeFlag;
	@Basic(optional = false)
	@Column(name = "ISOPERATEDBYHO")
	private Character isoperatedbyho;
	@Basic(optional = false)
	@Column(name = "DIRECTPAYMENTAPPLICABLE")
	private Character directpaymentapplicable;
	@Basic(optional = false)
	@Column(name = "ISDEDUCTION")
	private Character isdeduction;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "fwaAcCodeMasterid")
	private Collection<FwaTransaction> fwaTransactionCollection;
	@OneToMany(mappedBy = "acCode")
	private Collection<MasAcHeadController> masAcHeadControllerCollection;
	@OneToMany(mappedBy = "acCode")
	private Collection<PpDeductionmaster> ppDeductionmasterCollection;
	@OneToMany(mappedBy = "fwaAcCodeMasteridL")
	private Collection<SpProgram> spProgramCollection;
	@OneToMany(mappedBy = "fwaAcCodeMasterid")
	private Collection<SpProgram> spProgramCollection1;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "fwaAcCodeMasterid")
	private Collection<FwaTeoTran> fwaTeoTranCollection;
	@OneToMany(mappedBy = "acCode")
	private Collection<PpLoanmaster> ppLoanmasterCollection;
	@JoinColumn(name = "MAS_BSCODEMASTERID", referencedColumnName = "MAS_BSCODEMASTERID")
	@ManyToOne
	private MasBscodemaster masBscodemasterid;
	@OneToMany(mappedBy = "acCode")
	private Collection<PpPayalwhead> ppPayalwheadCollection;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "fwaAcCodeMasterid")
	private Collection<FwaClosingbalances> fwaClosingbalancesCollection;

	public FwaAcCodeMaster() {
	}

	public FwaAcCodeMaster(Integer fwaAcCodeMasterid) {
		this.fwaAcCodeMasterid = fwaAcCodeMasterid;
	}

	public FwaAcCodeMaster(Integer fwaAcCodeMasterid, String acCode, String headName, String description,
			int accounttype, Character isoperatedbyho, Character directpaymentapplicable, Character isdeduction) {
		this.fwaAcCodeMasterid = fwaAcCodeMasterid;
		this.acCode = acCode;
		this.headName = headName;
		this.description = description;
		this.accounttype = accounttype;
		this.isoperatedbyho = isoperatedbyho;
		this.directpaymentapplicable = directpaymentapplicable;
		this.isdeduction = isdeduction;
	}

	public Integer getFwaAcCodeMasterid() {
		return fwaAcCodeMasterid;
	}

	public void setFwaAcCodeMasterid(Integer fwaAcCodeMasterid) {
		this.fwaAcCodeMasterid = fwaAcCodeMasterid;
	}

	public String getAcCode() {
		return acCode;
	}

	public void setAcCode(String acCode) {
		this.acCode = acCode;
	}

	public String getHeadName() {
		return headName;
	}

	public void setHeadName(String headName) {
		this.headName = headName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getParentAcCodeid() {
		return parentAcCodeid;
	}

	public void setParentAcCodeid(Integer parentAcCodeid) {
		this.parentAcCodeid = parentAcCodeid;
	}

	public int getAccounttype() {
		return accounttype;
	}

	public void setAccounttype(int accounttype) {
		this.accounttype = accounttype;
	}

	public Character getActiveFlag() {
		return activeFlag;
	}

	public void setActiveFlag(Character activeFlag) {
		this.activeFlag = activeFlag;
	}

	public Character getIsoperatedbyho() {
		return isoperatedbyho;
	}

	public void setIsoperatedbyho(Character isoperatedbyho) {
		this.isoperatedbyho = isoperatedbyho;
	}

	public Character getDirectpaymentapplicable() {
		return directpaymentapplicable;
	}

	public void setDirectpaymentapplicable(Character directpaymentapplicable) {
		this.directpaymentapplicable = directpaymentapplicable;
	}

	public Character getIsdeduction() {
		return isdeduction;
	}

	public void setIsdeduction(Character isdeduction) {
		this.isdeduction = isdeduction;
	}

	@XmlTransient
	public Collection<FwaTransaction> getFwaTransactionCollection() {
		return fwaTransactionCollection;
	}

	public void setFwaTransactionCollection(Collection<FwaTransaction> fwaTransactionCollection) {
		this.fwaTransactionCollection = fwaTransactionCollection;
	}

	@XmlTransient
	public Collection<MasAcHeadController> getMasAcHeadControllerCollection() {
		return masAcHeadControllerCollection;
	}

	public void setMasAcHeadControllerCollection(Collection<MasAcHeadController> masAcHeadControllerCollection) {
		this.masAcHeadControllerCollection = masAcHeadControllerCollection;
	}

	@XmlTransient
	public Collection<PpDeductionmaster> getPpDeductionmasterCollection() {
		return ppDeductionmasterCollection;
	}

	public void setPpDeductionmasterCollection(Collection<PpDeductionmaster> ppDeductionmasterCollection) {
		this.ppDeductionmasterCollection = ppDeductionmasterCollection;
	}

	@XmlTransient
	public Collection<SpProgram> getSpProgramCollection() {
		return spProgramCollection;
	}

	public void setSpProgramCollection(Collection<SpProgram> spProgramCollection) {
		this.spProgramCollection = spProgramCollection;
	}

	@XmlTransient
	public Collection<SpProgram> getSpProgramCollection1() {
		return spProgramCollection1;
	}

	public void setSpProgramCollection1(Collection<SpProgram> spProgramCollection1) {
		this.spProgramCollection1 = spProgramCollection1;
	}

	@XmlTransient
	public Collection<FwaTeoTran> getFwaTeoTranCollection() {
		return fwaTeoTranCollection;
	}

	public void setFwaTeoTranCollection(Collection<FwaTeoTran> fwaTeoTranCollection) {
		this.fwaTeoTranCollection = fwaTeoTranCollection;
	}

	@XmlTransient
	public Collection<PpLoanmaster> getPpLoanmasterCollection() {
		return ppLoanmasterCollection;
	}

	public void setPpLoanmasterCollection(Collection<PpLoanmaster> ppLoanmasterCollection) {
		this.ppLoanmasterCollection = ppLoanmasterCollection;
	}

	public MasBscodemaster getMasBscodemasterid() {
		return masBscodemasterid;
	}

	public void setMasBscodemasterid(MasBscodemaster masBscodemasterid) {
		this.masBscodemasterid = masBscodemasterid;
	}

	@XmlTransient
	public Collection<PpPayalwhead> getPpPayalwheadCollection() {
		return ppPayalwheadCollection;
	}

	public void setPpPayalwheadCollection(Collection<PpPayalwhead> ppPayalwheadCollection) {
		this.ppPayalwheadCollection = ppPayalwheadCollection;
	}

	@XmlTransient
	public Collection<FwaClosingbalances> getFwaClosingbalancesCollection() {
		return fwaClosingbalancesCollection;
	}

	public void setFwaClosingbalancesCollection(Collection<FwaClosingbalances> fwaClosingbalancesCollection) {
		this.fwaClosingbalancesCollection = fwaClosingbalancesCollection;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (fwaAcCodeMasterid != null ? fwaAcCodeMasterid.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof FwaAcCodeMaster)) {
			return false;
		}
		FwaAcCodeMaster other = (FwaAcCodeMaster) object;
		if ((this.fwaAcCodeMasterid == null && other.fwaAcCodeMasterid != null)
				|| (this.fwaAcCodeMasterid != null && !this.fwaAcCodeMasterid.equals(other.fwaAcCodeMasterid))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "nicupjnentityclasses.FwaAcCodeMaster[ fwaAcCodeMasterid=" + fwaAcCodeMasterid + " ]";
	}

}
