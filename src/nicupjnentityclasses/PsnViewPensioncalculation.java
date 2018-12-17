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
@Table(name = "PSN_VIEW_PENSIONCALCULATION")
@XmlRootElement
@NamedQueries({
		@NamedQuery(name = "PsnViewPensioncalculation.findAll", query = "SELECT p FROM PsnViewPensioncalculation p"),
		@NamedQuery(name = "PsnViewPensioncalculation.findByPsnEmployeepensionMasterid", query = "SELECT p FROM PsnViewPensioncalculation p WHERE p.psnEmployeepensionMasterid = :psnEmployeepensionMasterid"),
		@NamedQuery(name = "PsnViewPensioncalculation.findByEmployeename", query = "SELECT p FROM PsnViewPensioncalculation p WHERE p.employeename = :employeename"),
		@NamedQuery(name = "PsnViewPensioncalculation.findByLastdesignation", query = "SELECT p FROM PsnViewPensioncalculation p WHERE p.lastdesignation = :lastdesignation"),
		@NamedQuery(name = "PsnViewPensioncalculation.findByDateofbirth", query = "SELECT p FROM PsnViewPensioncalculation p WHERE p.dateofbirth = :dateofbirth"),
		@NamedQuery(name = "PsnViewPensioncalculation.findByDateofretirement", query = "SELECT p FROM PsnViewPensioncalculation p WHERE p.dateofretirement = :dateofretirement"),
		@NamedQuery(name = "PsnViewPensioncalculation.findByJoiningdate", query = "SELECT p FROM PsnViewPensioncalculation p WHERE p.joiningdate = :joiningdate"),
		@NamedQuery(name = "PsnViewPensioncalculation.findByDateofdeath", query = "SELECT p FROM PsnViewPensioncalculation p WHERE p.dateofdeath = :dateofdeath"),
		@NamedQuery(name = "PsnViewPensioncalculation.findByIsdirectentry", query = "SELECT p FROM PsnViewPensioncalculation p WHERE p.isdirectentry = :isdirectentry"),
		@NamedQuery(name = "PsnViewPensioncalculation.findByRmOfficeid", query = "SELECT p FROM PsnViewPensioncalculation p WHERE p.rmOfficeid = :rmOfficeid"),
		@NamedQuery(name = "PsnViewPensioncalculation.findByFpName", query = "SELECT p FROM PsnViewPensioncalculation p WHERE p.fpName = :fpName"),
		@NamedQuery(name = "PsnViewPensioncalculation.findByFamilypensiontype", query = "SELECT p FROM PsnViewPensioncalculation p WHERE p.familypensiontype = :familypensiontype"),
		@NamedQuery(name = "PsnViewPensioncalculation.findByServiceyears", query = "SELECT p FROM PsnViewPensioncalculation p WHERE p.serviceyears = :serviceyears"),
		@NamedQuery(name = "PsnViewPensioncalculation.findByServicemonths", query = "SELECT p FROM PsnViewPensioncalculation p WHERE p.servicemonths = :servicemonths"),
		@NamedQuery(name = "PsnViewPensioncalculation.findByServicedays", query = "SELECT p FROM PsnViewPensioncalculation p WHERE p.servicedays = :servicedays"),
		@NamedQuery(name = "PsnViewPensioncalculation.findByOthereligibleserviceyears", query = "SELECT p FROM PsnViewPensioncalculation p WHERE p.othereligibleserviceyears = :othereligibleserviceyears"),
		@NamedQuery(name = "PsnViewPensioncalculation.findByOthereligibleservicemonths", query = "SELECT p FROM PsnViewPensioncalculation p WHERE p.othereligibleservicemonths = :othereligibleservicemonths"),
		@NamedQuery(name = "PsnViewPensioncalculation.findByOthereligibleservicedays", query = "SELECT p FROM PsnViewPensioncalculation p WHERE p.othereligibleservicedays = :othereligibleservicedays"),
		@NamedQuery(name = "PsnViewPensioncalculation.findByNoneligibleserviceyears", query = "SELECT p FROM PsnViewPensioncalculation p WHERE p.noneligibleserviceyears = :noneligibleserviceyears"),
		@NamedQuery(name = "PsnViewPensioncalculation.findByNoneligibleservicemonths", query = "SELECT p FROM PsnViewPensioncalculation p WHERE p.noneligibleservicemonths = :noneligibleservicemonths"),
		@NamedQuery(name = "PsnViewPensioncalculation.findByNoneligibleservicedays", query = "SELECT p FROM PsnViewPensioncalculation p WHERE p.noneligibleservicedays = :noneligibleservicedays"),
		@NamedQuery(name = "PsnViewPensioncalculation.findByTypeofpension", query = "SELECT p FROM PsnViewPensioncalculation p WHERE p.typeofpension = :typeofpension"),
		@NamedQuery(name = "PsnViewPensioncalculation.findByLastpaydrawn", query = "SELECT p FROM PsnViewPensioncalculation p WHERE p.lastpaydrawn = :lastpaydrawn"),
		@NamedQuery(name = "PsnViewPensioncalculation.findByAvgoflasttenpay", query = "SELECT p FROM PsnViewPensioncalculation p WHERE p.avgoflasttenpay = :avgoflasttenpay"),
		@NamedQuery(name = "PsnViewPensioncalculation.findByHbadue", query = "SELECT p FROM PsnViewPensioncalculation p WHERE p.hbadue = :hbadue"),
		@NamedQuery(name = "PsnViewPensioncalculation.findByVehicaldue", query = "SELECT p FROM PsnViewPensioncalculation p WHERE p.vehicaldue = :vehicaldue"),
		@NamedQuery(name = "PsnViewPensioncalculation.findByOtheradvancedue", query = "SELECT p FROM PsnViewPensioncalculation p WHERE p.otheradvancedue = :otheradvancedue"),
		@NamedQuery(name = "PsnViewPensioncalculation.findByHouserentdue", query = "SELECT p FROM PsnViewPensioncalculation p WHERE p.houserentdue = :houserentdue"),
		@NamedQuery(name = "PsnViewPensioncalculation.findByAuditdue", query = "SELECT p FROM PsnViewPensioncalculation p WHERE p.auditdue = :auditdue"),
		@NamedQuery(name = "PsnViewPensioncalculation.findByOtherdue", query = "SELECT p FROM PsnViewPensioncalculation p WHERE p.otherdue = :otherdue"),
		@NamedQuery(name = "PsnViewPensioncalculation.findByDeptdue", query = "SELECT p FROM PsnViewPensioncalculation p WHERE p.deptdue = :deptdue"),
		@NamedQuery(name = "PsnViewPensioncalculation.findByPensionissuedate", query = "SELECT p FROM PsnViewPensioncalculation p WHERE p.pensionissuedate = :pensionissuedate"),
		@NamedQuery(name = "PsnViewPensioncalculation.findByDateofeffect", query = "SELECT p FROM PsnViewPensioncalculation p WHERE p.dateofeffect = :dateofeffect"),
		@NamedQuery(name = "PsnViewPensioncalculation.findByNormalRate", query = "SELECT p FROM PsnViewPensioncalculation p WHERE p.normalRate = :normalRate"),
		@NamedQuery(name = "PsnViewPensioncalculation.findByBasicpension", query = "SELECT p FROM PsnViewPensioncalculation p WHERE p.basicpension = :basicpension"),
		@NamedQuery(name = "PsnViewPensioncalculation.findByGratuityamount", query = "SELECT p FROM PsnViewPensioncalculation p WHERE p.gratuityamount = :gratuityamount"),
		@NamedQuery(name = "PsnViewPensioncalculation.findByFamilypensionbefore", query = "SELECT p FROM PsnViewPensioncalculation p WHERE p.familypensionbefore = :familypensionbefore"),
		@NamedQuery(name = "PsnViewPensioncalculation.findByFamilypensionafter", query = "SELECT p FROM PsnViewPensioncalculation p WHERE p.familypensionafter = :familypensionafter"),
		@NamedQuery(name = "PsnViewPensioncalculation.findByFamilypensionbreakdate", query = "SELECT p FROM PsnViewPensioncalculation p WHERE p.familypensionbreakdate = :familypensionbreakdate"),
		@NamedQuery(name = "PsnViewPensioncalculation.findByDeduction1", query = "SELECT p FROM PsnViewPensioncalculation p WHERE p.deduction1 = :deduction1"),
		@NamedQuery(name = "PsnViewPensioncalculation.findByDeduction2", query = "SELECT p FROM PsnViewPensioncalculation p WHERE p.deduction2 = :deduction2"),
		@NamedQuery(name = "PsnViewPensioncalculation.findByOtherpayable", query = "SELECT p FROM PsnViewPensioncalculation p WHERE p.otherpayable = :otherpayable"),
		@NamedQuery(name = "PsnViewPensioncalculation.findByCommutationdedamount", query = "SELECT p FROM PsnViewPensioncalculation p WHERE p.commutationdedamount = :commutationdedamount"),
		@NamedQuery(name = "PsnViewPensioncalculation.findByIsdaapplicable", query = "SELECT p FROM PsnViewPensioncalculation p WHERE p.isdaapplicable = :isdaapplicable"),
		@NamedQuery(name = "PsnViewPensioncalculation.findByIncomtax", query = "SELECT p FROM PsnViewPensioncalculation p WHERE p.incomtax = :incomtax"),
		@NamedQuery(name = "PsnViewPensioncalculation.findByIr1", query = "SELECT p FROM PsnViewPensioncalculation p WHERE p.ir1 = :ir1"),
		@NamedQuery(name = "PsnViewPensioncalculation.findByIr2", query = "SELECT p FROM PsnViewPensioncalculation p WHERE p.ir2 = :ir2"),
		@NamedQuery(name = "PsnViewPensioncalculation.findByTypeofgratuity", query = "SELECT p FROM PsnViewPensioncalculation p WHERE p.typeofgratuity = :typeofgratuity") })
