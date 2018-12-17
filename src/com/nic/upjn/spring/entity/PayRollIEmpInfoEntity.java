package com.nic.upjn.spring.entity;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;


	
	@Entity
	@Table(name = "PayRollIEmpInfoEntity")
	@XmlRootElement

	public class PayRollIEmpInfoEntity implements Serializable {
		private static final long serialVersionUID = 1L;

		
		
	
		@Id
		@Basic(optional = false)
		@Column(name = "employeeCode")
		private String employeeCode;
		
		@Basic(optional = false)
		@Column(name = "dateofbirth")
		private String dateofbirth;
		
		@Basic(optional = false)
		@Column(name = "fathername")
		private String fathername;
		
		@Basic(optional = false)
		@Column(name = "designation")
		private String designation;
		
		@Basic(optional = false)
		@Column(name = "sectionname")
		private String sectionname;
		
		@Basic(optional = false)
		@Column(name = "registername")
		private String registername;
		
		
		@Basic(optional = false)
		@Column(name = "officename")
		private String officename;
		
		@Basic(optional = false)
		@Column(name = "employeename")
		private String employeename;

		public String getEmployeeCode() {
			return employeeCode;
		}

		public void setEmployeeCode(String employeeCode) {
			this.employeeCode = employeeCode;
		}

		public String getDateofbirth() {
			return dateofbirth;
		}

		public void setDateofbirth(String dateofbirth) {
			this.dateofbirth = dateofbirth;
		}

		public String getFathername() {
			return fathername;
		}

		public void setFathername(String fathername) {
			this.fathername = fathername;
		}

		public String getDesignation() {
			return designation;
		}

		public void setDesignation(String designation) {
			this.designation = designation;
		}

		public String getSectionname() {
			return sectionname;
		}

		public void setSectionname(String sectionname) {
			this.sectionname = sectionname;
		}

		public String getRegistername() {
			return registername;
		}

		public void setRegistername(String registername) {
			this.registername = registername;
		}

		public String getOfficename() {
			return officename;
		}

		public void setOfficename(String officename) {
			this.officename = officename;
		}

		public String getEmployeename() {
			return employeename;
		}

		public void setEmployeename(String employeename) {
			this.employeename = employeename;
		}
		
		
		
		
		
		
}
