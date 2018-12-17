package com.nic.upjn.spring.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class MonPaySumRepEntity implements Serializable{

	    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		@Id
	    @Column(name = "REGISTERNAME")
	    private String registername;
	    @Column(name = "EMPNO")
	    private String empno;
	    @Column(name = "B_PAY")
	    private String b_pay;
	    @Column(name = "MEDALW")
	    private String medalw;
	    @Column(name = "DA")
	    private String da;
	    @Column(name = "CCA")
	    private String cca;
	    @Column(name = "D_PAY")
	    private String d_pay;
	    @Column(name = "HRA")
	    private String hra;
	    @Column(name = "G_PAY")
	    private String g_pay;
	    @Column(name = "PERS_PAY")
	    private String pers_pay;
	    @Column(name = "SPL_PAY")
	    private String spl_pay;
	    @Column(name = "WS_ALW")
	    private String ws_alw;
	    @Column(name = "PG_ALW")
	    private String pg_alw;
	    @Column(name = "BLG_CMPT")
	    private String blg_cmpt;
	    @Column(name = "OTH_ALW")
	    private String oth_alw;
	    @Column(name = "GPF")
	    private String gpf;
	    @Column(name = "ITAX")
	    private String itax;
	    @Column(name = "GPF_ADV")
	    private String gpf_adv;
	    @Column(name = "HBA")
	    private String hba;
	    @Column(name = "HSREPADV")
	    private String hsrepadv;
	    @Column(name = "HBA_HDFC")
	    private String hba_hdfc;
	    @Column(name = "CAR_ADV")
	    private String car_adv;
	    @Column(name = "SOC_DED")
	    private String soc_ded;
	    @Column(name = "HS_RENT")
	    private String hs_rent;
	    @Column(name = "GIS")
	    private String gis;
	    @Column(name = "CLTH_DED")
	    private String clth_ded;
	    @Column(name = "KKD_DED")
	    private String kkd_ded;
	    @Column(name = "MISC_DED")
	    private String misc_ded;
	    @Column(name = "LIP")
	    private String lip;
	    @Column(name = "REG_EMP")
	    private String reg_emp;
	    @Column(name = "EMP_ARR")
	    private String emp_arr;
	    @Column(name = "REG_EMLR")
	    private String reg_emlr;
	    @Column(name = "EMLR_ARR")
	    private String emlr_arr;
	    @Column(name = "GROSS")
	    private String gross;
	    @Column(name = "TOTAL_DED")
	    private String total_ded;
	    @Column(name = "NET_PAYABLE")
	    private String net_payable;
		
	    public String getRegistername() {
			return registername;
		}
		public void setRegistername(String registername) {
			this.registername = registername;
		}
		public String getEmpno() {
			return empno;
		}
		public void setEmpno(String empno) {
			this.empno = empno;
		}
		public String getB_pay() {
			return b_pay;
		}
		public void setB_pay(String b_pay) {
			this.b_pay = b_pay;
		}
		public String getMedalw() {
			return medalw;
		}
		public void setMedalw(String medalw) {
			this.medalw = medalw;
		}
		public String getDa() {
			return da;
		}
		public void setDa(String da) {
			this.da = da;
		}
		public String getCca() {
			return cca;
		}
		public void setCca(String cca) {
			this.cca = cca;
		}
		public String getD_pay() {
			return d_pay;
		}
		public void setD_pay(String d_pay) {
			this.d_pay = d_pay;
		}
		public String getHra() {
			return hra;
		}
		public void setHra(String hra) {
			this.hra = hra;
		}
		public String getG_pay() {
			return g_pay;
		}
		public void setG_pay(String g_pay) {
			this.g_pay = g_pay;
		}
		public String getPers_pay() {
			return pers_pay;
		}
		public void setPers_pay(String pers_pay) {
			this.pers_pay = pers_pay;
		}
		public String getSpl_pay() {
			return spl_pay;
		}
		public void setSpl_pay(String spl_pay) {
			this.spl_pay = spl_pay;
		}
		public String getWs_alw() {
			return ws_alw;
		}
		public void setWs_alw(String ws_alw) {
			this.ws_alw = ws_alw;
		}
		public String getPg_alw() {
			return pg_alw;
		}
		public void setPg_alw(String pg_alw) {
			this.pg_alw = pg_alw;
		}
		public String getBlg_cmpt() {
			return blg_cmpt;
		}
		public void setBlg_cmpt(String blg_cmpt) {
			this.blg_cmpt = blg_cmpt;
		}
		public String getOth_alw() {
			return oth_alw;
		}
		public void setOth_alw(String oth_alw) {
			this.oth_alw = oth_alw;
		}
		public String getGpf() {
			return gpf;
		}
		public void setGpf(String gpf) {
			this.gpf = gpf;
		}
		public String getItax() {
			return itax;
		}
		public void setItax(String itax) {
			this.itax = itax;
		}
		public String getGpf_adv() {
			return gpf_adv;
		}
		public void setGpf_adv(String gpf_adv) {
			this.gpf_adv = gpf_adv;
		}
		public String getHba() {
			return hba;
		}
		public void setHba(String hba) {
			this.hba = hba;
		}
		public String getHsrepadv() {
			return hsrepadv;
		}
		public void setHsrepadv(String hsrepadv) {
			this.hsrepadv = hsrepadv;
		}
		public String getHba_hdfc() {
			return hba_hdfc;
		}
		public void setHba_hdfc(String hba_hdfc) {
			this.hba_hdfc = hba_hdfc;
		}
		public String getCar_adv() {
			return car_adv;
		}
		public void setCar_adv(String car_adv) {
			this.car_adv = car_adv;
		}
		public String getSoc_ded() {
			return soc_ded;
		}
		public void setSoc_ded(String soc_ded) {
			this.soc_ded = soc_ded;
		}
		public String getHs_rent() {
			return hs_rent;
		}
		public void setHs_rent(String hs_rent) {
			this.hs_rent = hs_rent;
		}
		public String getGis() {
			return gis;
		}
		public void setGis(String gis) {
			this.gis = gis;
		}
		public String getClth_ded() {
			return clth_ded;
		}
		public void setClth_ded(String clth_ded) {
			this.clth_ded = clth_ded;
		}
		public String getKkd_ded() {
			return kkd_ded;
		}
		public void setKkd_ded(String kkd_ded) {
			this.kkd_ded = kkd_ded;
		}
		public String getMisc_ded() {
			return misc_ded;
		}
		public void setMisc_ded(String misc_ded) {
			this.misc_ded = misc_ded;
		}
		public String getLip() {
			return lip;
		}
		public void setLip(String lip) {
			this.lip = lip;
		}
		public String getReg_emp() {
			return reg_emp;
		}
		public void setReg_emp(String reg_emp) {
			this.reg_emp = reg_emp;
		}
		public String getEmp_arr() {
			return emp_arr;
		}
		public void setEmp_arr(String emp_arr) {
			this.emp_arr = emp_arr;
		}
		public String getReg_emlr() {
			return reg_emlr;
		}
		public void setReg_emlr(String reg_emlr) {
			this.reg_emlr = reg_emlr;
		}
		public String getEmlr_arr() {
			return emlr_arr;
		}
		public void setEmlr_arr(String emlr_arr) {
			this.emlr_arr = emlr_arr;
		}
		public String getGross() {
			return gross;
		}
		public void setGross(String gross) {
			this.gross = gross;
		}
		public String getTotal_ded() {
			return total_ded;
		}
		public void setTotal_ded(String total_ded) {
			this.total_ded = total_ded;
		}
		public String getNet_payable() {
			return net_payable;
		}
		public void setNet_payable(String net_payable) {
			this.net_payable = net_payable;
		}
	   
	   
          
	    
}