public class PsnViewPensioncalculation implements Serializable {
	private static final long serialVersionUID = 1L;
	@Basic(optional = false)
	@Column(name = "PSN_EMPLOYEEPENSION_MASTERID")
	private long psnEmployeepensionMasterid;
	@Column(name = "EMPLOYEENAME")
	private String employeename;
	@Basic(optional = false)
	@Column(name = "LASTDESIGNATION")
	private String lastdesignation;
	@Column(name = "DATEOFBIRTH")
	private String dateofbirth;
	@Column(name = "DATEOFRETIREMENT")
	private String dateofretirement;
	@Column(name = "JOININGDATE")
	private String joiningdate;
	@Column(name = "DATEOFDEATH")
	private String dateofdeath;
	@Basic(optional = false)
	@Column(name = "ISDIRECTENTRY")
	private Character isdirectentry;
	@Basic(optional = false)
	@Column(name = "RM_OFFICEID")
	private int rmOfficeid;
	@Column(name = "FP_NAME")
	private String fpName;
	@Column(name = "FAMILYPENSIONTYPE")
	private Character familypensiontype;
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
	@Column(name = "TYPEOFPENSION")
	private String typeofpension;
	@Column(name = "LASTPAYDRAWN")
	private Integer lastpaydrawn;
	@Column(name = "AVGOFLASTTENPAY")
	private Integer avgoflasttenpay;
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
	@Column(name = "PENSIONISSUEDATE")
	private String pensionissuedate;
	@Column(name = "DATEOFEFFECT")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateofeffect;
	@Column(name = "NORMAL_RATE")
	private Integer normalRate;
	@Column(name = "BASICPENSION")
	private Integer basicpension;
	// @Max(value=?) @Min(value=?)//if you know range of your decimal fields
	// consider using these annotations to enforce field validation
	@Column(name = "GRATUITYAMOUNT")
	private BigDecimal gratuityamount;
	@Column(name = "FAMILYPENSIONBEFORE")
	private Integer familypensionbefore;
	@Column(name = "FAMILYPENSIONAFTER")
	private Integer familypensionafter;
	@Column(name = "FAMILYPENSIONBREAKDATE")
	private String familypensionbreakdate;
	@Column(name = "DEDUCTION1")
	private Integer deduction1;
	@Column(name = "DEDUCTION2")
	private Integer deduction2;
	@Column(name = "OTHERPAYABLE")
	private Integer otherpayable;
	@Column(name = "COMMUTATIONDEDAMOUNT")
	private Integer commutationdedamount;
	@Column(name = "ISDAAPPLICABLE")
	private Character isdaapplicable;
	@Column(name = "INCOMTAX")
	private Integer incomtax;
	@Column(name = "IR1")
	private Integer ir1;
	@Column(name = "IR2")
	private Integer ir2;
	@Column(name = "TYPEOFGRATUITY")
	private String typeofgratuity;

