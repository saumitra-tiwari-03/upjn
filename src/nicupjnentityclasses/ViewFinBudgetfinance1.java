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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Saumitra-PC
 */
@Entity
@Table(name = "VIEW_FIN_BUDGETFINANCE1")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "ViewFinBudgetfinance1.findAll", query = "SELECT v FROM ViewFinBudgetfinance1 v"),
		@NamedQuery(name = "ViewFinBudgetfinance1.findByFinBudgetfinanceid1", query = "SELECT v FROM ViewFinBudgetfinance1 v WHERE v.finBudgetfinanceid1 = :finBudgetfinanceid1"),
		@NamedQuery(name = "ViewFinBudgetfinance1.findByFinProgramid", query = "SELECT v FROM ViewFinBudgetfinance1 v WHERE v.finProgramid = :finProgramid"),
		@NamedQuery(name = "ViewFinBudgetfinance1.findByProgrammeName", query = "SELECT v FROM ViewFinBudgetfinance1 v WHERE v.programmeName = :programmeName"),
		@NamedQuery(name = "ViewFinBudgetfinance1.findByNewCodes", query = "SELECT v FROM ViewFinBudgetfinance1 v WHERE v.newCodes = :newCodes"),
		@NamedQuery(name = "ViewFinBudgetfinance1.findByExistingCode", query = "SELECT v FROM ViewFinBudgetfinance1 v WHERE v.existingCode = :existingCode"),
		@NamedQuery(name = "ViewFinBudgetfinance1.findByOpeningbalance", query = "SELECT v FROM ViewFinBudgetfinance1 v WHERE v.openingbalance = :openingbalance"),
		@NamedQuery(name = "ViewFinBudgetfinance1.findByAnticipatedreceipts", query = "SELECT v FROM ViewFinBudgetfinance1 v WHERE v.anticipatedreceipts = :anticipatedreceipts"),
		@NamedQuery(name = "ViewFinBudgetfinance1.findByFromhq", query = "SELECT v FROM ViewFinBudgetfinance1 v WHERE v.fromhq = :fromhq"),
		@NamedQuery(name = "ViewFinBudgetfinance1.findByDirect", query = "SELECT v FROM ViewFinBudgetfinance1 v WHERE v.direct = :direct"),
		@NamedQuery(name = "ViewFinBudgetfinance1.findByTotalavailability", query = "SELECT v FROM ViewFinBudgetfinance1 v WHERE v.totalavailability = :totalavailability"),
		@NamedQuery(name = "ViewFinBudgetfinance1.findByProgramwork", query = "SELECT v FROM ViewFinBudgetfinance1 v WHERE v.programwork = :programwork"),
		@NamedQuery(name = "ViewFinBudgetfinance1.findByCentage", query = "SELECT v FROM ViewFinBudgetfinance1 v WHERE v.centage = :centage"),
		@NamedQuery(name = "ViewFinBudgetfinance1.findByTotal", query = "SELECT v FROM ViewFinBudgetfinance1 v WHERE v.total = :total"),
		@NamedQuery(name = "ViewFinBudgetfinance1.findByWce", query = "SELECT v FROM ViewFinBudgetfinance1 v WHERE v.wce = :wce"),
		@NamedQuery(name = "ViewFinBudgetfinance1.findByFinanceyear", query = "SELECT v FROM ViewFinBudgetfinance1 v WHERE v.financeyear = :financeyear"),
		@NamedQuery(name = "ViewFinBudgetfinance1.findByFinancemonth", query = "SELECT v FROM ViewFinBudgetfinance1 v WHERE v.financemonth = :financemonth"),
		@NamedQuery(name = "ViewFinBudgetfinance1.findByMonthname", query = "SELECT v FROM ViewFinBudgetfinance1 v WHERE v.monthname = :monthname"),
		@NamedQuery(name = "ViewFinBudgetfinance1.findByPlace", query = "SELECT v FROM ViewFinBudgetfinance1 v WHERE v.place = :place"),
		@NamedQuery(name = "ViewFinBudgetfinance1.findByPpPlacemasterid", query = "SELECT v FROM ViewFinBudgetfinance1 v WHERE v.ppPlacemasterid = :ppPlacemasterid"),
		@NamedQuery(name = "ViewFinBudgetfinance1.findByRmOfficeid", query = "SELECT v FROM ViewFinBudgetfinance1 v WHERE v.rmOfficeid = :rmOfficeid"),
		@NamedQuery(name = "ViewFinBudgetfinance1.findByOfficename", query = "SELECT v FROM ViewFinBudgetfinance1 v WHERE v.officename = :officename"),
		@NamedQuery(name = "ViewFinBudgetfinance1.findByZoneCode", query = "SELECT v FROM ViewFinBudgetfinance1 v WHERE v.zoneCode = :zoneCode"),
		@NamedQuery(name = "ViewFinBudgetfinance1.findByZoneDesc", query = "SELECT v FROM ViewFinBudgetfinance1 v WHERE v.zoneDesc = :zoneDesc"),
		@NamedQuery(name = "ViewFinBudgetfinance1.findByTransfertoother", query = "SELECT v FROM ViewFinBudgetfinance1 v WHERE v.transfertoother = :transfertoother"),
		@NamedQuery(name = "ViewFinBudgetfinance1.findByTransherredhqfromwc", query = "SELECT v FROM ViewFinBudgetfinance1 v WHERE v.transherredhqfromwc = :transherredhqfromwc"),
		@NamedQuery(name = "ViewFinBudgetfinance1.findByHqfromcentage", query = "SELECT v FROM ViewFinBudgetfinance1 v WHERE v.hqfromcentage = :hqfromcentage"),
		@NamedQuery(name = "ViewFinBudgetfinance1.findByClosingbalance", query = "SELECT v FROM ViewFinBudgetfinance1 v WHERE v.closingbalance = :closingbalance"),
		@NamedQuery(name = "ViewFinBudgetfinance1.findByIslocked", query = "SELECT v FROM ViewFinBudgetfinance1 v WHERE v.islocked = :islocked"),
		@NamedQuery(name = "ViewFinBudgetfinance1.findByProgramwotkmat", query = "SELECT v FROM ViewFinBudgetfinance1 v WHERE v.programwotkmat = :programwotkmat") })
