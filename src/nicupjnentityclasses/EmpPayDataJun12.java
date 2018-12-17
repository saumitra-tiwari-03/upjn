/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nicupjnentityclasses;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;

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
@Table(name = "EMP_PAY_DATA_JUN12")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "EmpPayDataJun12.findAll", query = "SELECT e FROM EmpPayDataJun12 e"),
		@NamedQuery(name = "EmpPayDataJun12.findById", query = "SELECT e FROM EmpPayDataJun12 e WHERE e.id = :id"),
		@NamedQuery(name = "EmpPayDataJun12.findByPcod", query = "SELECT e FROM EmpPayDataJun12 e WHERE e.pcod = :pcod"),
		@NamedQuery(name = "EmpPayDataJun12.findByEcod", query = "SELECT e FROM EmpPayDataJun12 e WHERE e.ecod = :ecod"),
		@NamedQuery(name = "EmpPayDataJun12.findByTtl", query = "SELECT e FROM EmpPayDataJun12 e WHERE e.ttl = :ttl"),
		@NamedQuery(name = "EmpPayDataJun12.findByEnam", query = "SELECT e FROM EmpPayDataJun12 e WHERE e.enam = :enam"),
		@NamedQuery(name = "EmpPayDataJun12.findByCdsg", query = "SELECT e FROM EmpPayDataJun12 e WHERE e.cdsg = :cdsg"),
		@NamedQuery(name = "EmpPayDataJun12.findByCdpt", query = "SELECT e FROM EmpPayDataJun12 e WHERE e.cdpt = :cdpt"),
		@NamedQuery(name = "EmpPayDataJun12.findByCat", query = "SELECT e FROM EmpPayDataJun12 e WHERE e.cat = :cat"),
		@NamedQuery(name = "EmpPayDataJun12.findByIncdts", query = "SELECT e FROM EmpPayDataJun12 e WHERE e.incdts = :incdts"),
		@NamedQuery(name = "EmpPayDataJun12.findByReg", query = "SELECT e FROM EmpPayDataJun12 e WHERE e.reg = :reg"),
		@NamedQuery(name = "EmpPayDataJun12.findByGpfno", query = "SELECT e FROM EmpPayDataJun12 e WHERE e.gpfno = :gpfno"),
		@NamedQuery(name = "EmpPayDataJun12.findByBnkno", query = "SELECT e FROM EmpPayDataJun12 e WHERE e.bnkno = :bnkno"),
		@NamedQuery(name = "EmpPayDataJun12.findByBnknew", query = "SELECT e FROM EmpPayDataJun12 e WHERE e.bnknew = :bnknew"),
		@NamedQuery(name = "EmpPayDataJun12.findByMnth", query = "SELECT e FROM EmpPayDataJun12 e WHERE e.mnth = :mnth"),
		@NamedQuery(name = "EmpPayDataJun12.findByWdays", query = "SELECT e FROM EmpPayDataJun12 e WHERE e.wdays = :wdays"),
		@NamedQuery(name = "EmpPayDataJun12.findByBasic", query = "SELECT e FROM EmpPayDataJun12 e WHERE e.basic = :basic"),
		@NamedQuery(name = "EmpPayDataJun12.findBySpl", query = "SELECT e FROM EmpPayDataJun12 e WHERE e.spl = :spl"),
		@NamedQuery(name = "EmpPayDataJun12.findByPrsnl", query = "SELECT e FROM EmpPayDataJun12 e WHERE e.prsnl = :prsnl"),
		@NamedQuery(name = "EmpPayDataJun12.findByPgall", query = "SELECT e FROM EmpPayDataJun12 e WHERE e.pgall = :pgall"),
		@NamedQuery(name = "EmpPayDataJun12.findByBilng", query = "SELECT e FROM EmpPayDataJun12 e WHERE e.bilng = :bilng"),
		@NamedQuery(name = "EmpPayDataJun12.findByDa", query = "SELECT e FROM EmpPayDataJun12 e WHERE e.da = :da"),
		@NamedQuery(name = "EmpPayDataJun12.findByAdhda", query = "SELECT e FROM EmpPayDataJun12 e WHERE e.adhda = :adhda"),
		@NamedQuery(name = "EmpPayDataJun12.findByCca", query = "SELECT e FROM EmpPayDataJun12 e WHERE e.cca = :cca"),
		@NamedQuery(name = "EmpPayDataJun12.findByHra", query = "SELECT e FROM EmpPayDataJun12 e WHERE e.hra = :hra"),
		@NamedQuery(name = "EmpPayDataJun12.findByMa", query = "SELECT e FROM EmpPayDataJun12 e WHERE e.ma = :ma"),
		@NamedQuery(name = "EmpPayDataJun12.findByIr", query = "SELECT e FROM EmpPayDataJun12 e WHERE e.ir = :ir"),
		@NamedQuery(name = "EmpPayDataJun12.findByWa", query = "SELECT e FROM EmpPayDataJun12 e WHERE e.wa = :wa"),
		@NamedQuery(name = "EmpPayDataJun12.findByCdepu", query = "SELECT e FROM EmpPayDataJun12 e WHERE e.cdepu = :cdepu"),
		@NamedQuery(name = "EmpPayDataJun12.findByDepu", query = "SELECT e FROM EmpPayDataJun12 e WHERE e.depu = :depu"),
		@NamedQuery(name = "EmpPayDataJun12.findByEar1", query = "SELECT e FROM EmpPayDataJun12 e WHERE e.ear1 = :ear1"),
		@NamedQuery(name = "EmpPayDataJun12.findByGpfrt", query = "SELECT e FROM EmpPayDataJun12 e WHERE e.gpfrt = :gpfrt"),
		@NamedQuery(name = "EmpPayDataJun12.findByGpfcnt1", query = "SELECT e FROM EmpPayDataJun12 e WHERE e.gpfcnt1 = :gpfcnt1"),
		@NamedQuery(name = "EmpPayDataJun12.findByGpfcnt2", query = "SELECT e FROM EmpPayDataJun12 e WHERE e.gpfcnt2 = :gpfcnt2"),
		@NamedQuery(name = "EmpPayDataJun12.findByGi", query = "SELECT e FROM EmpPayDataJun12 e WHERE e.gi = :gi"),
		@NamedQuery(name = "EmpPayDataJun12.findByItax", query = "SELECT e FROM EmpPayDataJun12 e WHERE e.itax = :itax"),
		@NamedQuery(name = "EmpPayDataJun12.findByItax2", query = "SELECT e FROM EmpPayDataJun12 e WHERE e.itax2 = :itax2"),
		@NamedQuery(name = "EmpPayDataJun12.findByGpfr", query = "SELECT e FROM EmpPayDataJun12 e WHERE e.gpfr = :gpfr"),
		@NamedQuery(name = "EmpPayDataJun12.findByHrnt", query = "SELECT e FROM EmpPayDataJun12 e WHERE e.hrnt = :hrnt"),
		@NamedQuery(name = "EmpPayDataJun12.findByHba1", query = "SELECT e FROM EmpPayDataJun12 e WHERE e.hba1 = :hba1"),
		@NamedQuery(name = "EmpPayDataJun12.findByHba2", query = "SELECT e FROM EmpPayDataJun12 e WHERE e.hba2 = :hba2"),
		@NamedQuery(name = "EmpPayDataJun12.findByHrep", query = "SELECT e FROM EmpPayDataJun12 e WHERE e.hrep = :hrep"),
		@NamedQuery(name = "EmpPayDataJun12.findByConr1", query = "SELECT e FROM EmpPayDataJun12 e WHERE e.conr1 = :conr1"),
		@NamedQuery(name = "EmpPayDataJun12.findByConr2", query = "SELECT e FROM EmpPayDataJun12 e WHERE e.conr2 = :conr2"),
		@NamedQuery(name = "EmpPayDataJun12.findByConr3", query = "SELECT e FROM EmpPayDataJun12 e WHERE e.conr3 = :conr3"),
		@NamedQuery(name = "EmpPayDataJun12.findByConr4", query = "SELECT e FROM EmpPayDataJun12 e WHERE e.conr4 = :conr4"),
		@NamedQuery(name = "EmpPayDataJun12.findBySocd", query = "SELECT e FROM EmpPayDataJun12 e WHERE e.socd = :socd"),
		@NamedQuery(name = "EmpPayDataJun12.findByRec1", query = "SELECT e FROM EmpPayDataJun12 e WHERE e.rec1 = :rec1"),
		@NamedQuery(name = "EmpPayDataJun12.findByRec2", query = "SELECT e FROM EmpPayDataJun12 e WHERE e.rec2 = :rec2"),
		@NamedQuery(name = "EmpPayDataJun12.findByRec3", query = "SELECT e FROM EmpPayDataJun12 e WHERE e.rec3 = :rec3"),
		@NamedQuery(name = "EmpPayDataJun12.findByRec4", query = "SELECT e FROM EmpPayDataJun12 e WHERE e.rec4 = :rec4"),
		@NamedQuery(name = "EmpPayDataJun12.findByRec5", query = "SELECT e FROM EmpPayDataJun12 e WHERE e.rec5 = :rec5"),
		@NamedQuery(name = "EmpPayDataJun12.findByRec6", query = "SELECT e FROM EmpPayDataJun12 e WHERE e.rec6 = :rec6"),
		@NamedQuery(name = "EmpPayDataJun12.findByGross", query = "SELECT e FROM EmpPayDataJun12 e WHERE e.gross = :gross"),
		@NamedQuery(name = "EmpPayDataJun12.findByDed", query = "SELECT e FROM EmpPayDataJun12 e WHERE e.ded = :ded"),
		@NamedQuery(name = "EmpPayDataJun12.findByNet", query = "SELECT e FROM EmpPayDataJun12 e WHERE e.net = :net"),
		@NamedQuery(name = "EmpPayDataJun12.findByAddt", query = "SELECT e FROM EmpPayDataJun12 e WHERE e.addt = :addt"),
		@NamedQuery(name = "EmpPayDataJun12.findByCalc", query = "SELECT e FROM EmpPayDataJun12 e WHERE e.calc = :calc"),
		@NamedQuery(name = "EmpPayDataJun12.findByPaid", query = "SELECT e FROM EmpPayDataJun12 e WHERE e.paid = :paid"),
		@NamedQuery(name = "EmpPayDataJun12.findByLdg", query = "SELECT e FROM EmpPayDataJun12 e WHERE e.ldg = :ldg"),
		@NamedQuery(name = "EmpPayDataJun12.findByLdn", query = "SELECT e FROM EmpPayDataJun12 e WHERE e.ldn = :ldn"),
		@NamedQuery(name = "EmpPayDataJun12.findByFlg", query = "SELECT e FROM EmpPayDataJun12 e WHERE e.flg = :flg"),
		@NamedQuery(name = "EmpPayDataJun12.findByCnt", query = "SELECT e FROM EmpPayDataJun12 e WHERE e.cnt = :cnt"),
		@NamedQuery(name = "EmpPayDataJun12.findByBillno", query = "SELECT e FROM EmpPayDataJun12 e WHERE e.billno = :billno"),
		@NamedQuery(name = "EmpPayDataJun12.findByClerk", query = "SELECT e FROM EmpPayDataJun12 e WHERE e.clerk = :clerk"),
		@NamedQuery(name = "EmpPayDataJun12.findByPan", query = "SELECT e FROM EmpPayDataJun12 e WHERE e.pan = :pan"),
		@NamedQuery(name = "EmpPayDataJun12.findByOecod", query = "SELECT e FROM EmpPayDataJun12 e WHERE e.oecod = :oecod"),
		@NamedQuery(name = "EmpPayDataJun12.findByHradue", query = "SELECT e FROM EmpPayDataJun12 e WHERE e.hradue = :hradue"),
		@NamedQuery(name = "EmpPayDataJun12.findByPbcd", query = "SELECT e FROM EmpPayDataJun12 e WHERE e.pbcd = :pbcd"),
		@NamedQuery(name = "EmpPayDataJun12.findByGrdpay", query = "SELECT e FROM EmpPayDataJun12 e WHERE e.grdpay = :grdpay"),
		@NamedQuery(name = "EmpPayDataJun12.findByNcod", query = "SELECT e FROM EmpPayDataJun12 e WHERE e.ncod = :ncod"),
		@NamedQuery(name = "EmpPayDataJun12.findByTe", query = "SELECT e FROM EmpPayDataJun12 e WHERE e.te = :te"),
		@NamedQuery(name = "EmpPayDataJun12.findByBlnk", query = "SELECT e FROM EmpPayDataJun12 e WHERE e.blnk = :blnk"),
		@NamedQuery(name = "EmpPayDataJun12.findByPpEmployeemasterid", query = "SELECT e FROM EmpPayDataJun12 e WHERE e.ppEmployeemasterid = :ppEmployeemasterid") })
