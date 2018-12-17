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
@Table(name = "PSN_SANCTIONPENSION")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "PsnSanctionpension.findAll", query = "SELECT p FROM PsnSanctionpension p"),
		@NamedQuery(name = "PsnSanctionpension.findByPsnSanctionpensionid", query = "SELECT p FROM PsnSanctionpension p WHERE p.psnSanctionpensionid = :psnSanctionpensionid"),
		@NamedQuery(name = "PsnSanctionpension.findByServiceyears", query = "SELECT p FROM PsnSanctionpension p WHERE p.serviceyears = :serviceyears"),
		@NamedQuery(name = "PsnSanctionpension.findByServicemonths", query = "SELECT p FROM PsnSanctionpension p WHERE p.servicemonths = :servicemonths"),
		@NamedQuery(name = "PsnSanctionpension.findByServicedays", query = "SELECT p FROM PsnSanctionpension p WHERE p.servicedays = :servicedays"),
		@NamedQuery(name = "PsnSanctionpension.findByOthereligibleserviceyears", query = "SELECT p FROM PsnSanctionpension p WHERE p.othereligibleserviceyears = :othereligibleserviceyears"),
		@NamedQuery(name = "PsnSanctionpension.findByOthereligibleservicemonths", query = "SELECT p FROM PsnSanctionpension p WHERE p.othereligibleservicemonths = :othereligibleservicemonths"),
		@NamedQuery(name = "PsnSanctionpension.findByOthereligibleservicedays", query = "SELECT p FROM PsnSanctionpension p WHERE p.othereligibleservicedays = :othereligibleservicedays"),
		@NamedQuery(name = "PsnSanctionpension.findByNoneligibleserviceyears", query = "SELECT p FROM PsnSanctionpension p WHERE p.noneligibleserviceyears = :noneligibleserviceyears"),
		@NamedQuery(name = "PsnSanctionpension.findByNoneligibleservicemonths", query = "SELECT p FROM PsnSanctionpension p WHERE p.noneligibleservicemonths = :noneligibleservicemonths"),
		@NamedQuery(name = "PsnSanctionpension.findByNoneligibleservicedays", query = "SELECT p FROM PsnSanctionpension p WHERE p.noneligibleservicedays = :noneligibleservicedays"),
		@NamedQuery(name = "PsnSanctionpension.findByTypeofpension", query = "SELECT p FROM PsnSanctionpension p WHERE p.typeofpension = :typeofpension"),
		@NamedQuery(name = "PsnSanctionpension.findByLastpaydrawn", query = "SELECT p FROM PsnSanctionpension p WHERE p.lastpaydrawn = :lastpaydrawn"),
		@NamedQuery(name = "PsnSanctionpension.findByAvgoflasttenpay", query = "SELECT p FROM PsnSanctionpension p WHERE p.avgoflasttenpay = :avgoflasttenpay"),
		@NamedQuery(name = "PsnSanctionpension.findByCommutationpercent", query = "SELECT p FROM PsnSanctionpension p WHERE p.commutationpercent = :commutationpercent"),
		@NamedQuery(name = "PsnSanctionpension.findByIspensionsanctioned", query = "SELECT p FROM PsnSanctionpension p WHERE p.ispensionsanctioned = :ispensionsanctioned"),
		@NamedQuery(name = "PsnSanctionpension.findByPensionissuedate", query = "SELECT p FROM PsnSanctionpension p WHERE p.pensionissuedate = :pensionissuedate"),
		@NamedQuery(name = "PsnSanctionpension.findByIsprovisional", query = "SELECT p FROM PsnSanctionpension p WHERE p.isprovisional = :isprovisional"),
		@NamedQuery(name = "PsnSanctionpension.findByHbadue", query = "SELECT p FROM PsnSanctionpension p WHERE p.hbadue = :hbadue"),
		@NamedQuery(name = "PsnSanctionpension.findByVehicaldue", query = "SELECT p FROM PsnSanctionpension p WHERE p.vehicaldue = :vehicaldue"),
		@NamedQuery(name = "PsnSanctionpension.findByOtheradvancedue", query = "SELECT p FROM PsnSanctionpension p WHERE p.otheradvancedue = :otheradvancedue"),
		@NamedQuery(name = "PsnSanctionpension.findByHouserentdue", query = "SELECT p FROM PsnSanctionpension p WHERE p.houserentdue = :houserentdue"),
		@NamedQuery(name = "PsnSanctionpension.findByAuditdue", query = "SELECT p FROM PsnSanctionpension p WHERE p.auditdue = :auditdue"),
		@NamedQuery(name = "PsnSanctionpension.findByOtherdue", query = "SELECT p FROM PsnSanctionpension p WHERE p.otherdue = :otherdue"),
		@NamedQuery(name = "PsnSanctionpension.findByDeptdue", query = "SELECT p FROM PsnSanctionpension p WHERE p.deptdue = :deptdue"),
		@NamedQuery(name = "PsnSanctionpension.findByCommutationamount", query = "SELECT p FROM PsnSanctionpension p WHERE p.commutationamount = :commutationamount"),
		@NamedQuery(name = "PsnSanctionpension.findByCommutationappdate", query = "SELECT p FROM PsnSanctionpension p WHERE p.commutationappdate = :commutationappdate"),
		@NamedQuery(name = "PsnSanctionpension.findByCommutationstartdate", query = "SELECT p FROM PsnSanctionpension p WHERE p.commutationstartdate = :commutationstartdate"),
		@NamedQuery(name = "PsnSanctionpension.findByCommutationstopdate", query = "SELECT p FROM PsnSanctionpension p WHERE p.commutationstopdate = :commutationstopdate"),
		@NamedQuery(name = "PsnSanctionpension.findByRemarkforrejection", query = "SELECT p FROM PsnSanctionpension p WHERE p.remarkforrejection = :remarkforrejection"),
		@NamedQuery(name = "PsnSanctionpension.findByPensionertype", query = "SELECT p FROM PsnSanctionpension p WHERE p.pensionertype = :pensionertype"),
		@NamedQuery(name = "PsnSanctionpension.findByTypeofgratuity", query = "SELECT p FROM PsnSanctionpension p WHERE p.typeofgratuity = :typeofgratuity") })