	public PsnViewPensioncalculation() {
	}

	public long getPsnEmployeepensionMasterid() {
		return psnEmployeepensionMasterid;
	}

	public void setPsnEmployeepensionMasterid(long psnEmployeepensionMasterid) {
		this.psnEmployeepensionMasterid = psnEmployeepensionMasterid;
	}

	public String getEmployeename() {
		return employeename;
	}

	public void setEmployeename(String employeename) {
		this.employeename = employeename;
	}

	public String getLastdesignation() {
		return lastdesignation;
	}

	public void setLastdesignation(String lastdesignation) {
		this.lastdesignation = lastdesignation;
	}

	public String getDateofbirth() {
		return dateofbirth;
	}

	public void setDateofbirth(String dateofbirth) {
		this.dateofbirth = dateofbirth;
	}

	public String getDateofretirement() {
		return dateofretirement;
	}

	public void setDateofretirement(String dateofretirement) {
		this.dateofretirement = dateofretirement;
	}

	public String getJoiningdate() {
		return joiningdate;
	}

	public void setJoiningdate(String joiningdate) {
		this.joiningdate = joiningdate;
	}

	public String getDateofdeath() {
		return dateofdeath;
	}

	public void setDateofdeath(String dateofdeath) {
		this.dateofdeath = dateofdeath;
	}