public class EmpPayDataJun12 implements Serializable {
	private static final long serialVersionUID = 1L;
	// @Max(value=?) @Min(value=?)//if you know range of your decimal fields
	// consider using these annotations to enforce field validation
	@Id
	@Basic(optional = false)
	@Column(name = "ID")
	private BigDecimal id;
	@Column(name = "PCOD")
	private String pcod;
	@Column(name = "ECOD")
	private BigInteger ecod;
	@Column(name = "TTL")
	private String ttl;
	@Column(name = "ENAM")
	private String enam;
	@Column(name = "CDSG")
	private BigInteger cdsg;
	@Column(name = "CDPT")
	private BigInteger cdpt;
	@Column(name = "CAT")
	private BigInteger cat;
	@Column(name = "INCDTS")
	private String incdts;
	@Column(name = "REG")
	private BigInteger reg;
	@Column(name = "GPFNO")
	private String gpfno;
	@Column(name = "BNKNO")
	private String bnkno;
	@Column(name = "BNKNEW")
	private BigInteger bnknew;
	@Column(name = "MNTH")
	private BigInteger mnth;
	@Column(name = "WDAYS")
	private String wdays;
	@Column(name = "BASIC")
	private BigInteger basic;
	@Column(name = "SPL")
	private String spl;
	@Column(name = "PRSNL")
	private String prsnl;
	@Column(name = "PGALL")
	private String pgall;
	@Column(name = "BILNG")
	private BigInteger bilng;
	@Column(name = "DA")
	private BigInteger da;
	@Column(name = "ADHDA")
	private BigInteger adhda;
	@Column(name = "CCA")
	private BigInteger cca;
	@Column(name = "HRA")
	private BigInteger hra;
	@Column(name = "MA")
	private BigInteger ma;
	@Column(name = "IR")
	private BigInteger ir;
	@Column(name = "WA")
	private String wa;
	@Column(name = "CDEPU")
	private String cdepu;
	@Column(name = "DEPU")
	private BigInteger depu;
	@Column(name = "EAR1")
	private String ear1;
	@Column(name = "GPFRT")
	private String gpfrt;
	@Column(name = "GPFCNT1")
	private BigInteger gpfcnt1;
	@Column(name = "GPFCNT2")
	private BigInteger gpfcnt2;
	@Column(name = "GI")
	private BigInteger gi;
	@Column(name = "ITAX")
	private String itax;
	@Column(name = "ITAX2")
	private BigInteger itax2;
	@Column(name = "GPFR")
	private String gpfr;
	@Column(name = "HRNT")
	private String hrnt;
	@Column(name = "HBA1")
	private String hba1;
	@Column(name = "HBA2")
	private String hba2;
	@Column(name = "HREP")
	private String hrep;
	@Column(name = "CONR1")
	private String conr1;
	@Column(name = "CONR2")
	private String conr2;
	@Column(name = "CONR3")
	private String conr3;
	@Column(name = "CONR4")
	private String conr4;
	@Column(name = "SOCD")
	private String socd;
	@Column(name = "REC1")
	private String rec1;
	@Column(name = "REC2")
	private String rec2;
	@Column(name = "REC3")
	private BigInteger rec3;
	@Column(name = "REC4")
	private String rec4;
	@Column(name = "REC5")
	private BigInteger rec5;
	@Column(name = "REC6")
	private String rec6;
	@Column(name = "GROSS")
	private BigInteger gross;
	@Column(name = "DED")
	private BigInteger ded;
	@Column(name = "NET")
	private BigInteger net;
	@Column(name = "ADDT")
	private String addt;
	@Column(name = "CALC")
	private String calc;
	@Column(name = "PAID")
	private String paid;
	@Column(name = "LDG")
	private BigInteger ldg;
	@Column(name = "LDN")
	private String ldn;
	@Column(name = "FLG")
	private String flg;
	@Column(name = "CNT")
	private BigInteger cnt;
	@Column(name = "BILLNO")
	private BigInteger billno;
	@Column(name = "CLERK")
	private String clerk;
	@Column(name = "PAN")
	private String pan;
	@Column(name = "OECOD")
	private BigInteger oecod;
	@Column(name = "HRADUE")
	private BigInteger hradue;
	@Column(name = "PBCD")
	private String pbcd;
	@Column(name = "GRDPAY")
	private String grdpay;
	@Column(name = "NCOD")
	private String ncod;
	@Column(name = "TE")
	private String te;
	@Column(name = "BLNK")
	private String blnk;
	@Column(name = "PP_EMPLOYEEMASTERID")
	private Long ppEmployeemasterid;

