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
@Table(name = "VIEW_PP_EMPLOYEENOMINEES")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "ViewPpEmployeenominees.findAll", query = "SELECT v FROM ViewPpEmployeenominees v"),
		@NamedQuery(name = "ViewPpEmployeenominees.findByPpEmployeemasterid", query = "SELECT v FROM ViewPpEmployeenominees v WHERE v.ppEmployeemasterid = :ppEmployeemasterid"),
		@NamedQuery(name = "ViewPpEmployeenominees.findByPpEmployeenomineesid", query = "SELECT v FROM ViewPpEmployeenominees v WHERE v.ppEmployeenomineesid = :ppEmployeenomineesid"),
		@NamedQuery(name = "ViewPpEmployeenominees.findByNomineename", query = "SELECT v FROM ViewPpEmployeenominees v WHERE v.nomineename = :nomineename"),
		@NamedQuery(name = "ViewPpEmployeenominees.findByRelation", query = "SELECT v FROM ViewPpEmployeenominees v WHERE v.relation = :relation"),
		@NamedQuery(name = "ViewPpEmployeenominees.findByNomineeaddress", query = "SELECT v FROM ViewPpEmployeenominees v WHERE v.nomineeaddress = :nomineeaddress"),
		@NamedQuery(name = "ViewPpEmployeenominees.findByNomineedobdate", query = "SELECT v FROM ViewPpEmployeenominees v WHERE v.nomineedobdate = :nomineedobdate"),
		@NamedQuery(name = "ViewPpEmployeenominees.findByPpRetirementbenefitsid", query = "SELECT v FROM ViewPpEmployeenominees v WHERE v.ppRetirementbenefitsid = :ppRetirementbenefitsid"),
		@NamedQuery(name = "ViewPpEmployeenominees.findByBenifitname", query = "SELECT v FROM ViewPpEmployeenominees v WHERE v.benifitname = :benifitname"),
		@NamedQuery(name = "ViewPpEmployeenominees.findByNomineeshare", query = "SELECT v FROM ViewPpEmployeenominees v WHERE v.nomineeshare = :nomineeshare") })
public class ViewPpEmployeenominees implements Serializable {
	private static final long serialVersionUID = 1L;
	@Basic(optional = false)
	@Column(name = "PP_EMPLOYEEMASTERID")
	private long ppEmployeemasterid;
	@Basic(optional = false)
	@Column(name = "PP_EMPLOYEENOMINEESID")
	private long ppEmployeenomineesid;
	@Basic(optional = false)
	@Column(name = "NOMINEENAME")
	private String nomineename;
	@Basic(optional = false)
	@Column(name = "RELATION")
	private String relation;
	@Basic(optional = false)
	@Column(name = "NOMINEEADDRESS")
	private String nomineeaddress;
	@Column(name = "NOMINEEDOBDATE")
	private String nomineedobdate;
	@Basic(optional = false)
	@Column(name = "PP_RETIREMENTBENEFITSID")
	private short ppRetirementbenefitsid;
	@Basic(optional = false)
	@Column(name = "BENIFITNAME")
	private String benifitname;
	@Basic(optional = false)
	@Column(name = "NOMINEESHARE")
	private short nomineeshare;

	public ViewPpEmployeenominees() {
	}

	public long getPpEmployeemasterid() {
		return ppEmployeemasterid;
	}

	public void setPpEmployeemasterid(long ppEmployeemasterid) {
		this.ppEmployeemasterid = ppEmployeemasterid;
	}

	public long getPpEmployeenomineesid() {
		return ppEmployeenomineesid;
	}

	public void setPpEmployeenomineesid(long ppEmployeenomineesid) {
		this.ppEmployeenomineesid = ppEmployeenomineesid;
	}

	public String getNomineename() {
		return nomineename;
	}

	public void setNomineename(String nomineename) {
		this.nomineename = nomineename;
	}

	public String getRelation() {
		return relation;
	}

	public void setRelation(String relation) {
		this.relation = relation;
	}

	public String getNomineeaddress() {
		return nomineeaddress;
	}

	public void setNomineeaddress(String nomineeaddress) {
		this.nomineeaddress = nomineeaddress;
	}

	public String getNomineedobdate() {
		return nomineedobdate;
	}

	public void setNomineedobdate(String nomineedobdate) {
		this.nomineedobdate = nomineedobdate;
	}

	public short getPpRetirementbenefitsid() {
		return ppRetirementbenefitsid;
	}

	public void setPpRetirementbenefitsid(short ppRetirementbenefitsid) {
		this.ppRetirementbenefitsid = ppRetirementbenefitsid;
	}

	public String getBenifitname() {
		return benifitname;
	}

	public void setBenifitname(String benifitname) {
		this.benifitname = benifitname;
	}

	public short getNomineeshare() {
		return nomineeshare;
	}

	public void setNomineeshare(short nomineeshare) {
		this.nomineeshare = nomineeshare;
	}

}
