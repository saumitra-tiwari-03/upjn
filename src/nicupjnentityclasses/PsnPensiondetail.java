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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "PSN_PENSIONDETAIL")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "PsnPensiondetail.findAll", query = "SELECT p FROM PsnPensiondetail p"),
		@NamedQuery(name = "PsnPensiondetail.findByPsnPensiondetailid", query = "SELECT p FROM PsnPensiondetail p WHERE p.psnPensiondetailid = :psnPensiondetailid"),
		@NamedQuery(name = "PsnPensiondetail.findByDateofeffect", query = "SELECT p FROM PsnPensiondetail p WHERE p.dateofeffect = :dateofeffect"),
		@NamedQuery(name = "PsnPensiondetail.findByNormalRate", query = "SELECT p FROM PsnPensiondetail p WHERE p.normalRate = :normalRate"),
		@NamedQuery(name = "PsnPensiondetail.findByBasicpension", query = "SELECT p FROM PsnPensiondetail p WHERE p.basicpension = :basicpension"),
		@NamedQuery(name = "PsnPensiondetail.findByFamilypensionupto7years", query = "SELECT p FROM PsnPensiondetail p WHERE p.familypensionupto7years = :familypensionupto7years"),
		@NamedQuery(name = "PsnPensiondetail.findByFamilypensionafter7years", query = "SELECT p FROM PsnPensiondetail p WHERE p.familypensionafter7years = :familypensionafter7years"),
		@NamedQuery(name = "PsnPensiondetail.findByFamilypensionbreakdate", query = "SELECT p FROM PsnPensiondetail p WHERE p.familypensionbreakdate = :familypensionbreakdate"),
		@NamedQuery(name = "PsnPensiondetail.findByDeduction1", query = "SELECT p FROM PsnPensiondetail p WHERE p.deduction1 = :deduction1"),
		@NamedQuery(name = "PsnPensiondetail.findByDeduction2", query = "SELECT p FROM PsnPensiondetail p WHERE p.deduction2 = :deduction2"),
		@NamedQuery(name = "PsnPensiondetail.findByOtherpayable", query = "SELECT p FROM PsnPensiondetail p WHERE p.otherpayable = :otherpayable"),
		@NamedQuery(name = "PsnPensiondetail.findByCommutationdedamount", query = "SELECT p FROM PsnPensiondetail p WHERE p.commutationdedamount = :commutationdedamount"),
		@NamedQuery(name = "PsnPensiondetail.findByIsdaapplicable", query = "SELECT p FROM PsnPensiondetail p WHERE p.isdaapplicable = :isdaapplicable"),
		@NamedQuery(name = "PsnPensiondetail.findByDaamount", query = "SELECT p FROM PsnPensiondetail p WHERE p.daamount = :daamount"),
		@NamedQuery(name = "PsnPensiondetail.findByIncomtax", query = "SELECT p FROM PsnPensiondetail p WHERE p.incomtax = :incomtax"),
		@NamedQuery(name = "PsnPensiondetail.findByIr1", query = "SELECT p FROM PsnPensiondetail p WHERE p.ir1 = :ir1"),
		@NamedQuery(name = "PsnPensiondetail.findByIr2", query = "SELECT p FROM PsnPensiondetail p WHERE p.ir2 = :ir2"),
		@NamedQuery(name = "PsnPensiondetail.findByPsnSanctionpensionid", query = "SELECT p FROM PsnPensiondetail p WHERE p.psnSanctionpensionid = :psnSanctionpensionid"),
		@NamedQuery(name = "PsnPensiondetail.findByDisabledBySystem", query = "SELECT p FROM PsnPensiondetail p WHERE p.disabledBySystem = :disabledBySystem"),
		@NamedQuery(name = "PsnPensiondetail.findByGratuityamount", query = "SELECT p FROM PsnPensiondetail p WHERE p.gratuityamount = :gratuityamount") })