	public Character getIsdirectentry() {
		return isdirectentry;
	}

	public void setIsdirectentry(Character isdirectentry) {
		this.isdirectentry = isdirectentry;
	}

	public int getRmOfficeid() {
		return rmOfficeid;
	}

	public void setRmOfficeid(int rmOfficeid) {
		this.rmOfficeid = rmOfficeid;
	}

	public String getFpName() {
		return fpName;
	}

	public void setFpName(String fpName) {
		this.fpName = fpName;
	}

	public Character getFamilypensiontype() {
		return familypensiontype;
	}

	public void setFamilypensiontype(Character familypensiontype) {
		this.familypensiontype = familypensiontype;
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

	public String getPensionissuedate() {
		return pensionissuedate;
	}

	public void setPensionissuedate(String pensionissuedate) {
		this.pensionissuedate = pensionissuedate;
	}

	public Date getDateofeffect() {
		return dateofeffect;
	}

	public void setDateofeffect(Date dateofeffect) {
		this.dateofeffect = dateofeffect;
	}

	public Integer getNormalRate() {
		return normalRate;
	}

	public void setNormalRate(Integer normalRate) {
		this.normalRate = normalRate;
	}

	public Integer getBasicpension() {
		return basicpension;
	}

	public void setBasicpension(Integer basicpension) {
		this.basicpension = basicpension;
	}

	public BigDecimal getGratuityamount() {
		return gratuityamount;
	}

	public void setGratuityamount(BigDecimal gratuityamount) {
		this.gratuityamount = gratuityamount;
	}

	public Integer getFamilypensionbefore() {
		return familypensionbefore;
	}

	public void setFamilypensionbefore(Integer familypensionbefore) {
		this.familypensionbefore = familypensionbefore;
	}

	public Integer getFamilypensionafter() {
		return familypensionafter;
	}

	public void setFamilypensionafter(Integer familypensionafter) {
		this.familypensionafter = familypensionafter;
	}

	public String getFamilypensionbreakdate() {
		return familypensionbreakdate;
	}

	public void setFamilypensionbreakdate(String familypensionbreakdate) {
		this.familypensionbreakdate = familypensionbreakdate;
	}

	public Integer getDeduction1() {
		return deduction1;
	}

	public void setDeduction1(Integer deduction1) {
		this.deduction1 = deduction1;
	}

	public Integer getDeduction2() {
		return deduction2;
	}

	public void setDeduction2(Integer deduction2) {
		this.deduction2 = deduction2;
	}

	public Integer getOtherpayable() {
		return otherpayable;
	}

	public void setOtherpayable(Integer otherpayable) {
		this.otherpayable = otherpayable;
	}

	public Integer getCommutationdedamount() {
		return commutationdedamount;
	}

	public void setCommutationdedamount(Integer commutationdedamount) {
		this.commutationdedamount = commutationdedamount;
	}

	public Character getIsdaapplicable() {
		return isdaapplicable;
	}

	public void setIsdaapplicable(Character isdaapplicable) {
		this.isdaapplicable = isdaapplicable;
	}

	public Integer getIncomtax() {
		return incomtax;
	}

	public void setIncomtax(Integer incomtax) {
		this.incomtax = incomtax;
	}

	public Integer getIr1() {
		return ir1;
	}

	public void setIr1(Integer ir1) {
		this.ir1 = ir1;
	}

	public Integer getIr2() {
		return ir2;
	}

	public void setIr2(Integer ir2) {
		this.ir2 = ir2;
	}

	public String getTypeofgratuity() {
		return typeofgratuity;
	}

	public void setTypeofgratuity(String typeofgratuity) {
		this.typeofgratuity = typeofgratuity;
	}

}