public class ViewFinBudgetfinance1 implements Serializable {
	private static final long serialVersionUID = 1L;
	@Basic(optional = false)
	@Column(name = "FIN_BUDGETFINANCEID1")
	private long finBudgetfinanceid1;
	@Basic(optional = false)
	@Column(name = "FIN_PROGRAMID")
	private long finProgramid;
	@Column(name = "PROGRAMME_NAME")
	private String programmeName;
	@Column(name = "NEW_CODES")
	private String newCodes;
	@Column(name = "EXISTING_CODE")
	private String existingCode;
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
	@Column(name = "WCE")
	private String wce;
	@Column(name = "FINANCEYEAR")
	private Long financeyear;
	@Column(name = "FINANCEMONTH")
	private String financemonth;
	@Basic(optional = false)
	@Column(name = "MONTHNAME")
	private String monthname;
	@Column(name = "PLACE")
	private String place;
	@Basic(optional = false)
	@Column(name = "PP_PLACEMASTERID")
	private long ppPlacemasterid;
	@Column(name = "RM_OFFICEID")
	private String rmOfficeid;
	@Basic(optional = false)
	@Column(name = "OFFICENAME")
	private String officename;
	@Column(name = "ZONE_CODE")
	private String zoneCode;
	@Column(name = "ZONE_DESC")
	private String zoneDesc;
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

	public ViewFinBudgetfinance1() {
	}

	public long getFinBudgetfinanceid1() {
		return finBudgetfinanceid1;
	}

	public void setFinBudgetfinanceid1(long finBudgetfinanceid1) {
		this.finBudgetfinanceid1 = finBudgetfinanceid1;
	}

	public long getFinProgramid() {
		return finProgramid;
	}

	public void setFinProgramid(long finProgramid) {
		this.finProgramid = finProgramid;
	}

	public String getProgrammeName() {
		return programmeName;
	}

	public void setProgrammeName(String programmeName) {
		this.programmeName = programmeName;
	}

	public String getNewCodes() {
		return newCodes;
	}

	public void setNewCodes(String newCodes) {
		this.newCodes = newCodes;
	}

	public String getExistingCode() {
		return existingCode;
	}

	public void setExistingCode(String existingCode) {
		this.existingCode = existingCode;
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

	public String getWce() {
		return wce;
	}

	public void setWce(String wce) {
		this.wce = wce;
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

	public String getMonthname() {
		return monthname;
	}

	public void setMonthname(String monthname) {
		this.monthname = monthname;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public long getPpPlacemasterid() {
		return ppPlacemasterid;
	}

	public void setPpPlacemasterid(long ppPlacemasterid) {
		this.ppPlacemasterid = ppPlacemasterid;
	}

	public String getRmOfficeid() {
		return rmOfficeid;
	}

	public void setRmOfficeid(String rmOfficeid) {
		this.rmOfficeid = rmOfficeid;
	}

	public String getOfficename() {
		return officename;
	}

	public void setOfficename(String officename) {
		this.officename = officename;
	}

	public String getZoneCode() {
		return zoneCode;
	}

	public void setZoneCode(String zoneCode) {
		this.zoneCode = zoneCode;
	}

	public String getZoneDesc() {
		return zoneDesc;
	}

	public void setZoneDesc(String zoneDesc) {
		this.zoneDesc = zoneDesc;
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

}