	public EmpPayDataJun12() {
	}

	public EmpPayDataJun12(BigDecimal id) {
		this.id = id;
	}

	public BigDecimal getId() {
		return id;
	}

	public void setId(BigDecimal id) {
		this.id = id;
	}

	public String getPcod() {
		return pcod;
	}

	public void setPcod(String pcod) {
		this.pcod = pcod;
	}

	public BigInteger getEcod() {
		return ecod;
	}

	public void setEcod(BigInteger ecod) {
		this.ecod = ecod;
	}

	public String getTtl() {
		return ttl;
	}

	public void setTtl(String ttl) {
		this.ttl = ttl;
	}

	public String getEnam() {
		return enam;
	}

	public void setEnam(String enam) {
		this.enam = enam;
	}

	public BigInteger getCdsg() {
		return cdsg;
	}

	public void setCdsg(BigInteger cdsg) {
		this.cdsg = cdsg;
	}

	public BigInteger getCdpt() {
		return cdpt;
	}

	public void setCdpt(BigInteger cdpt) {
		this.cdpt = cdpt;
	}

	public BigInteger getCat() {
		return cat;
	}

	public void setCat(BigInteger cat) {
		this.cat = cat;
	}

	public String getIncdts() {
		return incdts;
	}

	public void setIncdts(String incdts) {
		this.incdts = incdts;
	}

