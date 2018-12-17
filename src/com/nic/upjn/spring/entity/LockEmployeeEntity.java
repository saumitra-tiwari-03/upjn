
	package com.nic.upjn.spring.entity;

	import java.io.Serializable;

	import javax.persistence.Basic;
	import javax.persistence.Column;
	import javax.persistence.Entity;
	import javax.persistence.Id;
	import javax.persistence.Table;
	import javax.xml.bind.annotation.XmlRootElement;


		
		
		@Entity
		@Table(name = "LockEmployeeEntity")
		@XmlRootElement

		public class LockEmployeeEntity implements Serializable {
			private static final long serialVersionUID = 1L;

			@Id
			@Basic(optional = false)
			@Column(name = "PP_EMPLOYEEMASTERID")
			private Long pp_EmployeeMasterID;

			@Basic(optional = false)
			@Column(name = "BILLFLAG")
			private String billFlag;

			public Long getPp_EmployeeMasterID() {
				return pp_EmployeeMasterID;
			}

			public void setPp_EmployeeMasterID(Long pp_EmployeeMasterID) {
				this.pp_EmployeeMasterID = pp_EmployeeMasterID;
			}

			public String getBillFlag() {
				return billFlag;
			}

			public void setBillFlag(String billFlag) {
				this.billFlag = billFlag;
			}

			
			
			

}