public class PsnPensiondetail implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@Column(name = "PSN_PENSIONDETAILID")
	private Long psnPensiondetailid;
	@Basic(optional = false)
	@Column(name = "DATEOFEFFECT")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateofeffect;
	@Basic(optional = false)
	@Column(name = "NORMAL_RATE")
	private int normalRate;
	@Basic(optional = false)
	@Column(name = "BASICPENSION")
	private int basicpension;
	@Basic(optional = false)
	@Column(name = "FAMILYPENSIONUPTO7YEARS")
	private int familypensionupto7years;
	@Basic(optional = false)
	@Column(name = "FAMILYPENSIONAFTER7YEARS")
	private int familypensionafter7years;
	@Basic(optional = false)
	@Column(name = "FAMILYPENSIONBREAKDATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date familypensionbreakdate;
	@Basic(optional = false)
	@Column(name = "DEDUCTION1")
	private int deduction1;
	@Basic(optional = false)
	@Column(name = "DEDUCTION2")
	private int deduction2;
	@Basic(optional = false)
	@Column(name = "OTHERPAYABLE")
	private int otherpayable;
	@Basic(optional = false)
	@Column(name = "COMMUTATIONDEDAMOUNT")
	private int commutationdedamount;
	@Basic(optional = false)
	@Column(name = "ISDAAPPLICABLE")
	private Character isdaapplicable;
	@Basic(optional = false)
	@Column(name = "DAAMOUNT")
	private int daamount;
	@Basic(optional = false)
	@Column(name = "INCOMTAX")
	private int incomtax;
	@Basic(optional = false)
	@Column(name = "IR1")
	private int ir1;
	@Basic(optional = false)
	@Column(name = "IR2")
	private int ir2;
	@Column(name = "PSN_SANCTIONPENSIONID")
	private Long psnSanctionpensionid;
	@Basic(optional = false)
	@Column(name = "DISABLED_BY_SYSTEM")
	private Character disabledBySystem;
	// @Max(value=?) @Min(value=?)//if you know range of your decimal fields
	// consider using these annotations to enforce field validation
	@Column(name = "GRATUITYAMOUNT")
	private BigDecimal gratuityamount;
	@JoinColumn(name = "PSN_EMPLOYEEPENSION_MASTERID", referencedColumnName = "PSN_EMPLOYEEPENSION_MASTERID")
	@ManyToOne(optional = false)
	private PsnEmployeepensionMaster psnEmployeepensionMasterid;

	public PsnPensiondetail() {
	}

	public PsnPensiondetail(Long psnPensiondetailid) {
		this.psnPensiondetailid = psnPensiondetailid;
	}

	public PsnPensiondetail(Long psnPensiondetailid, Date dateofeffect, int normalRate, int basicpension,
			int familypensionupto7years, int familypensionafter7years, Date familypensionbreakdate, int deduction1,
			int deduction2, int otherpayable, int commutationdedamount, Character isdaapplicable, int daamount,
			int incomtax, int ir1, int ir2, Character disabledBySystem) {
		this.psnPensiondetailid = psnPensiondetailid;
		this.dateofeffect = dateofeffect;
		this.normalRate = normalRate;
		this.basicpension = basicpension;
		this.familypensionupto7years = familypensionupto7years;
		this.familypensionafter7years = familypensionafter7years;
		this.familypensionbreakdate = familypensionbreakdate;
		this.deduction1 = deduction1;
		this.deduction2 = deduction2;
		this.otherpayable = otherpayable;
		this.commutationdedamount = commutationdedamount;
		this.isdaapplicable = isdaapplicable;
		this.daamount = daamount;
		this.incomtax = incomtax;
		this.ir1 = ir1;
		this.ir2 = ir2;
		this.disabledBySystem = disabledBySystem;
	}

	public Long getPsnPensiondetailid() {
		return psnPensiondetailid;
	}

	public void setPsnPensiondetailid(Long psnPensiondetailid) {
		this.psnPensiondetailid = psnPensiondetailid;
	}

	public Date getDateofeffect() {
		return dateofeffect;
	}

	public void setDateofeffect(Date dateofeffect) {
		this.dateofeffect = dateofeffect;
	}

	public int getNormalRate() {
		return normalRate;
	}

	public void setNormalRate(int normalRate) {
		this.normalRate = normalRate;
	}

	public int getBasicpension() {
		return basicpension;
	}

	public void setBasicpension(int basicpension) {
		this.basicpension = basicpension;
	}

	public int getFamilypensionupto7years() {
		return familypensionupto7years;
	}

	public void setFamilypensionupto7years(int familypensionupto7years) {
		this.familypensionupto7years = familypensionupto7years;
	}

	public int getFamilypensionafter7years() {
		return familypensionafter7years;
	}

	public void setFamilypensionafter7years(int familypensionafter7years) {
		this.familypensionafter7years = familypensionafter7years;
	}

	public Date getFamilypensionbreakdate() {
		return familypensionbreakdate;
	}

	public void setFamilypensionbreakdate(Date familypensionbreakdate) {
		this.familypensionbreakdate = familypensionbreakdate;
	}

	public int getDeduction1() {
		return deduction1;
	}

	public void setDeduction1(int deduction1) {
		this.deduction1 = deduction1;
	}

	public int getDeduction2() {
		return deduction2;
	}

	public void setDeduction2(int deduction2) {
		this.deduction2 = deduction2;
	}

	public int getOtherpayable() {
		return otherpayable;
	}

	public void setOtherpayable(int otherpayable) {
		this.otherpayable = otherpayable;
	}

	public int getCommutationdedamount() {
		return commutationdedamount;
	}

	public void setCommutationdedamount(int commutationdedamount) {
		this.commutationdedamount = commutationdedamount;
	}

	public Character getIsdaapplicable() {
		return isdaapplicable;
	}

	public void setIsdaapplicable(Character isdaapplicable) {
		this.isdaapplicable = isdaapplicable;
	}

	public int getDaamount() {
		return daamount;
	}

	public void setDaamount(int daamount) {
		this.daamount = daamount;
	}

	public int getIncomtax() {
		return incomtax;
	}

	public void setIncomtax(int incomtax) {
		this.incomtax = incomtax;
	}

	public int getIr1() {
		return ir1;
	}

	public void setIr1(int ir1) {
		this.ir1 = ir1;
	}

	public int getIr2() {
		return ir2;
	}

	public void setIr2(int ir2) {
		this.ir2 = ir2;
	}

	public Long getPsnSanctionpensionid() {
		return psnSanctionpensionid;
	}

	public void setPsnSanctionpensionid(Long psnSanctionpensionid) {
		this.psnSanctionpensionid = psnSanctionpensionid;
	}

	public Character getDisabledBySystem() {
		return disabledBySystem;
	}

	public void setDisabledBySystem(Character disabledBySystem) {
		this.disabledBySystem = disabledBySystem;
	}

	public BigDecimal getGratuityamount() {
		return gratuityamount;
	}

	public void setGratuityamount(BigDecimal gratuityamount) {
		this.gratuityamount = gratuityamount;
	}

	public PsnEmployeepensionMaster getPsnEmployeepensionMasterid() {
		return psnEmployeepensionMasterid;
	}

	public void setPsnEmployeepensionMasterid(PsnEmployeepensionMaster psnEmployeepensionMasterid) {
		this.psnEmployeepensionMasterid = psnEmployeepensionMasterid;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (psnPensiondetailid != null ? psnPensiondetailid.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof PsnPensiondetail)) {
			return false;
		}
		PsnPensiondetail other = (PsnPensiondetail) object;
		if ((this.psnPensiondetailid == null && other.psnPensiondetailid != null)
				|| (this.psnPensiondetailid != null && !this.psnPensiondetailid.equals(other.psnPensiondetailid))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "nicupjnentityclasses.PsnPensiondetail[ psnPensiondetailid=" + psnPensiondetailid + " ]";
	}

}