	public BigInteger getReg() {
		return reg;
	}

	public void setReg(BigInteger reg) {
		this.reg = reg;
	}

	public String getGpfno() {
		return gpfno;
	}

	public void setGpfno(String gpfno) {
		this.gpfno = gpfno;
	}

	public String getBnkno() {
		return bnkno;
	}

	public void setBnkno(String bnkno) {
		this.bnkno = bnkno;
	}

	public BigInteger getBnknew() {
		return bnknew;
	}

	public void setBnknew(BigInteger bnknew) {
		this.bnknew = bnknew;
	}

	public BigInteger getMnth() {
		return mnth;
	}

	public void setMnth(BigInteger mnth) {
		this.mnth = mnth;
	}

	public String getWdays() {
		return wdays;
	}

	public void setWdays(String wdays) {
		this.wdays = wdays;
	}

	public BigInteger getBasic() {
		return basic;
	}

	public void setBasic(BigInteger basic) {
		this.basic = basic;
	}

	public String getSpl() {
		return spl;
	}

	public void setSpl(String spl) {
		this.spl = spl;
	}

	public String getPrsnl() {
		return prsnl;
	}

	public void setPrsnl(String prsnl) {
		this.prsnl = prsnl;
	}

	public String getPgall() {
		return pgall;
	}

