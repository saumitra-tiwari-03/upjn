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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Saumitra-PC
 */
@Entity
@Table(name = "VIEW_NOMINATION_DATE")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "ViewNominationDate.findAll", query = "SELECT v FROM ViewNominationDate v"),
		@NamedQuery(name = "ViewNominationDate.findByColumnName", query = "SELECT v FROM ViewNominationDate v WHERE v.columnName = :columnName"),
		@NamedQuery(name = "ViewNominationDate.findByBenifitname", query = "SELECT v FROM ViewNominationDate v WHERE v.benifitname = :benifitname"),
		@NamedQuery(name = "ViewNominationDate.findByNominDateField", query = "SELECT v FROM ViewNominationDate v WHERE v.nominDateField = :nominDateField") })
public class ViewNominationDate implements Serializable {
	private static final long serialVersionUID = 1L;
	@Basic(optional = false)
	@Column(name = "COLUMN_NAME")
	private String columnName;
	@Basic(optional = false)
	@Column(name = "BENIFITNAME")
	private String benifitname;
	@Column(name = "NOMIN_DATE_FIELD")
	private String nominDateField;
	@JoinColumn(name = "PP_EMPLOYEEMASTERID", referencedColumnName = "PP_EMPLOYEEMASTERID")
	@ManyToOne(optional = false)
	private PpEmployeemaster ppEmployeemasterid;

	public ViewNominationDate() {
	}

	public String getColumnName() {
		return columnName;
	}

	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}

	public String getBenifitname() {
		return benifitname;
	}

	public void setBenifitname(String benifitname) {
		this.benifitname = benifitname;
	}

	public String getNominDateField() {
		return nominDateField;
	}

	public void setNominDateField(String nominDateField) {
		this.nominDateField = nominDateField;
	}

	public PpEmployeemaster getPpEmployeemasterid() {
		return ppEmployeemasterid;
	}

	public void setPpEmployeemasterid(PpEmployeemaster ppEmployeemasterid) {
		this.ppEmployeemasterid = ppEmployeemasterid;
	}

}
