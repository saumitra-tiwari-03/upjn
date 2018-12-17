/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nicupjnentityclasses;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Saumitra-PC
 */
@Entity
@Table(name = "SYS_LEAVETYPEMASTER")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "SysLeavetypemaster.findAll", query = "SELECT s FROM SysLeavetypemaster s"),
		@NamedQuery(name = "SysLeavetypemaster.findBySysLeavetypemasterid", query = "SELECT s FROM SysLeavetypemaster s WHERE s.sysLeavetypemasterid = :sysLeavetypemasterid"),
		@NamedQuery(name = "SysLeavetypemaster.findByLeavetype", query = "SELECT s FROM SysLeavetypemaster s WHERE s.leavetype = :leavetype"),
		@NamedQuery(name = "SysLeavetypemaster.findByPaypercentpayble", query = "SELECT s FROM SysLeavetypemaster s WHERE s.paypercentpayble = :paypercentpayble"),
		@NamedQuery(name = "SysLeavetypemaster.findByIscreditable", query = "SELECT s FROM SysLeavetypemaster s WHERE s.iscreditable = :iscreditable"),
		@NamedQuery(name = "SysLeavetypemaster.findByMaxallowedaccumulation", query = "SELECT s FROM SysLeavetypemaster s WHERE s.maxallowedaccumulation = :maxallowedaccumulation"),
		@NamedQuery(name = "SysLeavetypemaster.findByDefaultcreditvalue", query = "SELECT s FROM SysLeavetypemaster s WHERE s.defaultcreditvalue = :defaultcreditvalue"),
		@NamedQuery(name = "SysLeavetypemaster.findByApplicablesexcode", query = "SELECT s FROM SysLeavetypemaster s WHERE s.applicablesexcode = :applicablesexcode"),
		@NamedQuery(name = "SysLeavetypemaster.findByIsfullhalfpayoptionavailable", query = "SELECT s FROM SysLeavetypemaster s WHERE s.isfullhalfpayoptionavailable = :isfullhalfpayoptionavailable"),
		@NamedQuery(name = "SysLeavetypemaster.findByIsmedical", query = "SELECT s FROM SysLeavetypemaster s WHERE s.ismedical = :ismedical") })
public class SysLeavetypemaster implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@Column(name = "SYS_LEAVETYPEMASTERID")
	private Short sysLeavetypemasterid;
	@Basic(optional = false)
	@Column(name = "LEAVETYPE")
	private String leavetype;
	@Basic(optional = false)
	@Column(name = "PAYPERCENTPAYBLE")
	private int paypercentpayble;
	@Basic(optional = false)
	@Column(name = "ISCREDITABLE")
	private String iscreditable;
	@Basic(optional = false)
	@Column(name = "MAXALLOWEDACCUMULATION")
	private short maxallowedaccumulation;
	@Basic(optional = false)
	@Column(name = "DEFAULTCREDITVALUE")
	private short defaultcreditvalue;
	@Basic(optional = false)
	@Column(name = "APPLICABLESEXCODE")
	private String applicablesexcode;
	@Basic(optional = false)
	@Column(name = "ISFULLHALFPAYOPTIONAVAILABLE")
	private String isfullhalfpayoptionavailable;
	@Basic(optional = false)
	@Column(name = "ISMEDICAL")
	private String ismedical;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "sysLeavetypemasterid")
	private Collection<PpAvailedleavedetail> ppAvailedleavedetailCollection;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "sysLeavetypemasterid")
	private Collection<PpLeaveaccount> ppLeaveaccountCollection;

	public SysLeavetypemaster() {
	}

	public SysLeavetypemaster(Short sysLeavetypemasterid) {
		this.sysLeavetypemasterid = sysLeavetypemasterid;
	}

	public SysLeavetypemaster(Short sysLeavetypemasterid, String leavetype, int paypercentpayble, String iscreditable,
			short maxallowedaccumulation, short defaultcreditvalue, String applicablesexcode,
			String isfullhalfpayoptionavailable, String ismedical) {
		this.sysLeavetypemasterid = sysLeavetypemasterid;
		this.leavetype = leavetype;
		this.paypercentpayble = paypercentpayble;
		this.iscreditable = iscreditable;
		this.maxallowedaccumulation = maxallowedaccumulation;
		this.defaultcreditvalue = defaultcreditvalue;
		this.applicablesexcode = applicablesexcode;
		this.isfullhalfpayoptionavailable = isfullhalfpayoptionavailable;
		this.ismedical = ismedical;
	}

	public Short getSysLeavetypemasterid() {
		return sysLeavetypemasterid;
	}

	public void setSysLeavetypemasterid(Short sysLeavetypemasterid) {
		this.sysLeavetypemasterid = sysLeavetypemasterid;
	}

	public String getLeavetype() {
		return leavetype;
	}

	public void setLeavetype(String leavetype) {
		this.leavetype = leavetype;
	}

	public int getPaypercentpayble() {
		return paypercentpayble;
	}

	public void setPaypercentpayble(int paypercentpayble) {
		this.paypercentpayble = paypercentpayble;
	}

	public String getIscreditable() {
		return iscreditable;
	}

	public void setIscreditable(String iscreditable) {
		this.iscreditable = iscreditable;
	}

	public short getMaxallowedaccumulation() {
		return maxallowedaccumulation;
	}

	public void setMaxallowedaccumulation(short maxallowedaccumulation) {
		this.maxallowedaccumulation = maxallowedaccumulation;
	}

	public short getDefaultcreditvalue() {
		return defaultcreditvalue;
	}

	public void setDefaultcreditvalue(short defaultcreditvalue) {
		this.defaultcreditvalue = defaultcreditvalue;
	}

	public String getApplicablesexcode() {
		return applicablesexcode;
	}

	public void setApplicablesexcode(String applicablesexcode) {
		this.applicablesexcode = applicablesexcode;
	}

	public String getIsfullhalfpayoptionavailable() {
		return isfullhalfpayoptionavailable;
	}

	public void setIsfullhalfpayoptionavailable(String isfullhalfpayoptionavailable) {
		this.isfullhalfpayoptionavailable = isfullhalfpayoptionavailable;
	}

	public String getIsmedical() {
		return ismedical;
	}

	public void setIsmedical(String ismedical) {
		this.ismedical = ismedical;
	}

	@XmlTransient
	public Collection<PpAvailedleavedetail> getPpAvailedleavedetailCollection() {
		return ppAvailedleavedetailCollection;
	}

	public void setPpAvailedleavedetailCollection(Collection<PpAvailedleavedetail> ppAvailedleavedetailCollection) {
		this.ppAvailedleavedetailCollection = ppAvailedleavedetailCollection;
	}

	@XmlTransient
	public Collection<PpLeaveaccount> getPpLeaveaccountCollection() {
		return ppLeaveaccountCollection;
	}

	public void setPpLeaveaccountCollection(Collection<PpLeaveaccount> ppLeaveaccountCollection) {
		this.ppLeaveaccountCollection = ppLeaveaccountCollection;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (sysLeavetypemasterid != null ? sysLeavetypemasterid.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof SysLeavetypemaster)) {
			return false;
		}
		SysLeavetypemaster other = (SysLeavetypemaster) object;
		if ((this.sysLeavetypemasterid == null && other.sysLeavetypemasterid != null)
				|| (this.sysLeavetypemasterid != null
						&& !this.sysLeavetypemasterid.equals(other.sysLeavetypemasterid))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "nicupjnentityclasses.SysLeavetypemaster[ sysLeavetypemasterid=" + sysLeavetypemasterid + " ]";
	}

}