	public void setPgall(String pgall) {
		this.pgall = pgall;
	}

	public BigInteger getBilng() {
		return bilng;
	}

	public void setBilng(BigInteger bilng) {
		this.bilng = bilng;
	}

	public BigInteger getDa() {
		return da;
	}

	public void setDa(BigInteger da) {
		this.da = da;
	}

	public BigInteger getAdhda() {
		return adhda;
	}

	public void setAdhda(BigInteger adhda) {
		this.adhda = adhda;
	}

	public BigInteger getCca() {
		return cca;
	}

	public void setCca(BigInteger cca) {
		this.cca = cca;
	}

	public BigInteger getHra() {
		return hra;
	}

	public void setHra(BigInteger hra) {
		this.hra = hra;
	}

	public BigInteger getMa() {
		return ma;
	}

	public void setMa(BigInteger ma) {
		this.ma = ma;
	}

	public BigInteger getIr() {
		return ir;
	}

	public void setIr(BigInteger ir) {
		this.ir = ir;
	}

	public String getWa() {
		return wa;
	}

	public void setWa(String wa) {
		this.wa = wa;
	}

	public String getCdepu() {
		return cdepu;
	}

	public void setCdepu(String cdepu) {
		this.cdepu = cdepu;
	}

	public BigInteger getDepu() {
		return depu;
	}

