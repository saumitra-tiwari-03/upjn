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
@Table(name = "SUBSERVICEPHASE_VIEW")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "SubservicephaseView.findAll", query = "SELECT s FROM SubservicephaseView s"),
		@NamedQuery(name = "SubservicephaseView.findBySysSubservicephasemasterid", query = "SELECT s FROM SubservicephaseView s WHERE s.sysSubservicephasemasterid = :sysSubservicephasemasterid"),
		@NamedQuery(name = "SubservicephaseView.findBySubphasename", query = "SELECT s FROM SubservicephaseView s WHERE s.subphasename = :subphasename"),
		@NamedQuery(name = "SubservicephaseView.findByServicephasename", query = "SELECT s FROM SubservicephaseView s WHERE s.servicephasename = :servicephasename") })
public class SubservicephaseView implements Serializable {
	private static final long serialVersionUID = 1L;
	@Basic(optional = false)
	@Column(name = "SYS_SUBSERVICEPHASEMASTERID")
	private short sysSubservicephasemasterid;
	@Basic(optional = false)
	@Column(name = "SUBPHASENAME")
	private String subphasename;
	@Basic(optional = false)
	@Column(name = "SERVICEPHASENAME")
	private String servicephasename;

	public SubservicephaseView() {
	}

	public short getSysSubservicephasemasterid() {
		return sysSubservicephasemasterid;
	}

	public void setSysSubservicephasemasterid(short sysSubservicephasemasterid) {
		this.sysSubservicephasemasterid = sysSubservicephasemasterid;
	}

	public String getSubphasename() {
		return subphasename;
	}

	public void setSubphasename(String subphasename) {
		this.subphasename = subphasename;
	}

	public String getServicephasename() {
		return servicephasename;
	}

	public void setServicephasename(String servicephasename) {
		this.servicephasename = servicephasename;
	}

}
