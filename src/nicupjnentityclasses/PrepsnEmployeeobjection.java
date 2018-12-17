/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nicupjnentityclasses;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "PREPSN_EMPLOYEEOBJECTION")
@XmlRootElement
@NamedQueries({
		@NamedQuery(name = "PrepsnEmployeeobjection.findAll", query = "SELECT p FROM PrepsnEmployeeobjection p"),
		@NamedQuery(name = "PrepsnEmployeeobjection.findByPrepsnEmployeeobjectionid", query = "SELECT p FROM PrepsnEmployeeobjection p WHERE p.prepsnEmployeeobjectionid = :prepsnEmployeeobjectionid"),
		@NamedQuery(name = "PrepsnEmployeeobjection.findByStatus", query = "SELECT p FROM PrepsnEmployeeobjection p WHERE p.status = :status"),
		@NamedQuery(name = "PrepsnEmployeeobjection.findByPsnObjectionlistid", query = "SELECT p FROM PrepsnEmployeeobjection p WHERE p.psnObjectionlistid = :psnObjectionlistid"),
		@NamedQuery(name = "PrepsnEmployeeobjection.findByEmployeecode", query = "SELECT p FROM PrepsnEmployeeobjection p WHERE p.employeecode = :employeecode"),
		@NamedQuery(name = "PrepsnEmployeeobjection.findByDateofobjection", query = "SELECT p FROM PrepsnEmployeeobjection p WHERE p.dateofobjection = :dateofobjection") })
public class PrepsnEmployeeobjection implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@Column(name = "PREPSN_EMPLOYEEOBJECTIONID")
	private Long prepsnEmployeeobjectionid;
	@Basic(optional = false)
	@Column(name = "STATUS")
	private Character status;
	@Basic(optional = false)
	@Column(name = "PSN_OBJECTIONLISTID")
	private long psnObjectionlistid;
	@Basic(optional = false)
	@Column(name = "EMPLOYEECODE")
	private String employeecode;
	@Column(name = "DATEOFOBJECTION")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateofobjection;
	@JoinColumn(name = "PREPSN_REGISTRATIONMASTERID", referencedColumnName = "PREPSN_REGISTRATIONMASTERID")
	@ManyToOne(optional = false)
	private PsnRegistrationmaster prepsnRegistrationmasterid;

	public PrepsnEmployeeobjection() {
	}

	public PrepsnEmployeeobjection(Long prepsnEmployeeobjectionid) {
		this.prepsnEmployeeobjectionid = prepsnEmployeeobjectionid;
	}

	public PrepsnEmployeeobjection(Long prepsnEmployeeobjectionid, Character status, long psnObjectionlistid,
			String employeecode) {
		this.prepsnEmployeeobjectionid = prepsnEmployeeobjectionid;
		this.status = status;
		this.psnObjectionlistid = psnObjectionlistid;
		this.employeecode = employeecode;
	}

	public Long getPrepsnEmployeeobjectionid() {
		return prepsnEmployeeobjectionid;
	}

	public void setPrepsnEmployeeobjectionid(Long prepsnEmployeeobjectionid) {
		this.prepsnEmployeeobjectionid = prepsnEmployeeobjectionid;
	}

	public Character getStatus() {
		return status;
	}

	public void setStatus(Character status) {
		this.status = status;
	}

	public long getPsnObjectionlistid() {
		return psnObjectionlistid;
	}

	public void setPsnObjectionlistid(long psnObjectionlistid) {
		this.psnObjectionlistid = psnObjectionlistid;
	}

	public String getEmployeecode() {
		return employeecode;
	}

	public void setEmployeecode(String employeecode) {
		this.employeecode = employeecode;
	}

	public Date getDateofobjection() {
		return dateofobjection;
	}

	public void setDateofobjection(Date dateofobjection) {
		this.dateofobjection = dateofobjection;
	}

	public PsnRegistrationmaster getPrepsnRegistrationmasterid() {
		return prepsnRegistrationmasterid;
	}

	public void setPrepsnRegistrationmasterid(PsnRegistrationmaster prepsnRegistrationmasterid) {
		this.prepsnRegistrationmasterid = prepsnRegistrationmasterid;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (prepsnEmployeeobjectionid != null ? prepsnEmployeeobjectionid.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof PrepsnEmployeeobjection)) {
			return false;
		}
		PrepsnEmployeeobjection other = (PrepsnEmployeeobjection) object;
		if ((this.prepsnEmployeeobjectionid == null && other.prepsnEmployeeobjectionid != null)
				|| (this.prepsnEmployeeobjectionid != null
						&& !this.prepsnEmployeeobjectionid.equals(other.prepsnEmployeeobjectionid))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "nicupjnentityclasses.PrepsnEmployeeobjection[ prepsnEmployeeobjectionid=" + prepsnEmployeeobjectionid
				+ " ]";
	}

}
