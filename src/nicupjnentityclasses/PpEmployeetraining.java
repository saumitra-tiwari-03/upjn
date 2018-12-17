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
@Table(name = "PP_EMPLOYEETRAINING")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "PpEmployeetraining.findAll", query = "SELECT p FROM PpEmployeetraining p"),
		@NamedQuery(name = "PpEmployeetraining.findByPpEmployeetrainingid", query = "SELECT p FROM PpEmployeetraining p WHERE p.ppEmployeetrainingid = :ppEmployeetrainingid"),
		@NamedQuery(name = "PpEmployeetraining.findByPpTrainingtypemasterid", query = "SELECT p FROM PpEmployeetraining p WHERE p.ppTrainingtypemasterid = :ppTrainingtypemasterid"),
		@NamedQuery(name = "PpEmployeetraining.findByTrainingstartdate", query = "SELECT p FROM PpEmployeetraining p WHERE p.trainingstartdate = :trainingstartdate"),
		@NamedQuery(name = "PpEmployeetraining.findByTrainingenddate", query = "SELECT p FROM PpEmployeetraining p WHERE p.trainingenddate = :trainingenddate"),
		@NamedQuery(name = "PpEmployeetraining.findByIsabroad", query = "SELECT p FROM PpEmployeetraining p WHERE p.isabroad = :isabroad"),
		@NamedQuery(name = "PpEmployeetraining.findByIsdepartmental", query = "SELECT p FROM PpEmployeetraining p WHERE p.isdepartmental = :isdepartmental"),
		@NamedQuery(name = "PpEmployeetraining.findByTrainingvenue", query = "SELECT p FROM PpEmployeetraining p WHERE p.trainingvenue = :trainingvenue"),
		@NamedQuery(name = "PpEmployeetraining.findByTrainingsubject", query = "SELECT p FROM PpEmployeetraining p WHERE p.trainingsubject = :trainingsubject"),
		@NamedQuery(name = "PpEmployeetraining.findByOrganizer", query = "SELECT p FROM PpEmployeetraining p WHERE p.organizer = :organizer"),
		@NamedQuery(name = "PpEmployeetraining.findByOrderno", query = "SELECT p FROM PpEmployeetraining p WHERE p.orderno = :orderno"),
		@NamedQuery(name = "PpEmployeetraining.findByOrderdate", query = "SELECT p FROM PpEmployeetraining p WHERE p.orderdate = :orderdate") })
public class PpEmployeetraining implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@Column(name = "PP_EMPLOYEETRAININGID")
	private Long ppEmployeetrainingid;
	@Basic(optional = false)
	@Column(name = "PP_TRAININGTYPEMASTERID")
	private int ppTrainingtypemasterid;
	@Basic(optional = false)
	@Column(name = "TRAININGSTARTDATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date trainingstartdate;
	@Basic(optional = false)
	@Column(name = "TRAININGENDDATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date trainingenddate;
	@Basic(optional = false)
	@Column(name = "ISABROAD")
	private Character isabroad;
	@Basic(optional = false)
	@Column(name = "ISDEPARTMENTAL")
	private Character isdepartmental;
	@Column(name = "TRAININGVENUE")
	private String trainingvenue;
	@Column(name = "TRAININGSUBJECT")
	private String trainingsubject;
	@Column(name = "ORGANIZER")
	private String organizer;
	@Column(name = "ORDERNO")
	private String orderno;
	@Column(name = "ORDERDATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date orderdate;
	@JoinColumn(name = "PP_EMPLOYEEMASTERID", referencedColumnName = "PP_EMPLOYEEMASTERID")
	@ManyToOne(optional = false)
	private PpEmployeemaster ppEmployeemasterid;

	public PpEmployeetraining() {
	}

	public PpEmployeetraining(Long ppEmployeetrainingid) {
		this.ppEmployeetrainingid = ppEmployeetrainingid;
	}

	public PpEmployeetraining(Long ppEmployeetrainingid, int ppTrainingtypemasterid, Date trainingstartdate,
			Date trainingenddate, Character isabroad, Character isdepartmental) {
		this.ppEmployeetrainingid = ppEmployeetrainingid;
		this.ppTrainingtypemasterid = ppTrainingtypemasterid;
		this.trainingstartdate = trainingstartdate;
		this.trainingenddate = trainingenddate;
		this.isabroad = isabroad;
		this.isdepartmental = isdepartmental;
	}

	public Long getPpEmployeetrainingid() {
		return ppEmployeetrainingid;
	}

	public void setPpEmployeetrainingid(Long ppEmployeetrainingid) {
		this.ppEmployeetrainingid = ppEmployeetrainingid;
	}

	public int getPpTrainingtypemasterid() {
		return ppTrainingtypemasterid;
	}

	public void setPpTrainingtypemasterid(int ppTrainingtypemasterid) {
		this.ppTrainingtypemasterid = ppTrainingtypemasterid;
	}

	public Date getTrainingstartdate() {
		return trainingstartdate;
	}

	public void setTrainingstartdate(Date trainingstartdate) {
		this.trainingstartdate = trainingstartdate;
	}

	public Date getTrainingenddate() {
		return trainingenddate;
	}

	public void setTrainingenddate(Date trainingenddate) {
		this.trainingenddate = trainingenddate;
	}

	public Character getIsabroad() {
		return isabroad;
	}

	public void setIsabroad(Character isabroad) {
		this.isabroad = isabroad;
	}

	public Character getIsdepartmental() {
		return isdepartmental;
	}

	public void setIsdepartmental(Character isdepartmental) {
		this.isdepartmental = isdepartmental;
	}

	public String getTrainingvenue() {
		return trainingvenue;
	}

	public void setTrainingvenue(String trainingvenue) {
		this.trainingvenue = trainingvenue;
	}

	public String getTrainingsubject() {
		return trainingsubject;
	}

	public void setTrainingsubject(String trainingsubject) {
		this.trainingsubject = trainingsubject;
	}

	public String getOrganizer() {
		return organizer;
	}

	public void setOrganizer(String organizer) {
		this.organizer = organizer;
	}

	public String getOrderno() {
		return orderno;
	}

	public void setOrderno(String orderno) {
		this.orderno = orderno;
	}

	public Date getOrderdate() {
		return orderdate;
	}

	public void setOrderdate(Date orderdate) {
		this.orderdate = orderdate;
	}

	public PpEmployeemaster getPpEmployeemasterid() {
		return ppEmployeemasterid;
	}

	public void setPpEmployeemasterid(PpEmployeemaster ppEmployeemasterid) {
		this.ppEmployeemasterid = ppEmployeemasterid;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (ppEmployeetrainingid != null ? ppEmployeetrainingid.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof PpEmployeetraining)) {
			return false;
		}
		PpEmployeetraining other = (PpEmployeetraining) object;
		if ((this.ppEmployeetrainingid == null && other.ppEmployeetrainingid != null)
				|| (this.ppEmployeetrainingid != null
						&& !this.ppEmployeetrainingid.equals(other.ppEmployeetrainingid))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "nicupjnentityclasses.PpEmployeetraining[ ppEmployeetrainingid=" + ppEmployeetrainingid + " ]";
	}

}
