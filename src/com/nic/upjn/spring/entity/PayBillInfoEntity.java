package com.nic.upjn.spring.entity;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;


	
	
	@Entity
	@Table(name = "PayBillInfoEntity")
	@XmlRootElement

	public class PayBillInfoEntity implements Serializable {
		private static final long serialVersionUID = 1L;

		@Id
		@Basic(optional = false)
		@Column(name = "PP_PAYBILLDETAILID")
		private Long ppPaybilldetailid;

		@Basic(optional = false)
		@Column(name = "BILLCLERKNAME")
		private String billclerkname;

		@Basic(optional = false)
		@Column(name = "MONTH")
		private String month;

		@Basic(optional = false)
		@Column(name = "YEAR")
		private String year;

		@Basic(optional = false)
		@Column(name = "BILL_AMOUNT")
		private String billamount;

		@Basic(optional = false)
		@Column(name = "NET_PAY")
		private String netpay;

		@Basic(optional = false)
		@Column(name = "DESCRIPTION")
		private String description;
		
		@Basic(optional = false)
		@Column(name = "PP_REGISTERMASTERID")
		private short ppRegistermasterid;

		
		@Basic(optional = false)
		@Column(name = "REGISTERNAME")
		private String registername;
		
		
		
		


		
		public Long getPpPaybilldetailid() {
			return ppPaybilldetailid;
		}


		public void setPpPaybilldetailid(Long ppPaybilldetailid) {
			this.ppPaybilldetailid = ppPaybilldetailid;
		}


		public String getBillclerkname() {
			return billclerkname;
		}


		public void setBillclerkname(String billclerkname) {
			this.billclerkname = billclerkname;
		}


		public String getMonth() {
			return month;
		}


		public void setMonth(String month) {
			this.month = month;
		}


		public String getYear() {
			return year;
		}


		public void setYear(String year) {
			this.year = year;
		}


		public String getBillamount() {
			return billamount;
		}


		public void setBillamount(String billamount) {
			this.billamount = billamount;
		}


		public String getNetpay() {
			return netpay;
		}


		public void setNetpay(String netpay) {
			this.netpay = netpay;
		}


		public String getDescription() {
			return description;
		}


		public void setDescription(String description) {
			this.description = description;
		}


		public short getPpRegistermasterid() {
			return ppRegistermasterid;
		}


		public void setPpRegistermasterid(short ppRegistermasterid) {
			this.ppRegistermasterid = ppRegistermasterid;
		}


		public String getRegistername() {
			return registername;
		}


		public void setRegistername(String registername) {
			this.registername = registername;
		}
		
		
		
		
		


}
