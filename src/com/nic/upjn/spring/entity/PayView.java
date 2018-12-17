package com.nic.upjn.spring.entity;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;


	@Entity
	@Table(name = "PayView")
	@XmlRootElement
	@NamedQueries({
	})
	public class PayView implements Serializable {
		private static final long serialVersionUID = 1L;

		@Id
		@Basic(optional = false)
		@Column(name = "PP_PAYALWMASTERID")
		private Integer pp_PayAlwMasterID;
		@Basic(optional = false)
		@Column(name = "HEADNAME")
		private String headName;
		@Basic(optional = false)
		@Column(name = "STOP_ALW_FLAG")
		private String stop_Alw_Flag;
		public Integer getPp_PayAlwMasterID() {
			return pp_PayAlwMasterID;
		}
		public void setPp_PayAlwMasterID(Integer pp_PayAlwMasterID) {
			this.pp_PayAlwMasterID = pp_PayAlwMasterID;
		}
		public String getHeadName() {
			return headName;
		}
		public void setHeadName(String headName) {
			this.headName = headName;
		}
		public String getStop_Alw_Flag() {
			return stop_Alw_Flag;
		}
		public void setStop_Alw_Flag(String stop_Alw_Flag) {
			this.stop_Alw_Flag = stop_Alw_Flag;
		}
		
	
		
		
}