	public void setDepu(BigInteger depu) {
		this.depu = depu;
	}

	public String getEar1() {
		return ear1;
	}

	public void setEar1(String ear1) {
		this.ear1 = ear1;
	}

	public String getGpfrt() {
		return gpfrt;
	}

	public void setGpfrt(String gpfrt) {
		this.gpfrt = gpfrt;
	}

	public BigInteger getGpfcnt1() {
		return gpfcnt1;
	}

	public void setGpfcnt1(BigInteger gpfcnt1) {
		this.gpfcnt1 = gpfcnt1;
	}

	public BigInteger getGpfcnt2() {
		return gpfcnt2;
	}

	public void setGpfcnt2(BigInteger gpfcnt2) {
		this.gpfcnt2 = gpfcnt2;
	}

	public BigInteger getGi() {
		return gi;
	}

	public void setGi(BigInteger gi) {
		this.gi = gi;
	}

	public String getItax() {
		return itax;
	}

	public void setItax(String itax) {
		this.itax = itax;
	}

	public BigInteger getItax2() {
		return itax2;
	}

	public void setItax2(BigInteger itax2) {
		this.itax2 = itax2;
	}

	public String getGpfr() {
		return gpfr;
	}

	public void setGpfr(String gpfr) {
		this.gpfr = gpfr;
	}

	public String getHrnt() {
		return hrnt;
	}

	public void setHrnt(String hrnt) {
		this.hrnt = hrnt;
	}

	public String getHba1() {
		return hba1;
	}

	public void setHba1(String hba1) {
		this.hba1 = hba1;
	}

	public String getHba2() {
		return hba2;
	}

	public void setHba2(String hba2) {
		this.hba2 = hba2;
	}

	public String getHrep() {
		return hrep;
	}

	public void setHrep(String hrep) {
		this.hrep = hrep;
	}

	public String getConr1() {
		return conr1;
	}

	public void setConr1(String conr1) {
		this.conr1 = conr1;
	}

	public String getConr2() {
		return conr2;
	}

	public void setConr2(String conr2) {
		this.conr2 = conr2;
	}

	public String getConr3() {
		return conr3;
	}

	public void setConr3(String conr3) {
		this.conr3 = conr3;
	}

	public String getConr4() {
		return conr4;
	}

	public void setConr4(String conr4) {
		this.conr4 = conr4;
	}