public class PsnSanctionpension implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@Column(name = "PSN_SANCTIONPENSIONID")
	private Long psnSanctionpensionid;
	@Column(name = "SERVICEYEARS")
	private Short serviceyears;
	@Column(name = "SERVICEMONTHS")
	private Short servicemonths;
	@Column(name = "SERVICEDAYS")
	private Short servicedays;
	@Column(name = "OTHERELIGIBLESERVICEYEARS")
	private Short othereligibleserviceyears;
	@Column(name = "OTHERELIGIBLESERVICEMONTHS")
	private Short othereligibleservicemonths;
	@Column(name = "OTHERELIGIBLESERVICEDAYS")
	private Short othereligibleservicedays;
	@Column(name = "NONELIGIBLESERVICEYEARS")
	private Short noneligibleserviceyears;
	@Column(name = "NONELIGIBLESERVICEMONTHS")
	private Short noneligibleservicemonths;
	@Column(name = "NONELIGIBLESERVICEDAYS")
	private Short noneligibleservicedays;
	@Basic(optional = false)
	@Column(name = "TYPEOFPENSION")
	private String typeofpension;
	@Column(name = "LASTPAYDRAWN")
	private Integer lastpaydrawn;
	@Column(name = "AVGOFLASTTENPAY")
	private Integer avgoflasttenpay;
	@Column(name = "COMMUTATIONPERCENT")
	private Short commutationpercent;
	@Basic(optional = false)
	@Column(name = "ISPENSIONSANCTIONED")
	private Character ispensionsanctioned;
	@Basic(optional = false)
	@Column(name = "PENSIONISSUEDATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date pensionissuedate;
	@Basic(optional = false)
	@Column(name = "ISPROVISIONAL")
	private Character isprovisional;
	@Column(name = "HBADUE")
	private Integer hbadue;
	@Column(name = "VEHICALDUE")
	private Integer vehicaldue;
	@Column(name = "OTHERADVANCEDUE")
	private Integer otheradvancedue;
	@Column(name = "HOUSERENTDUE")
	private Integer houserentdue;
	@Column(name = "AUDITDUE")
	private Integer auditdue;
	@Column(name = "OTHERDUE")
	private Integer otherdue;
	@Column(name = "DEPTDUE")
	private Integer deptdue;
	@Basic(optional = false)
	@Column(name = "COMMUTATIONAMOUNT")
	private int commutationamount;
	@Column(name = "COMMUTATIONAPPDATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date commutationappdate;
	@Column(name = "COMMUTATIONSTARTDATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date commutationstartdate;
	@Column(name = "COMMUTATIONSTOPDATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date commutationstopdate;
	@Column(name = "REMARKFORREJECTION")
	private String remarkforrejection;
	@Basic(optional = false)
	@Column(name = "PENSIONERTYPE")
	private String pensionertype;
	@Column(name = "TYPEOFGRATUITY")
	private String typeofgratuity;
	@JoinColumn(name = "PSN_EMPLOYEEPENSION_MASTERID", referencedColumnName = "PSN_EMPLOYEEPENSION_MASTERID")
	@ManyToOne
	private PsnEmployeepensionMaster psnEmployeepensionMasterid;

	public PsnSanctionpension() {
	}

	public PsnSanctionpension(Long psnSanctionpensionid) {
		this.psnSanctionpensionid = psnSanctionpensionid;
	}

	public PsnSanctionpension(Long psnSanctionpensionid, String typeofpension, Character ispensionsanctioned,
			Date pensionissuedate, Character isprovisional, int commutationamount, String pensionertype) {
		this.psnSanctionpensionid = psnSanctionpensionid;
		this.typeofpension = typeofpension;
		this.ispensionsanctioned = ispensionsanctioned;
		this.pensionissuedate = pensionissuedate;
		this.isprovisional = isprovisional;
		this.commutationamount = commutationamount;
		this.pensionertype = pensionertype;
	}

	public Long getPsnSanctionpensionid() {
		return psnSanctionpensionid;
	}

	public void setPsnSanctionpensionid(Long psnSanctionpensionid) {
		this.psnSanctionpensionid = psnSanctionpensionid;
	}

	public Short getServiceyears() {
		return serviceyears;
	}

	public void setServiceyears(Short serviceyears) {
		this.serviceyears = serviceyears;
	}

	public Short getServicemonths() {
		return servicemonths;
	}

	public void setServicemonths(Short servicemonths) {
		this.servicemonths = servicemonths;
	}

	public Short getServicedays() {
		return servicedays;
	}

	public void setServicedays(Short servicedays) {
		this.servicedays = servicedays;
	}

	public Short getOthereligibleserviceyears() {
		return othereligibleserviceyears;
	}

	public void setOthereligibleserviceyears(Short othereligibleserviceyears) {
		this.othereligibleserviceyears = othereligibleserviceyears;
	}

	public Short getOthereligibleservicemonths() {
		return othereligibleservicemonths;
	}

	public void setOthereligibleservicemonths(Short othereligibleservicemonths) {
		this.othereligibleservicemonths = othereligibleservicemonths;
	}

	public Short getOthereligibleservicedays() {
		return othereligibleservicedays;
	}

	public void setOthereligibleservicedays(Short othereligibleservicedays) {
		this.othereligibleservicedays = othereligibleservicedays;
	}

	public Short getNoneligibleserviceyears() {
		return noneligibleserviceyears;
	}

	public void setNoneligibleserviceyears(Short noneligibleserviceyears) {
		this.noneligibleserviceyears = noneligibleserviceyears;
	}

	public Short getNoneligibleservicemonths() {
		return noneligibleservicemonths;
	}

	public void setNoneligibleservicemonths(Short noneligibleservicemonths) {
		this.noneligibleservicemonths = noneligibleservicemonths;
	}

	public Short getNoneligibleservicedays() {
		return noneligibleservicedays;
	}

	public void setNoneligibleservicedays(Short noneligibleservicedays) {
		this.noneligibleservicedays = noneligibleservicedays;
	}

	public String getTypeofpension() {
		return typeofpension;
	}

	public void setTypeofpension(String typeofpension) {
		this.typeofpension = typeofpension;
	}

	public Integer getLastpaydrawn() {
		return lastpaydrawn;
	}

	public void setLastpaydrawn(Integer lastpaydrawn) {
		this.lastpaydrawn = lastpaydrawn;
	}

	public Integer getAvgoflasttenpay() {
		return avgoflasttenpay;
	}

	public void setAvgoflasttenpay(Integer avgoflasttenpay) {
		this.avgoflasttenpay = avgoflasttenpay;
	}

	public Short getCommutationpercent() {
		return commutationpercent;
	}

	public void setCommutationpercent(Short commutationpercent) {
		this.commutationpercent = commutationpercent;
	}

	public Character getIspensionsanctioned() {
		return ispensionsanctioned;
	}

	public void setIspensionsanctioned(Character ispensionsanctioned) {
		this.ispensionsanctioned = ispensionsanctioned;
	}

	public Date getPensionissuedate() {
		return pensionissuedate;
	}

	public void setPensionissuedate(Date pensionissuedate) {
		this.pensionissuedate = pensionissuedate;
	}

	public Character getIsprovisional() {
		return isprovisional;
	}

	public void setIsprovisional(Character isprovisional) {
		this.isprovisional = isprovisional;
	}

	public Integer getHbadue() {
		return hbadue;
	}

	public void setHbadue(Integer hbadue) {
		this.hbadue = hbadue;
	}

	public Integer getVehicaldue() {
		return vehicaldue;
	}

	public void setVehicaldue(Integer vehicaldue) {
		this.vehicaldue = vehicaldue;
	}

	public Integer getOtheradvancedue() {
		return otheradvancedue;
	}

	public void setOtheradvancedue(Integer otheradvancedue) {
		this.otheradvancedue = otheradvancedue;
	}

	public Integer getHouserentdue() {
		return houserentdue;
	}

	public void setHouserentdue(Integer houserentdue) {
		this.houserentdue = houserentdue;
	}

	public Integer getAuditdue() {
		return auditdue;
	}

	public void setAuditdue(Integer auditdue) {
		this.auditdue = auditdue;
	}

	public Integer getOtherdue() {
		return otherdue;
	}

	public void setOtherdue(Integer otherdue) {
		this.otherdue = otherdue;
	}

	public Integer getDeptdue() {
		return deptdue;
	}

	public void setDeptdue(Integer deptdue) {
		this.deptdue = deptdue;
	}

	public int getCommutationamount() {
		return commutationamount;
	}

	public void setCommutationamount(int commutationamount) {
		this.commutationamount = commutationamount;
	}

	public Date getCommutationappdate() {
		return commutationappdate;
	}

	public void setCommutationappdate(Date commutationappdate) {
		this.commutationappdate = commutationappdate;
	}

	public Date getCommutationstartdate() {
		return commutationstartdate;
	}

	public void setCommutationstartdate(Date commutationstartdate) {
		this.commutationstartdate = commutationstartdate;
	}

	public Date getCommutationstopdate() {
		return commutationstopdate;
	}

	public void setCommutationstopdate(Date commutationstopdate) {
		this.commutationstopdate = commutationstopdate;
	}

	public String getRemarkforrejection() {
		return remarkforrejection;
	}

	public void setRemarkforrejection(String remarkforrejection) {
		this.remarkforrejection = remarkforrejection;
	}

	public String getPensionertype() {
		return pensionertype;
	}

	public void setPensionertype(String pensionertype) {
		this.pensionertype = pensionertype;
	}

	public String getTypeofgratuity() {
		return typeofgratuity;
	}

	public void setTypeofgratuity(String typeofgratuity) {
		this.typeofgratuity = typeofgratuity;
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
		hash += (psnSanctionpensionid != null ? psnSanctionpensionid.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof PsnSanctionpension)) {
			return false;
		}
		PsnSanctionpension other = (PsnSanctionpension) object;
		if ((this.psnSanctionpensionid == null && other.psnSanctionpensionid != null)
				|| (this.psnSanctionpensionid != null
						&& !this.psnSanctionpensionid.equals(other.psnSanctionpensionid))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "nicupjnentityclasses.PsnSanctionpension[ psnSanctionpensionid=" + psnSanctionpensionid + " ]";
	}

}
