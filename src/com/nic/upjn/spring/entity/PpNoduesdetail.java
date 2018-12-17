/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nic.upjn.spring.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author Saumitra-PC
 */
@Entity
@Table(name = "PP_NODUESDETAIL")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "PpNoduesdetail.findAll", query = "SELECT p FROM PpNoduesdetail p"),
		@NamedQuery(name = "PpNoduesdetail.findByPpNoduesdetailid", query = "SELECT p FROM PpNoduesdetail p WHERE p.ppNoduesdetailid = :ppNoduesdetailid"),
		@NamedQuery(name = "PpNoduesdetail.findByNoduesordno", query = "SELECT p FROM PpNoduesdetail p WHERE p.noduesordno = :noduesordno"),
		/*** Insert query ***/
		//@NamedQuery(name = "Insert", query = "INSERT into PpNoduesdetail (ppEmployeemasterid,noduesordno,noduesorddate,ison) values (?,?,?,?)"),
		@NamedQuery(name = "PpNoduesdetail.findByNoduesorddate", query = "SELECT p FROM PpNoduesdetail p WHERE p.noduesorddate = :noduesorddate"),
		@NamedQuery(name = "PpNoduesdetail.findByIson", query = "SELECT p FROM PpNoduesdetail p WHERE p.ison = :ison") })
public class PpNoduesdetail implements Serializable {
	private static final long serialVersionUID = 1L;
	@GeneratedValue(strategy=GenerationType.AUTO, generator = "id_Sequence")
	@SequenceGenerator(name = "id_Sequence", sequenceName = "SEQ_PP_NODUESDETAIL")
	@Id
	@Basic(optional = false)
	@Column(name = "PP_NODUESDETAILID")
	private Long ppNoduesdetailid;
	@Basic(optional = false)
	@Column(name = "NODUESORDNO")
	private String noduesordno;
	@Basic(optional = false)
	@Column(name = "NODUESORDDATE")
	/*@Temporal(TemporalType.TIMESTAMP)*/
	private Date noduesorddate;
	@Basic(optional = false)
	@Column(name = "ISON")
	private Character ison;
	@Column(name = "PP_EmployeeMasterID")
	private Long ppEmployeemasterid;
	
	/*@OneToMany(mappedBy = "ppNoduesdetailid")	
	private Collection<PpRelievefromservice> ppRelievefromserviceCollection;
	
	@JoinColumn(name = "PP_EMPLOYEEMASTERID", referencedColumnName = "PP_EMPLOYEEMASTERID")
	@ManyToOne(optional = false)	
	private long ppEmployeemasterid;*/

	public PpNoduesdetail() {
	}

	public PpNoduesdetail(Long ppNoduesdetailid) {
		this.ppNoduesdetailid = ppNoduesdetailid;
	}

	public PpNoduesdetail(Long ppNoduesdetailid, String noduesordno, Date noduesorddate, Character ison) {
		this.ppNoduesdetailid = ppNoduesdetailid;
		this.noduesordno = noduesordno;
		this.noduesorddate = noduesorddate;
		this.ison = ison;
	}

	public Long getPpEmployeemasterid() {
		return ppEmployeemasterid;
	}

	public void setPpEmployeemasterid(Long ppEmployeemasterid) {
		this.ppEmployeemasterid = ppEmployeemasterid;
	}

	public Long getPpNoduesdetailid() {
		return ppNoduesdetailid;
	}

	public void setPpNoduesdetailid(Long ppNoduesdetailid) {
		this.ppNoduesdetailid = ppNoduesdetailid;
	}

	public String getNoduesordno() {
		return noduesordno;
	}

	public void setNoduesordno(String noduesordno) {
		this.noduesordno = noduesordno;
	}

	public Date getNoduesorddate() {
		return noduesorddate;
	}

	public void setNoduesorddate(Date noduesorddate) {
		this.noduesorddate = noduesorddate;
	}

	public Character getIson() {
		return ison;
	}

	public void setIson(Character ison) {
		this.ison = ison;
	}

	
	public String toString()
	{
		return(ppEmployeemasterid+" "+ppNoduesdetailid+" "+noduesordno+" "+noduesorddate+" "+ison);
	}
	/*@XmlTransient
	public Collection<PpRelievefromservice> getPpRelievefromserviceCollection() {
		return ppRelievefromserviceCollection;
	}

	public void setPpRelievefromserviceCollection(Collection<PpRelievefromservice> ppRelievefromserviceCollection) {
		this.ppRelievefromserviceCollection = ppRelievefromserviceCollection;
	}

	public long getPpEmployeemasterid() {
		return ppEmployeemasterid;
	}

	public void setPpEmployeemasterid(long ppEmployeemasterid) {
		this.ppEmployeemasterid = ppEmployeemasterid;
	}*/
	
	@Override
	public int hashCode() {
		int hash = 0;
		hash += (ppNoduesdetailid != null ? ppNoduesdetailid.hashCode() : 0);
		return hash;
	}

	

	@Override
	public boolean equals(Object object) {
		
		if (!(object instanceof PpNoduesdetail)) {
			return false;
		}
		PpNoduesdetail other = (PpNoduesdetail) object;
		if ((this.ppNoduesdetailid == null && other.ppNoduesdetailid != null)
				|| (this.ppNoduesdetailid != null && !this.ppNoduesdetailid.equals(other.ppNoduesdetailid))) {
			return false;
		}
		return true;
	}

	/*@Override
	public String toString() {
		return "nicupjnentityclasses.PpNoduesdetail[ ppNoduesdetailid=" + ppNoduesdetailid + " ]";
	}*/

}