	public String getSocd() {
		return socd;
	}

	public void setSocd(String socd) {
		this.socd = socd;
	}

	public String getRec1() {
		return rec1;
	}

	public void setRec1(String rec1) {
		this.rec1 = rec1;
	}

	public String getRec2() {
		return rec2;
	}

	public void setRec2(String rec2) {
		this.rec2 = rec2;
	}

	public BigInteger getRec3() {
		return rec3;
	}

	public void setRec3(BigInteger rec3) {
		this.rec3 = rec3;
	}

	public String getRec4() {
		return rec4;
	}

	public void setRec4(String rec4) {
		this.rec4 = rec4;
	}

	public BigInteger getRec5() {
		return rec5;
	}

	public void setRec5(BigInteger rec5) {
		this.rec5 = rec5;
	}

	public String getRec6() {
		return rec6;
	}

	public void setRec6(String rec6) {
		this.rec6 = rec6;
	}

	public BigInteger getGross() {
		return gross;
	}

	public void setGross(BigInteger gross) {
		this.gross = gross;
	}

	public BigInteger getDed() {
		return ded;
	}

	public void setDed(BigInteger ded) {
		this.ded = ded;
	}

	public BigInteger getNet() {
		return net;
	}

	public void setNet(BigInteger net) {
		this.net = net;
	}

	public String getAddt() {
		return addt;
	}

	public void setAddt(String addt) {
		this.addt = addt;
	}

	public String getCalc() {
		return calc;
	}

	public void setCalc(String calc) {
		this.calc = calc;
	}

	public String getPaid() {
		return paid;
	}

	public void setPaid(String paid) {
		this.paid = paid;
	}

	public BigInteger getLdg() {
		return ldg;
	}

	public void setLdg(BigInteger ldg) {
		this.ldg = ldg;
	}

	public String getLdn() {
		return ldn;
	}

	public void setLdn(String ldn) {
		this.ldn = ldn;
	}

	public String getFlg() {
		return flg;
	}

	public void setFlg(String flg) {
		this.flg = flg;
	}

	public BigInteger getCnt() {
		return cnt;
	}

	public void setCnt(BigInteger cnt) {
		this.cnt = cnt;
	}

	public BigInteger getBillno() {
		return billno;
	}

	public void setBillno(BigInteger billno) {
		this.billno = billno;
	}

	public String getClerk() {
		return clerk;
	}

	public void setClerk(String clerk) {
		this.clerk = clerk;
	}

	public String getPan() {
		return pan;
	}

	public void setPan(String pan) {
		this.pan = pan;
	}

	public BigInteger getOecod() {
		return oecod;
	}

	public void setOecod(BigInteger oecod) {
		this.oecod = oecod;
	}

	public BigInteger getHradue() {
		return hradue;
	}

	public void setHradue(BigInteger hradue) {
		this.hradue = hradue;
	}

	public String getPbcd() {
		return pbcd;
	}

	public void setPbcd(String pbcd) {
		this.pbcd = pbcd;
	}

	public String getGrdpay() {
		return grdpay;
	}

	public void setGrdpay(String grdpay) {
		this.grdpay = grdpay;
	}

	public String getNcod() {
		return ncod;
	}

	public void setNcod(String ncod) {
		this.ncod = ncod;
	}

	public String getTe() {
		return te;
	}

	public void setTe(String te) {
		this.te = te;
	}

	public String getBlnk() {
		return blnk;
	}

	public void setBlnk(String blnk) {
		this.blnk = blnk;
	}

	public Long getPpEmployeemasterid() {
		return ppEmployeemasterid;
	}

	public void setPpEmployeemasterid(Long ppEmployeemasterid) {
		this.ppEmployeemasterid = ppEmployeemasterid;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (id != null ? id.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof EmpPayDataJun12)) {
			return false;
		}
		EmpPayDataJun12 other = (EmpPayDataJun12) object;
		if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "nicupjnentityclasses.EmpPayDataJun12[ id=" + id + " ]";
	}

}
